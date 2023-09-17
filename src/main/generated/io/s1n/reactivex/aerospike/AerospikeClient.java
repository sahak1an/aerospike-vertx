/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.s1n.reactivex.aerospike;

import io.vertx.reactivex.RxHelper;
import io.vertx.reactivex.ObservableHelper;
import io.vertx.reactivex.FlowableHelper;
import io.vertx.reactivex.impl.AsyncResultMaybe;
import io.vertx.reactivex.impl.AsyncResultSingle;
import io.vertx.reactivex.impl.AsyncResultCompletable;
import io.vertx.reactivex.WriteStreamObserver;
import io.vertx.reactivex.WriteStreamSubscriber;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import io.vertx.core.Handler;
import io.vertx.core.AsyncResult;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.lang.rx.RxGen;
import io.vertx.lang.rx.TypeArg;
import io.vertx.lang.rx.MappingIterator;

/**
 * The <code>AerospikeClient</code> interface provides an abstraction on top of {@link com.aerospike.client.AerospikeClient}
 * for integrating its asynchronous commands in <a href=https://io.vertx>Vert.x</a>-based Applications.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.s1n.aerospike.AerospikeClient original} non RX-ified interface using Vert.x codegen.
 */

@RxGen(io.s1n.aerospike.AerospikeClient.class)
public class AerospikeClient {

  @Override
  public String toString() {
    return delegate.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AerospikeClient that = (AerospikeClient) o;
    return delegate.equals(that.delegate);
  }
  
  @Override
  public int hashCode() {
    return delegate.hashCode();
  }

  public static final TypeArg<AerospikeClient> __TYPE_ARG = new TypeArg<>(    obj -> new AerospikeClient((io.s1n.aerospike.AerospikeClient) obj),
    AerospikeClient::getDelegate
  );

  private final io.s1n.aerospike.AerospikeClient delegate;
  
  public AerospikeClient(io.s1n.aerospike.AerospikeClient delegate) {
    this.delegate = delegate;
  }

  public AerospikeClient(Object delegate) {
    this.delegate = (io.s1n.aerospike.AerospikeClient)delegate;
  }

  public io.s1n.aerospike.AerospikeClient getDelegate() {
    return delegate;
  }

  /**
   * Close all client connections to database server nodes.
   */
  public void close() { 
    delegate.close();
  }

  /**
   * Create a shared aerospike client using the given connect options.
   * The client will be shared across a vertx instance
   * @param vertx the vertx instance
   * @param connectOptions user provided connection options
   * @return the client
   */
  public static io.s1n.reactivex.aerospike.AerospikeClient create(io.vertx.reactivex.core.Vertx vertx, io.s1n.aerospike.AerospikeConnectOptions connectOptions) { 
    io.s1n.reactivex.aerospike.AerospikeClient ret = io.s1n.reactivex.aerospike.AerospikeClient.newInstance((io.s1n.aerospike.AerospikeClient)io.s1n.aerospike.AerospikeClient.create(vertx.getDelegate(), connectOptions));
    return ret;
  }

  /**
   * Like {@link io.s1n.reactivex.aerospike.AerospikeClient#create} with default options.
   * @param vertx the vertx instance
   * @return the client
   */
  public static io.s1n.reactivex.aerospike.AerospikeClient create(io.vertx.reactivex.core.Vertx vertx) { 
    io.s1n.reactivex.aerospike.AerospikeClient ret = io.s1n.reactivex.aerospike.AerospikeClient.newInstance((io.s1n.aerospike.AerospikeClient)io.s1n.aerospike.AerospikeClient.create(vertx.getDelegate()));
    return ret;
  }

  /**
   * Create a non shared aerospike client using the given connect options.
   * It is not recommended to create several non shared clients in an application.
   * @param vertx the vertx instance
   * @param connectOptions user provided connection options
   * @return the client
   */
  public static io.s1n.reactivex.aerospike.AerospikeClient createNonShared(io.vertx.reactivex.core.Vertx vertx, io.s1n.aerospike.AerospikeConnectOptions connectOptions) { 
    io.s1n.reactivex.aerospike.AerospikeClient ret = io.s1n.reactivex.aerospike.AerospikeClient.newInstance((io.s1n.aerospike.AerospikeClient)io.s1n.aerospike.AerospikeClient.createNonShared(vertx.getDelegate(), connectOptions));
    return ret;
  }

