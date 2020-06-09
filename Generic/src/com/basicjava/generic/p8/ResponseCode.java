package com.basicjava.generic.p8;

import com.sun.istack.internal.NotNull;

public interface ResponseCode {

    @NotNull
    String code();
    @NotNull
    String msg();
}
