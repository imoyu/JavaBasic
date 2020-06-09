package com.basicjava.generic.p8;

// 枚举类的使用

// 私有的 Field，构造器
// get 方法获取 Field
// static 类型的本类实例对象
public enum ResponseCodeImpl implements ResponseCode {

    // 4. 枚举实例
    SUCCESS("200", "成功"),
    FAIL("400", "失败");

    // 相当于以下语句
//    private static final ResponseCodeImpl FS
//            = new ResponseCodeImpl("999", "手动枚举测试");

    // 1. 定义成员变量
      // 这里的 final 表示 String 只能赋值一次
      // final 修饰的成员变量需要手动初始化
    private final String code;
    private final String msg;
    // 2. 定义构造器（私有）
    private ResponseCodeImpl(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 3. 构造 get 方法
    @Override
    public String code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }
}
