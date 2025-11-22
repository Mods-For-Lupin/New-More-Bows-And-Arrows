package com.cursee.more_bows_and_arrows.util;

import com.google.common.collect.Maps;
import java.util.Map;

public class CustomRegistryManager {

  private final Map<Class<? extends IRegistry>, IRegistry> registries = Maps.newIdentityHashMap();

  public <R extends IRegistry> void addRegistry(Class<R> clazz, R registry) {
    this.registries.put(clazz, registry);
  }

  @SuppressWarnings("unchecked")
  public <T extends IRegistry> T getRegistry(Class<T> clazz) {
    return (T) (this.registries.get(clazz));
  }
}
