package com.cursee.more_bows_and_arrows.impl.common.registry.util;

import com.google.common.collect.Maps;
import java.util.Map;

public class CustomRegistryManager {

  private CustomRegistryManager _instance = null;
  private Map<Class<? extends IRegistry>, IRegistry> registries = Maps.newIdentityHashMap();

  public <R extends IRegistry> void addRegistry(Class<R> clazz, R registry) {
    this.registries.put(clazz, registry);
  }

  @SuppressWarnings("unchecked")
  public <T extends IRegistry> T getRegistry(Class<T> clazz) {
    return (T) (this.registries.get(clazz));
  }
}
