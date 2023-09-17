package io.s1n.aerospike.listeners;

import com.aerospike.client.AerospikeException;
import com.aerospike.client.Key;
import com.aerospike.client.listener.ExistsArrayListener;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.impl.ContextInternal;
import java.util.ArrayList;
import java.util.List;

class ExistsArrayListenerImpl implements ExistsArrayListener {

  final Handler<AsyncResult<List<Boolean>>> handler;
  final ContextInternal context;

  ExistsArrayListenerImpl(ContextInternal context, Handler<AsyncResult<List<Boolean>>> handler) {
    this.context = context;
    this.handler = handler;
  }

  public void onSuccess(Key[] keys, boolean[] b) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(booleanFuture(b)));
    }
  }

  public void onFailure(AerospikeException e) {
    if (handler != null) {
      context.runOnContext((v) -> handler.handle(Future.failedFuture(e)));
    }
  }

  private static Future<List<Boolean>> booleanFuture(boolean[] b) {
    List<Boolean> result = new ArrayList<>(b.length);

    for (boolean b1 : b) {
      result.add(b1);
    }
    return Future.succeededFuture(result);
  }
}
