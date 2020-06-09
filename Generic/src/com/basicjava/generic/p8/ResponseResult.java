package com.basicjava.generic.p8;

import java.io.Serializable;

// 泛型实例
// web开发中使用到的统一返回类
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionID = 319987396861861098L;

    // 1. 定义 Field
    private boolean success;
    private String code;
    private String msg;
    private T data;

    // 定义构造器
    // protected ：只让本包或者子类能够 new 对象
    protected ResponseResult() {

    }

    // 只需要一个全量的，和一个 ResponseCode 的
    protected ResponseResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    protected ResponseResult(ResponseCode code, T data) {
        this(code.code(), code.msg(), data);
    }

    // static 方法，产生实例

    // success 类
    public static <K> ResponseResult<K> success() {
        return new ResponseResult<>(ResponseCodeImpl.SUCCESS.code(), null, null);
    }

    public static <K> ResponseResult<K> success(K data) {
        return new ResponseResult<>(ResponseCodeImpl.SUCCESS.code(), null, data);
    }

    public static <K> ResponseResult<K> success(String msg, K data) {
        return new ResponseResult<>(ResponseCodeImpl.SUCCESS.code(), msg, data);
    }

    public static <K> ResponseResult<K> success(ResponseCode code, K data) {
        return new ResponseResult<>(code, data);
    }
    // fail 类同理，略

    // get 方法

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
