package io.s1n.aerospike.util;

import io.vertx.core.Vertx;
import io.vertx.core.shareddata.LocalMap;
import io.vertx.core.shareddata.Shareable;
import java.util.function.Supplier;

public final class SharedDataUtils {

  private static final String SHARED_DATA_MAP_NAME = "__vertx.sharedDataUtils";
  private static final String SHARED_INSTANCE_FORMAT = "__AerospikeClient.__for.__{%s}:{%s}";

  private SharedDataUtils() {
  }

  public static String getInstanceName(String host, Integer port) {
    return SHARED_INSTANCE_FORMAT.formatted(host, port);
  }

  public static <T> T getOrCreate(Vertx vertx, String name, Supplier<T> supplier) {
    LocalMap<Object, ThreadSafe<T>> singletons = vertx.sharedData()
        .getLocalMap(SHARED_DATA_MAP_NAME);

    return singletons.computeIfAbsent(name, k -> new ThreadSafe<>(supplier.get())).getObject();
  }

  public static void removeInstanceByName(Vertx vertx, String name) {
    var singletons = vertx.sharedData().getLocalMap(SHARED_DATA_MAP_NAME);
    singletons.remove(name);
  }

  static class ThreadSafe<T> implements Shareable {

    T object;

    public ThreadSafe(T object) {
      this.object = object;
    }

    public T getObject() {
      return this.object;
    }
  }
}