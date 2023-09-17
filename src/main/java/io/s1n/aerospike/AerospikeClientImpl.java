package io.s1n.aerospike;

import static io.s1n.aerospike.listeners.Listeners.arrayListener;
import static io.s1n.aerospike.listeners.Listeners.batchListener;
import static io.s1n.aerospike.listeners.Listeners.deleteListener;
import static io.s1n.aerospike.listeners.Listeners.executeListener;
import static io.s1n.aerospike.listeners.Listeners.existsArrayListener;
import static io.s1n.aerospike.listeners.Listeners.existsListener;
import static io.s1n.aerospike.listeners.Listeners.queryListener;
import static io.s1n.aerospike.listeners.Listeners.recordListener;
import static io.s1n.aerospike.listeners.Listeners.writeListener;
import static io.s1n.aerospike.util.SharedDataUtils.getInstanceName;
import static io.s1n.aerospike.util.SharedDataUtils.removeInstanceByName;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.BatchRead;
import com.aerospike.client.Bin;
import com.aerospike.client.Host;
import com.aerospike.client.Key;
import com.aerospike.client.Operation;
import com.aerospike.client.Record;
import com.aerospike.client.ResultCode;
import com.aerospike.client.Value;
import com.aerospike.client.async.EventLoops;
import com.aerospike.client.cluster.ClusterStats;
import com.aerospike.client.policy.BatchPolicy;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.QueryPolicy;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.KeyRecord;
import com.aerospike.client.query.PartitionFilter;
import com.aerospike.client.query.Statement;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.impl.VertxInternal;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.locks.LockSupport;
import org.jboss.logging.Logger;

public class AerospikeClientImpl implements AerospikeClient {

  private static final Logger LOG = Logger.getLogger(AerospikeClient.class);

  private final VertxInternal vertx;
  private final EventLoops eventLoops;
  private final AerospikeConnectOptions ops;
  private com.aerospike.client.AerospikeClient client;

  public AerospikeClientImpl(Vertx vertx, AerospikeConnectOptions connectOptions) {
    this.vertx = (VertxInternal) vertx;
    this.ops = connectOptions;
    this.client = connectClientWithRetry(0);
    eventLoops = connectOptions.getClientPolicy().eventLoops;
  }

  public com.aerospike.client.AerospikeClient getClient() {
    return this.client;
  }

  private <T> void schedule(Handler<Promise<T>> handler, Handler<AsyncResult<T>> resultHandler) {
    vertx.getOrCreateContext().executeBlocking(promise -> {
      try {
        handler.handle(promise);
      } catch (AerospikeException e) {
        promise.fail(e);
      }
    }, false, resultHandler);
  }

  private com.aerospike.client.AerospikeClient connectClientWithRetry(int retryCount) {
    if (this.ops.getMaxConnectRetries() != -1 && retryCount > this.ops.getMaxConnectRetries()) {
      LOG.warnv("Exhausted max connection retries after {0} attempts", retryCount);
      throw new AerospikeException(ResultCode.MAX_RETRIES_EXCEEDED, "Cannot connect to Aerospike");
    } else {
      try {
        LockSupport.parkNanos(Duration.ofMillis(100).toNanos());
        return new com.aerospike.client.AerospikeClient(
            ops.getClientPolicy(),
            new Host(ops.getHost(), ops.getPort())
        );
      } catch (Exception e) {
        LOG.warn("Error while connecting to aerospike");
        LOG.info("Retrying to connect to aerospike");
        return connectClientWithRetry(retryCount + 1);
      }
    }
  }

  @Override
  public AerospikeClient isConnected(Handler<AsyncResult<Boolean>> handler) {
    this.schedule(promise -> promise.complete(this.client.isConnected()), handler);
    return this;
  }

  @Override
  public AerospikeClient getClusterStats(Handler<AsyncResult<ClusterStats>> handler) {
    this.schedule(promise -> promise.complete(this.client.getClusterStats()), handler);
    return this;
  }

  public void close() {
    if (client != null) {
      client.close();
      removeInstanceByName(vertx, getInstanceName(ops.getHost(), ops.getPort()));
      client = null;
    }
  }

  public AerospikeClient put(WritePolicy writePolicy, Key key, Bin[] bins,
      Handler<AsyncResult<Key>> handler) throws AerospikeException {
    this.client.put(this.eventLoops.next(),
        writeListener(vertx.getOrCreateContext(), handler),
        writePolicy, key, bins);
    return this;
  }

  public AerospikeClient append(WritePolicy writePolicy, Key key, Bin[] bins,
      Handler<AsyncResult<Key>> handler) throws AerospikeException {
    client.append(eventLoops.next(), writeListener(this.vertx.getOrCreateContext(), handler),
        writePolicy, key, bins);
    return this;
  }

  public AerospikeClient prepend(WritePolicy writePolicy, Key key, Bin[] bins,
      Handler<AsyncResult<Key>> handler) throws AerospikeException {
    client.prepend(eventLoops.next(), writeListener(this.vertx.getOrCreateContext(), handler),
        writePolicy, key, bins);
    return this;
  }

