package com.cj.binarysearchnorecursion;

public class BinarySearchRecur {
    public static void main(String[] args) {
        //测试
        int[] arr = {1, 3, 8, 10, 11, 67, 100, 1000};
        int index = binarySearch(arr, 1000);
        System.out.println(index);
    }

    //二分查找非递归实现

    /**
     *
     * @param arr 待查找的数组，arr是升序排列
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1; //需要向左边查找
            } else {
                left = mid + 1; //需要向右边查找
            }
        }
        return -1;
    }
}
