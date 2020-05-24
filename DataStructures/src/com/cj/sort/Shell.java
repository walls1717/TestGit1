package com.cj.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Shell {
    public static void main(String[] args) {
        /*
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = dateFormat1.format(date1);
        System.out.println("执行前的时间为：" + dateStr1);

        shellSort2(arr);

        Date date2 = new Date();
        String dateStr2 = dateFormat1.format(date2);
        System.out.println("执行后的时间为：" + dateStr2);
         */

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("原始数组"+Arrays.toString(arr));
        shellSort12(arr);
        System.out.println("排列后的数组"+Arrays.toString(arr));

    }

    private static void shellSort2(int[] arr) {
        int j;
        int tmp;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                tmp = arr[i];
                for (j = i; j >= gap && tmp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
            System.out.println("第"+(++count)+"次排序" + Arrays.toString(arr));
        }
    }

    private static void shellSort3(int[] arr) {
        int temp;
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    private static void shellSort4(int[] arr) {
        int temp;
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    private static void shellSort5(int[] arr) {
        int temp;
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    private static void shellSort6(int[] arr) {
        int temp;
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    private static void shellSort7(int[] arr) {
        int temp;
        int j;
        for(int gap = arr.length / 2; gap >0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    private static void shellSort8(int[] arr) {
        int temp;
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    private static void shellSort9(int[] arr) {
        int temp;
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    private static void shellSort10(int[] arr) {
        int temp;
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    private static void shellSort11(int[] arr) {
        int temp = 0;
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    //2020/3/29
    private static void shellSort12(int[] arr) {
        int temp;
        int j;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                temp = arr[i];
                for(j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
