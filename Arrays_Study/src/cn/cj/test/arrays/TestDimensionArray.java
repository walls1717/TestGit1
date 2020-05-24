package cn.cj.test.arrays;

/**
 * 测试多维数组
 * @author CJ
 */

public class TestDimensionArray {
    public static void main(String[] args){
//        int[] a = new int[3];
//        Car[] cars = new Car[3];

        int[][] a = new int[3][];

        a[0] = new int[]{20, 39};
        a[1] = new int[]{10, 33, 55};
        a[2] = new int[]{59, 42};

        System.out.println(a[1][2]);

        //静态初始化二维数组
        int[][] b = {
                {20, 30, 50},
                {24, 525, 532},
                {234, 452, 52, 35}
        };
        System.out.println(b[2][3]);
    }
}

class Car{

}
