package io.s1n.aerospike.listeners;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.listener.DeleteListener;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.impl.ContextInternal;

class DeleteListenerImpl implements DeleteListener {

  final Handler<AsyncResult<Boolean>> handler;
  final ContextInternal context;

  DeleteListenerImpl(ContextInternal context, Handler<AsyncResult<Boolean>> handler) {
    this.context = context;
    this.handler = handler;
  }

  public void onSuccess(Key key, boolean b) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.succeededFuture(b)));
    }
  }

  public void onFailure(AerospikeException e) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.failedFuture(e)));
    }
  }
}
