package com.cj.jvm.dynamiccomplie.chat03;

import java.io.Closeable;

/**
 * 工具类
 * @author CJ
 */

public class CjUtils {
    /**
     * 释放资源
     */
    public static void close(Closeable... targets){
        for(Closeable target:targets){
            try{
                if (null != target) {
                    target.close();
                }
            }catch(Exception e){

            }
        }
    }
}
