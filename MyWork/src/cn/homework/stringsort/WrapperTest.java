package cn.homework.stringsort;

import java.util.Arrays;

/**
 * 字符串排序
 * @version 2020-5-9
 * @author CJ
 */
public class WrapperTest {
    public static void main(String[] args) {
        String numStr = "20 18 399 -29 1 0";
        System.out.println(numStr);
        System.out.println(stringSort(numStr));
    }

    public static String stringSort(String numStr) {
        String[] strArr = numStr.split(" ");
        int[] numArr = toIntArray(strArr);
        Arrays.sort(numArr);
        return arrayToString(numArr);
    }

    public static String arrayToString(int[] numStr) {
        var sb = new StringBuilder();
        for(int i = 0; i < numStr.length; i++) {
            if (i == numStr.length - 1) {
                sb.append(numStr[i]);
            } else {
                sb.append(numStr[i] + " ");
            }
        }
        return sb.toString();
    }

    public static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
