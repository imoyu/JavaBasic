package com.basicjava.generic.baeldung;

@FunctionalInterface
public interface FI<K, T, V> {
    void cal(K k, T t, V v);
}
