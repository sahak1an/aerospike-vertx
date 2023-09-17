package io.s1n.aerospike.listeners;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.listener.ExecuteListener;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.impl.ContextInternal;

class ExecuteListenerImpl implements ExecuteListener {

  final Handler<AsyncResult<Object>> handler;
  final ContextInternal context;

  ExecuteListenerImpl(ContextInternal context, Handler<AsyncResult<Object>> handler) {
    this.context = context;
    this.handler = handler;
  }

  public void onSuccess(Key key, Object obj) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.succeededFuture(obj)));
    }
  }

  public void onFailure(AerospikeException e) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.failedFuture(e)));
    }
  }
}
