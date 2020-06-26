package cn.walls1717.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理测试
 * @version 2020-6-26
 * @author CJ
 */
public class ProxyTest {

    public static void main(String[] args) {
        // 床家真实对象
        Lenovo lenovo = new Lenovo();

        /*
         * 动态代理增强lenovo 对象
         * 三个参数：
         *  1. 类加载器：真实对象.getClass().getClassLoader()
         *  2. 接口数组：真实对象.getClass().getInterfaces()
         *  3. 处理器：new InvocationHandler()
         */
        SaleComputer proxyLenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写方法：代理对象调用的所有方法都会触发该方法执行
             * @param proxy 代理对象
             * @param method 代理对象调用的方法，被封装为的对象
             * @param args 代理对象调用方法时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // p判断是否是 sale方法
                if("sale".equals(method.getName())) {
                    // 增强参数
                    double money = (double) args[0];
                    money = money * 0.85;
                    System.out.println("专车接你");
                    // 使用真实对象调用该方法
                    String obj = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    // 增强返回值
                    return obj + "_鼠标垫";
                } else {
                    return method.invoke(lenovo, args);
                }
            }
        });

        // 调用方法
        String computer = proxyLenovo.sale(8000);
        System.out.println(computer);

        proxyLenovo.show();
    }
}