  /**
   * Like {@link io.s1n.reactivex.aerospike.AerospikeClient#createNonShared} with default options.
   * @param vertx the vertx instance
   * @return the client
   */
  public static io.s1n.reactivex.aerospike.AerospikeClient createNonShared(io.vertx.reactivex.core.Vertx vertx) { 
    io.s1n.reactivex.aerospike.AerospikeClient ret = io.s1n.reactivex.aerospike.AerospikeClient.newInstance((io.s1n.aerospike.AerospikeClient)io.s1n.aerospike.AerospikeClient.createNonShared(vertx.getDelegate()));
    return ret;
  }

  /**
   * Determine if we are ready to talk to the database server cluster.
   * @param handler the handler that will handle response
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient isConnected(io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Boolean>> handler) { 
    delegate.isConnected(handler);
    return this;
  }

  /**
   * Determine if we are ready to talk to the database server cluster.
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient isConnected() {
    return 
isConnected(ar -> { });
  }

  /**
   * Determine if we are ready to talk to the database server cluster.
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.lang.Boolean> rxIsConnected() { 
    return AsyncResultSingle.toSingle($handler -> {
      isConnected($handler);
    });
  }

  /**
   * Return operating cluster statistics.
   * @param handler the handler that will handle the received cluster statistics
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient getClusterStats(io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.cluster.ClusterStats>> handler) { 
    delegate.getClusterStats(handler);
    return this;
  }

  /**
   * Return operating cluster statistics.
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient getClusterStats() {
    return 
getClusterStats(ar -> { });
  }

  /**
   * Return operating cluster statistics.
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.cluster.ClusterStats> rxGetClusterStats() { 
    return AsyncResultSingle.toSingle($handler -> {
      getClusterStats($handler);
    });
  }

  /**
   * Get the underlying {@link com.aerospike.client.AerospikeClient}
   * @return the <code>com.aerospike.client.AerospikeClient</code> instance which is used internally.
   */
  public com.aerospike.client.AerospikeClient getClient() { 
    com.aerospike.client.AerospikeClient ret = delegate.getClient();
    return ret;
  }

