package com.cj.jvm.dynamiccomplie;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author CJ
 */

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //通过IO流操作，将字符串存储成一个临时文件(Hi.java)，然后动态编译方法
        String str = "public class Hi {public static void main(String[] args){System.out.println(\"HaHa,cj\"}}";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "E:/MyJavaTest/HelloWorld.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");

        //通过RunTime调用执行类
        /*Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp E:/MyJavaTest HelloWorld");
        InputStream in = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String info = "";
        while ((info = reader.readLine()) != null) {
            System.out.println(info);
        }*/

        try {
            URL[] urls = new URL[] {new URL("file:/"+"E:/MyJavaTest/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("HelloWorld");
            //调用加载类的main方法
            Method m = c.getMethod("main", String[].class);
            m.invoke(null, (Object)new String[]{});
            //由于可变参数是JDK5.0之后才有 上面的代码会编译成功 m.invoke(null, "aa", "bb");，就发生了参数个数不匹配的问题
            //因此，必须要加上（Object）转型，避免这个问题
            //public static void mmm(String[] a, String[] b)
            //public static void main(String[] a)
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
