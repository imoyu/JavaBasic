package com.basicjava.generic.baeldung;

@FunctionalInterface
public interface ComparatorByHelper<K, T> {

    int compare(K k, T t, Helper helper);

}
