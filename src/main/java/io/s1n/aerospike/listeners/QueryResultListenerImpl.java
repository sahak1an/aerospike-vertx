package io.s1n.aerospike.listeners;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.listener.RecordSequenceListener;
import com.aerospike.client.query.KeyRecord;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.impl.ContextInternal;
import java.util.ArrayList;
import java.util.List;

class QueryResultListenerImpl implements RecordSequenceListener {

  final Handler<AsyncResult<List<KeyRecord>>> handler;
  final ContextInternal context;
  final List<KeyRecord> keyRecords;

  QueryResultListenerImpl(ContextInternal context, Handler<AsyncResult<List<KeyRecord>>> handler) {
    this.context = context;
    this.handler = handler;
    this.keyRecords = new ArrayList<>();
  }

  @Override
  public void onRecord(Key key, Record record) throws AerospikeException {
    keyRecords.add(new KeyRecord(key, record));
  }

  public void onSuccess() {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.succeededFuture(keyRecords)));
    }
  }

  public void onFailure(AerospikeException e) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.failedFuture(e)));
    }
  }
}

