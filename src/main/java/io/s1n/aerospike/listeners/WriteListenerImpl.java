package io.s1n.aerospike.listeners;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.listener.WriteListener;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.impl.ContextInternal;


class WriteListenerImpl implements WriteListener {

  final Handler<AsyncResult<Key>> handler;
  final ContextInternal context;

  WriteListenerImpl(ContextInternal context, Handler<AsyncResult<Key>> handler) {
    this.context = context;
    this.handler = handler;
  }

  public void onSuccess(Key key) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.succeededFuture(key)));
    }
  }

  public void onFailure(AerospikeException e) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.failedFuture(e)));
    }
  }
}
