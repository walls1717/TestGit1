package com.cj.recursion;

class Solution {
    public static void twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + nums[i + 1] == target) {
                int x = i;
                int y = i + 1;
                System.out.println("x：" + x + " " + "y：" + y);
                System.out.println("target：" + target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 7, 3, 6};
        int target = 9;
        twoSum(nums, target);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}