package io.s1n.aerospike.listeners;

import com.aerospike.client.BatchRead;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.listener.BatchListListener;
import com.aerospike.client.listener.DeleteListener;
import com.aerospike.client.listener.ExecuteListener;
import com.aerospike.client.listener.ExistsArrayListener;
import com.aerospike.client.listener.ExistsListener;
import com.aerospike.client.listener.RecordArrayListener;
import com.aerospike.client.listener.RecordListener;
import com.aerospike.client.listener.RecordSequenceListener;
import com.aerospike.client.listener.WriteListener;
import com.aerospike.client.query.KeyRecord;
import io.reactivex.annotations.NonNull;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.impl.ContextInternal;
import java.util.List;

public class Listeners {

  private Listeners() {
  }

  public static BatchListListener batchListener(@NonNull ContextInternal context,
      Handler<AsyncResult<List<BatchRead>>> handler) {
    return new BatchListListenerImpl(context, handler);
  }

  public static DeleteListener deleteListener(@NonNull ContextInternal context,
      Handler<AsyncResult<Boolean>> handler) {
    return new DeleteListenerImpl(context, handler);
  }

  public static ExecuteListener executeListener(@NonNull ContextInternal context,
      Handler<AsyncResult<Object>> handler) {
    return new ExecuteListenerImpl(context, handler);
  }

  public static ExistsArrayListener existsArrayListener(@NonNull ContextInternal context,
      Handler<AsyncResult<List<Boolean>>> handler) {
    return new ExistsArrayListenerImpl(context, handler);
  }

  public static ExistsListener existsListener(@NonNull ContextInternal context,
      Handler<AsyncResult<Boolean>> handler) {
    return new ExistsListenerImpl(context, handler);
  }

  public static RecordSequenceListener queryListener(@NonNull ContextInternal context,
      Handler<AsyncResult<List<KeyRecord>>> handler) {
    return new QueryResultListenerImpl(context, handler);
  }

  public static RecordArrayListener arrayListener(@NonNull ContextInternal context,
      Handler<AsyncResult<List<Record>>> handler) {
    return new RecordArrayListenerImpl(context, handler);
  }

  public static RecordListener recordListener(@NonNull ContextInternal context,
      Handler<AsyncResult<Record>> handler) {
    return new RecordListenerImpl(context, handler);
  }

  public static WriteListener writeListener(@NonNull ContextInternal context,
      Handler<AsyncResult<Key>> handler) {
    return new WriteListenerImpl(context, handler);
  }
}