  public AerospikeClient add(WritePolicy writePolicy, Key key, Bin[] bins,
      Handler<AsyncResult<Key>> handler) throws AerospikeException {
    client.add(eventLoops.next(), writeListener(vertx.getOrCreateContext(), handler),
        writePolicy, key, bins);
    return this;
  }

  public AerospikeClient delete(WritePolicy writePolicy, Key key,
      Handler<AsyncResult<Boolean>> handler) throws AerospikeException {
    client.delete(eventLoops.next(), deleteListener(this.vertx.getOrCreateContext(), handler),
        writePolicy, key);
    return this;
  }

  public AerospikeClient touch(WritePolicy writePolicy, Key key, Handler<AsyncResult<Key>> handler)
      throws AerospikeException {
    client.touch(eventLoops.next(), writeListener(vertx.getOrCreateContext(), handler),
        writePolicy, key);
    return this;
  }

  public AerospikeClient exists(Policy policy, Key key, Handler<AsyncResult<Boolean>> handler)
      throws AerospikeException {
    client.exists(eventLoops.next(), existsListener(vertx.getOrCreateContext(), handler),
        policy, key);
    return this;
  }

  public AerospikeClient exists(BatchPolicy batchPolicy, Key[] keys,
      Handler<AsyncResult<List<Boolean>>> handler) throws AerospikeException {
    client.exists(eventLoops.next(), existsArrayListener(vertx.getOrCreateContext(), handler),
        batchPolicy, keys);
    return this;
  }

  public AerospikeClient get(Policy policy, Key key, Handler<AsyncResult<Record>> handler)
      throws AerospikeException {
    client.get(eventLoops.next(), recordListener(this.vertx.getOrCreateContext(), handler),
        policy, key);
    return this;
  }

  public AerospikeClient get(Policy policy, Key key, String[] binNames,
      Handler<AsyncResult<Record>> handler) throws AerospikeException {
    client.get(eventLoops.next(), recordListener(vertx.getOrCreateContext(), handler),
        policy, key, binNames);
    return this;
  }

  public AerospikeClient getHeader(Policy policy, Key key, Handler<AsyncResult<Record>> handler)
      throws AerospikeException {
    client.getHeader(eventLoops.next(),
        recordListener(vertx.getOrCreateContext(), handler), policy, key);
    return this;
  }

  public AerospikeClient get(BatchPolicy batchPolicy, List<BatchRead> records,
      Handler<AsyncResult<List<BatchRead>>> handler) throws AerospikeException {
    client.get(eventLoops.next(), batchListener(vertx.getOrCreateContext(), handler),
        batchPolicy, records);
    return this;
  }

  public AerospikeClient get(BatchPolicy batchPolicy, Key[] keys,
      Handler<AsyncResult<List<Record>>> handler) throws AerospikeException {
    client.get(eventLoops.next(), arrayListener(vertx.getOrCreateContext(), handler),
        batchPolicy, keys);
    return this;
  }

  public AerospikeClient get(BatchPolicy batchPolicy, Key[] keys, String[] binNames,
      Handler<AsyncResult<List<Record>>> handler) throws AerospikeException {
    client.get(eventLoops.next(), arrayListener(vertx.getOrCreateContext(), handler),
        batchPolicy, keys, binNames);
    return this;
  }

  public AerospikeClient getHeader(BatchPolicy batchPolicy, Key[] keys,
      Handler<AsyncResult<List<Record>>> handler) throws AerospikeException {
    client.getHeader(eventLoops.next(), arrayListener(vertx.getOrCreateContext(), handler),
        batchPolicy, keys);
    return this;
  }

  public AerospikeClient operate(WritePolicy writePolicy, Key key, Operation[] operations,
      Handler<AsyncResult<Record>> handler) throws AerospikeException {
    client.operate(eventLoops.next(), recordListener(vertx.getOrCreateContext(), handler),
        writePolicy, key, operations);
    return this;
  }

  public AerospikeClient scanAll(ScanPolicy policy, String namespace, String setName,
      String[] binNames, Handler<AsyncResult<List<KeyRecord>>> handler) throws AerospikeException {
    client.scanAll(eventLoops.next(), queryListener(vertx.getOrCreateContext(), handler),
        policy, namespace, setName, binNames);
    return this;
  }

  public AerospikeClient scanPartitions(ScanPolicy policy, PartitionFilter partitionFilter,
      String namespace, String setName, String[] binNames,
      Handler<AsyncResult<List<KeyRecord>>> handler) throws AerospikeException {
    client.scanPartitions(eventLoops.next(),
        queryListener(vertx.getOrCreateContext(), handler),
        policy, partitionFilter, namespace, setName, binNames);
    return this;
  }

  public AerospikeClient execute(WritePolicy policy, Key key, String pkgName, String fun,
      Value[] args, Handler<AsyncResult<Object>> handler) throws AerospikeException {
    client.execute(eventLoops.next(), executeListener(vertx.getOrCreateContext(), handler),
        policy, key, pkgName, fun, args);
    return this;
  }

  public AerospikeClient query(QueryPolicy queryPolicy, Statement statement,
      Handler<AsyncResult<List<KeyRecord>>> handler) throws AerospikeException {
    client.query(eventLoops.next(), queryListener(vertx.getOrCreateContext(), handler),
        queryPolicy, statement);
    return this;
  }
}
