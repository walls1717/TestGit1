package com.cj.singletonpattern;

/**
 * 枚举式单列
 * 1.避免了反射和反序列化的漏洞
 * 2.调用效率较高
 * 3.没有延时加载
 *
 * @author CJ
 */

public enum SingletonDemo05 {
    //这个枚举元素，本身就是单列对象
    INSTANCE;

    //添加自己需要的操作
    public void singletonOperation(){
    }
}
