package com.cj.jvm.rhino;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 测试脚本引擎执行JavaScript代码
 *
 * 即将删除，了解即可
 *
 * @author CJ
 */

public class Demo01 {
    public static void main(String[] args) throws Exception {
        //获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量，存储到引擎上下文中
        engine.put("msg", "CJ is a good boy");
        String str = "var user = {name:'cj', age:18, school:['清华大学']};";
        str += "print(user.name);";

        //执行脚本
        engine.eval(str);
        engine.eval("msg = 'cjcj is is a a good good boy';");

        System.out.println(engine.get("msg"));
        System.out.println("####################");

        //定义函数
        engine.eval("function add(a, b){var sun = a + b; return sum;}");
        //执行js函数
        Invocable jsInvoke = (Invocable) engine;
        Object result = jsInvoke.invokeFunction("add", new Object[]{13, 20});
        System.out.println(result);
    }
}
