package io.s1n.aerospike.listeners;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.BatchRead;
import com.aerospike.client.listener.BatchListListener;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.impl.ContextInternal;
import java.util.List;

class BatchListListenerImpl implements BatchListListener {

  final Handler<AsyncResult<List<BatchRead>>> handler;
  final ContextInternal context;

  BatchListListenerImpl(ContextInternal context, Handler<AsyncResult<List<BatchRead>>> handler) {
    this.context = context;
    this.handler = handler;
  }

  public void onSuccess(List<BatchRead> list) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.succeededFuture(list)));
    }
  }

  public void onFailure(AerospikeException e) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.failedFuture(e)));
    }
  }
}
