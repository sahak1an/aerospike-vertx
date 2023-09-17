package io.s1n.aerospike.listeners;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.listener.RecordListener;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.impl.ContextInternal;


class RecordListenerImpl implements RecordListener {

  final Handler<AsyncResult<Record>> handler;
  final ContextInternal context;

  RecordListenerImpl(ContextInternal context, Handler<AsyncResult<Record>> handler) {
    this.context = context;
    this.handler = handler;
  }

  public void onSuccess(Key key, Record record) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.succeededFuture(record)));
    }
  }

  public void onFailure(AerospikeException e) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.failedFuture(e)));
    }
  }
}
