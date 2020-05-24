package com.cj.search;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.spi.AbstractResourceBundleProvider;

//注意：使用二分查找的前提是该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234, 1234, 1234};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        System.out.println(binarySearch6(arr, 0, arr.length, 1));
    }

    /**
     * 二分查找算法
     *
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 要查找的值
     * @return 找到就返回下标，没有找到就返回-1
     */
    private static int binarySearch(int[] arr, int left, int right, int findVal) {
        //当left > right 说明，递归完毕，已经递归了整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    //找到所有的数值
    //思路：
    //1.在找到mid索引值时，不要马上返回
    //2.向mid索引值左边扫描，将所有满足的数值的下标，加入到集合ArrayList
    //3.向mid索引值右边扫描，将所有满足的数值的下标，加入到集合ArrayList
    private static ArrayList binarySearch2(int[] arr, int left, int right, int findVal) {
        //当left > right 说明，递归完毕，已经递归了整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则，就把temp放入到resIndexList中
                resIndexList.add(temp);
                temp--; //temp左移
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }

    private static ArrayList binarySearch3(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch3(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch3(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();

            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }

    private static ArrayList binarySearch4(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal < midVal) {
            return binarySearch4(arr, left, mid - 1, findVal);
        } else if (findVal > midVal) {
            return binarySearch4(arr, mid + 1, right, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();

            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }

            return resIndexList;
        }
    }

    private static ArrayList binarySearch5(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch5(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch5(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();

            int temp = mid - 1;
            while (true) {
                if(temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }

    private static ArrayList binarySearch6(int[] arr, int left, int right, int findVal) {
        System.out.println("hello");
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch6(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch6(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();

            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }

}
