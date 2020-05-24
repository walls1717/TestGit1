package com.cj.test.fundamentals6_9;

/**
 * @author CJ
 * @version 2020-5-7
 */
public class ArrayAlg {
    /**
     * 静态内部类
     * 返回两个值
     */
    public static class Pair {
        private final double first;
        private final double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    /**
     * 用来获取数组中最大最小值
     * @param values 需要查找的数组
     * @return 第一个元素值为最小值，第二个元素值为最大值
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        }
        return new Pair(min, max);
    }
}
