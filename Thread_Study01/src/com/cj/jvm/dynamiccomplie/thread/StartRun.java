package com.cj.jvm.dynamiccomplie.thread;

/**
 * 创建线程方式二：
 * 1.创建：实现Runnable + 重写run
 * 2.启动：创建实现类对象 + Thread对象 + Start
 *
 * 推荐：避免单继承的局限性，优先使用接口
 * 方便共享资源
 * @author CJ
 */

public class StartRun implements Runnable{
    /**
     * 线程入口点
     */
    @Override
    public void run() {
        for(int i = 0; i < 200; i++){
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args){
//        //创建实现类对象
//        StartRun sr = new StartRun();
//        //创建代理类对象
//        Thread t = new Thread(sr);
//        //启动
//        t.start();//不保证立即运行，Cpu调用

        new Thread(new StartRun()).start();

        for(int i = 0; i < 200; i++){
            System.out.println("一边coding");
        }
    }
}
