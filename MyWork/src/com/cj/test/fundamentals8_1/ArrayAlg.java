package com.cj.test.fundamentals8_1;

/**
 * @version 2020-5-16
 * @author CJ
 */
class ArrayAlg {
    /**
     * 从数组中获得最大值与最小值
     * @param a 传入需要获取的数组
     * @return 返回最小值与最大值
     */
    public static Pair<String> minmax(String[] a) {
        // 判断，如果数组位null，或者长度为0，返回null
        if (a == null || a.length == 0) {
            return null;
        }
        // 先将最小值与最大值赋初始值，
        // 也就是先默认数组第一个元素为最小值与最大值
        String min = a[0];
        String max = a[0];
        // 从数组的第二个元素开始，循环比较数组每一个元素
        for (int i = 1; i < a.length; i++) {
            // 如果 min 小于数组中的一个元素，将更新 min 值
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            // 如果 max 大于数组中的一个元素，将更新 max 值
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        // 返回最小值与最大值
        return new Pair<>(min, max);
    }
}
