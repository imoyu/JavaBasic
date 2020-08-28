package com.stream.baeldung.generic;

public class G<T> {

    public <T> GG<T> f(GG<? extends T> gg) {
        System.out.println(gg.t);
        return (GG<T>) gg;
    }

}

class GG<T> {
    T t;

    public GG(T t) {
        this.t = t;
    }
}