  /**
   * Asynchronously write record bin(s).
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient put(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins, io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.Key>> handler) { 
    delegate.put(writePolicy, key, bins, handler);
    return this;
  }

  /**
   * Asynchronously write record bin(s).
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient put(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins) {
    return 
put(writePolicy, key, bins, ar -> { });
  }

  /**
   * Asynchronously write record bin(s).
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.Key> rxPut(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins) { 
    return AsyncResultSingle.toSingle($handler -> {
      put(writePolicy, key, bins, $handler);
    });
  }

  /**
   * Asynchronously append bin string values to existing record bin values.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient append(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins, io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.Key>> handler) { 
    delegate.append(writePolicy, key, bins, handler);
    return this;
  }

  /**
   * Asynchronously append bin string values to existing record bin values.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient append(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins) {
    return 
append(writePolicy, key, bins, ar -> { });
  }

  /**
   * Asynchronously append bin string values to existing record bin values.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.Key> rxAppend(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins) { 
    return AsyncResultSingle.toSingle($handler -> {
      append(writePolicy, key, bins, $handler);
    });
  }

  /**
   * Asynchronously prepend bin string values to existing record bin values.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient prepend(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins, io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.Key>> handler) { 
    delegate.prepend(writePolicy, key, bins, handler);
    return this;
  }

  /**
   * Asynchronously prepend bin string values to existing record bin values.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient prepend(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins) {
    return 
prepend(writePolicy, key, bins, ar -> { });
  }

  /**
   * Asynchronously prepend bin string values to existing record bin values.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.Key> rxPrepend(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins) { 
    return AsyncResultSingle.toSingle($handler -> {
      prepend(writePolicy, key, bins, $handler);
    });
  }

  /**
   * Asynchronously add integer/double bin values to existing record bin values.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient add(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins, io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.Key>> handler) { 
    delegate.add(writePolicy, key, bins, handler);
    return this;
  }

  /**
   * Asynchronously add integer/double bin values to existing record bin values.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient add(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins) {
    return 
add(writePolicy, key, bins, ar -> { });
  }

  /**
   * Asynchronously add integer/double bin values to existing record bin values.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param bins array of bin name/value pairs
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.Key> rxAdd(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Bin[] bins) { 
    return AsyncResultSingle.toSingle($handler -> {
      add(writePolicy, key, bins, $handler);
    });
  }

  /**
   * Asynchronously delete record for specified key.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient delete(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Boolean>> handler) { 
    delegate.delete(writePolicy, key, handler);
    return this;
  }

  /**
   * Asynchronously delete record for specified key.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient delete(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key) {
    return 
delete(writePolicy, key, ar -> { });
  }

  /**
   * Asynchronously delete record for specified key.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.lang.Boolean> rxDelete(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key) { 
    return AsyncResultSingle.toSingle($handler -> {
      delete(writePolicy, key, $handler);
    });
  }

  /**
   * Asynchronously reset record's time to expiration using the policy's expiration.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient touch(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.Key>> handler) { 
    delegate.touch(writePolicy, key, handler);
    return this;
  }

  /**
   * Asynchronously reset record's time to expiration using the policy's expiration.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient touch(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key) {
    return 
touch(writePolicy, key, ar -> { });
  }

  /**
   * Asynchronously reset record's time to expiration using the policy's expiration.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.Key> rxTouch(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key) { 
    return AsyncResultSingle.toSingle($handler -> {
      touch(writePolicy, key, $handler);
    });
  }

  /**
   * Asynchronously determine if a record key exists.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient exists(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Boolean>> handler) { 
    delegate.exists(policy, key, handler);
    return this;
  }

  /**
   * Asynchronously determine if a record key exists.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient exists(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key) {
    return 
exists(policy, key, ar -> { });
  }

  /**
   * Asynchronously determine if a record key exists.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.lang.Boolean> rxExists(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key) { 
    return AsyncResultSingle.toSingle($handler -> {
      exists(policy, key, $handler);
    });
  }

  /**
   * Asynchronously check if multiple record keys exist in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys unique record identifiers
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient exists(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<java.lang.Boolean>>> handler) { 
    delegate.exists(batchPolicy, keys, handler);
    return this;
  }

  /**
   * Asynchronously check if multiple record keys exist in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys unique record identifiers
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient exists(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys) {
    return 
exists(batchPolicy, keys, ar -> { });
  }

  /**
   * Asynchronously check if multiple record keys exist in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys unique record identifiers
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.util.List<java.lang.Boolean>> rxExists(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys) { 
    return AsyncResultSingle.toSingle($handler -> {
      exists(batchPolicy, keys, $handler);
    });
  }

  /**
   * Asynchronously read entire record for specified key.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key, io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.Record>> handler) { 
    delegate.get(policy, key, handler);
    return this;
  }

  /**
   * Asynchronously read entire record for specified key.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key) {
    return 
get(policy, key, ar -> { });
  }

  /**
   * Asynchronously read entire record for specified key.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.Record> rxGet(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key) { 
    return AsyncResultSingle.toSingle($handler -> {
      get(policy, key, $handler);
    });
  }

  /**
   * Asynchronously read record header and bins for specified key.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param binNames bins to retrieve
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key, java.lang.String[] binNames, io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.Record>> handler) { 
    delegate.get(policy, key, binNames, handler);
    return this;
  }

  /**
   * Asynchronously read record header and bins for specified key.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param binNames bins to retrieve
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key, java.lang.String[] binNames) {
    return 
get(policy, key, binNames, ar -> { });
  }

  /**
   * Asynchronously read record header and bins for specified key.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param binNames bins to retrieve
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.Record> rxGet(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key, java.lang.String[] binNames) { 
    return AsyncResultSingle.toSingle($handler -> {
      get(policy, key, binNames, $handler);
    });
  }

  /**
   * Asynchronously read record generation and expiration only for specified key.  Bins are not read.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient getHeader(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key, io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.Record>> handler) { 
    delegate.getHeader(policy, key, handler);
    return this;
  }

  /**
   * Asynchronously read record generation and expiration only for specified key.  Bins are not read.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient getHeader(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key) {
    return 
getHeader(policy, key, ar -> { });
  }

  /**
   * Asynchronously read record generation and expiration only for specified key.  Bins are not read.
   * @param policy generic configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.Record> rxGetHeader(com.aerospike.client.policy.Policy policy, com.aerospike.client.Key key) { 
    return AsyncResultSingle.toSingle($handler -> {
      getHeader(policy, key, $handler);
    });
  }

  /**
   * Asynchronously read multiple records for specified batch keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param records list of unique record identifiers and the bins to retrieve. The returned records are located in the same list.
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.BatchPolicy batchPolicy, java.util.List<com.aerospike.client.BatchRead> records, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<com.aerospike.client.BatchRead>>> handler) { 
    delegate.get(batchPolicy, records, handler);
    return this;
  }

  /**
   * Asynchronously read multiple records for specified batch keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param records list of unique record identifiers and the bins to retrieve. The returned records are located in the same list.
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.BatchPolicy batchPolicy, java.util.List<com.aerospike.client.BatchRead> records) {
    return 
get(batchPolicy, records, ar -> { });
  }

  /**
   * Asynchronously read multiple records for specified batch keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param records list of unique record identifiers and the bins to retrieve. The returned records are located in the same list.
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.util.List<com.aerospike.client.BatchRead>> rxGet(com.aerospike.client.policy.BatchPolicy batchPolicy, java.util.List<com.aerospike.client.BatchRead> records) { 
    return AsyncResultSingle.toSingle($handler -> {
      get(batchPolicy, records, $handler);
    });
  }

  /**
   * Asynchronously read multiple records for specified keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys array of unique record identifiers
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<com.aerospike.client.Record>>> handler) { 
    delegate.get(batchPolicy, keys, handler);
    return this;
  }

  /**
   * Asynchronously read multiple records for specified keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys array of unique record identifiers
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys) {
    return 
get(batchPolicy, keys, ar -> { });
  }

  /**
   * Asynchronously read multiple records for specified keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys array of unique record identifiers
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.util.List<com.aerospike.client.Record>> rxGet(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys) { 
    return AsyncResultSingle.toSingle($handler -> {
      get(batchPolicy, keys, $handler);
    });
  }

  /**
   * Asynchronously read multiple record headers and bins for specified keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys array of unique record identifiers
   * @param binNames array of bins to retrieve
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys, java.lang.String[] binNames, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<com.aerospike.client.Record>>> handler) { 
    delegate.get(batchPolicy, keys, binNames, handler);
    return this;
  }

  /**
   * Asynchronously read multiple record headers and bins for specified keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys array of unique record identifiers
   * @param binNames array of bins to retrieve
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient get(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys, java.lang.String[] binNames) {
    return 
get(batchPolicy, keys, binNames, ar -> { });
  }

  /**
   * Asynchronously read multiple record headers and bins for specified keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys array of unique record identifiers
   * @param binNames array of bins to retrieve
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.util.List<com.aerospike.client.Record>> rxGet(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys, java.lang.String[] binNames) { 
    return AsyncResultSingle.toSingle($handler -> {
      get(batchPolicy, keys, binNames, $handler);
    });
  }

  /**
   * Asynchronously read multiple record header data for specified keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys array of unique record identifiers
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient getHeader(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<com.aerospike.client.Record>>> handler) { 
    delegate.getHeader(batchPolicy, keys, handler);
    return this;
  }

  /**
   * Asynchronously read multiple record header data for specified keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys array of unique record identifiers
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient getHeader(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys) {
    return 
getHeader(batchPolicy, keys, ar -> { });
  }

  /**
   * Asynchronously read multiple record header data for specified keys in one batch call.
   * @param batchPolicy batch configuration parameters, pass in null for defaults
   * @param keys array of unique record identifiers
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.util.List<com.aerospike.client.Record>> rxGetHeader(com.aerospike.client.policy.BatchPolicy batchPolicy, com.aerospike.client.Key[] keys) { 
    return AsyncResultSingle.toSingle($handler -> {
      getHeader(batchPolicy, keys, $handler);
    });
  }

  /**
   * Asynchronously perform multiple read/write operations on a single key in one batch call.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param operations database operations to perform
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient operate(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Operation[] operations, io.vertx.core.Handler<io.vertx.core.AsyncResult<com.aerospike.client.Record>> handler) { 
    delegate.operate(writePolicy, key, operations, handler);
    return this;
  }

  /**
   * Asynchronously perform multiple read/write operations on a single key in one batch call.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param operations database operations to perform
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient operate(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Operation[] operations) {
    return 
operate(writePolicy, key, operations, ar -> { });
  }

  /**
   * Asynchronously perform multiple read/write operations on a single key in one batch call.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param operations database operations to perform
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<com.aerospike.client.Record> rxOperate(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, com.aerospike.client.Operation[] operations) { 
    return AsyncResultSingle.toSingle($handler -> {
      operate(writePolicy, key, operations, $handler);
    });
  }

  /**
   * Asynchronously read all records in specified namespace and set
   * @param policy scan configuration parameters, pass in null for defaults
   * @param namespace namespace - equivalent to database name
   * @param setName optional set name - equivalent to database table
   * @param binNames optional bins to retrieve. All bins will be returned if empty.
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient scanAll(com.aerospike.client.policy.ScanPolicy policy, java.lang.String namespace, java.lang.String setName, java.lang.String[] binNames, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<com.aerospike.client.query.KeyRecord>>> handler) { 
    delegate.scanAll(policy, namespace, setName, binNames, handler);
    return this;
  }

  /**
   * Asynchronously read all records in specified namespace and set
   * @param policy scan configuration parameters, pass in null for defaults
   * @param namespace namespace - equivalent to database name
   * @param setName optional set name - equivalent to database table
   * @param binNames optional bins to retrieve. All bins will be returned if empty.
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient scanAll(com.aerospike.client.policy.ScanPolicy policy, java.lang.String namespace, java.lang.String setName, java.lang.String[] binNames) {
    return 
scanAll(policy, namespace, setName, binNames, ar -> { });
  }

  /**
   * Asynchronously read all records in specified namespace and set
   * @param policy scan configuration parameters, pass in null for defaults
   * @param namespace namespace - equivalent to database name
   * @param setName optional set name - equivalent to database table
   * @param binNames optional bins to retrieve. All bins will be returned if empty.
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.util.List<com.aerospike.client.query.KeyRecord>> rxScanAll(com.aerospike.client.policy.ScanPolicy policy, java.lang.String namespace, java.lang.String setName, java.lang.String[] binNames) { 
    return AsyncResultSingle.toSingle($handler -> {
      scanAll(policy, namespace, setName, binNames, $handler);
    });
  }

  /**
   * Asynchronously read records in specified namespace, set and partition filter.
   * @param policy scan configuration parameters, pass in null for defaults
   * @param partitionFilter filter on a subset of data partitions
   * @param namespace namespace - equivalent to database name
   * @param setName optional set name - equivalent to database table
   * @param binNames optional bins to retrieve. All bins will be returned if empty.
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient scanPartitions(com.aerospike.client.policy.ScanPolicy policy, com.aerospike.client.query.PartitionFilter partitionFilter, java.lang.String namespace, java.lang.String setName, java.lang.String[] binNames, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<com.aerospike.client.query.KeyRecord>>> handler) { 
    delegate.scanPartitions(policy, partitionFilter, namespace, setName, binNames, handler);
    return this;
  }

  /**
   * Asynchronously read records in specified namespace, set and partition filter.
   * @param policy scan configuration parameters, pass in null for defaults
   * @param partitionFilter filter on a subset of data partitions
   * @param namespace namespace - equivalent to database name
   * @param setName optional set name - equivalent to database table
   * @param binNames optional bins to retrieve. All bins will be returned if empty.
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient scanPartitions(com.aerospike.client.policy.ScanPolicy policy, com.aerospike.client.query.PartitionFilter partitionFilter, java.lang.String namespace, java.lang.String setName, java.lang.String[] binNames) {
    return 
scanPartitions(policy, partitionFilter, namespace, setName, binNames, ar -> { });
  }

  /**
   * Asynchronously read records in specified namespace, set and partition filter.
   * @param policy scan configuration parameters, pass in null for defaults
   * @param partitionFilter filter on a subset of data partitions
   * @param namespace namespace - equivalent to database name
   * @param setName optional set name - equivalent to database table
   * @param binNames optional bins to retrieve. All bins will be returned if empty.
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.util.List<com.aerospike.client.query.KeyRecord>> rxScanPartitions(com.aerospike.client.policy.ScanPolicy policy, com.aerospike.client.query.PartitionFilter partitionFilter, java.lang.String namespace, java.lang.String setName, java.lang.String[] binNames) { 
    return AsyncResultSingle.toSingle($handler -> {
      scanPartitions(policy, partitionFilter, namespace, setName, binNames, $handler);
    });
  }

  /**
   * Asynchronously execute user defined function on server.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param packageName server package name where user defined function resides
   * @param functionName user defined function
   * @param functionArgs arguments passed in to user defined function
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient execute(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, java.lang.String packageName, java.lang.String functionName, com.aerospike.client.Value[] functionArgs, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Object>> handler) { 
    delegate.execute(writePolicy, key, packageName, functionName, functionArgs, handler);
    return this;
  }

  /**
   * Asynchronously execute user defined function on server.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param packageName server package name where user defined function resides
   * @param functionName user defined function
   * @param functionArgs arguments passed in to user defined function
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient execute(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, java.lang.String packageName, java.lang.String functionName, com.aerospike.client.Value[] functionArgs) {
    return 
execute(writePolicy, key, packageName, functionName, functionArgs, ar -> { });
  }

  /**
   * Asynchronously execute user defined function on server.
   * @param writePolicy write configuration parameters, pass in null for defaults
   * @param key unique record identifier
   * @param packageName server package name where user defined function resides
   * @param functionName user defined function
   * @param functionArgs arguments passed in to user defined function
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.lang.Object> rxExecute(com.aerospike.client.policy.WritePolicy writePolicy, com.aerospike.client.Key key, java.lang.String packageName, java.lang.String functionName, com.aerospike.client.Value[] functionArgs) { 
    return AsyncResultSingle.toSingle($handler -> {
      execute(writePolicy, key, packageName, functionName, functionArgs, $handler);
    });
  }

  /**
   * Asynchronously execute query on all server nodes.
   * @param queryPolicy query configuration parameters, pass in null for defaults
   * @param statement query filter. Statement instance is not suitable for reuse since it's modified in this method.
   * @param handler the handler that will handle the result
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient query(com.aerospike.client.policy.QueryPolicy queryPolicy, com.aerospike.client.query.Statement statement, io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<com.aerospike.client.query.KeyRecord>>> handler) { 
    delegate.query(queryPolicy, statement, handler);
    return this;
  }

  /**
   * Asynchronously execute query on all server nodes.
   * @param queryPolicy query configuration parameters, pass in null for defaults
   * @param statement query filter. Statement instance is not suitable for reuse since it's modified in this method.
   * @return current Aerospike client instance
   */
  public io.s1n.reactivex.aerospike.AerospikeClient query(com.aerospike.client.policy.QueryPolicy queryPolicy, com.aerospike.client.query.Statement statement) {
    return 
query(queryPolicy, statement, ar -> { });
  }

  /**
   * Asynchronously execute query on all server nodes.
   * @param queryPolicy query configuration parameters, pass in null for defaults
   * @param statement query filter. Statement instance is not suitable for reuse since it's modified in this method.
   * @return current Aerospike client instance
   */
  public io.reactivex.Single<java.util.List<com.aerospike.client.query.KeyRecord>> rxQuery(com.aerospike.client.policy.QueryPolicy queryPolicy, com.aerospike.client.query.Statement statement) { 
    return AsyncResultSingle.toSingle($handler -> {
      query(queryPolicy, statement, $handler);
    });
  }

  public static AerospikeClient newInstance(io.s1n.aerospike.AerospikeClient arg) {
    return arg != null ? new AerospikeClient(arg) : null;
  }

}
