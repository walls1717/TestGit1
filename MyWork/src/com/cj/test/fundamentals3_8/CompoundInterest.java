package com.cj.test.fundamentals3_8;

public class CompoundInterest {
    public static void main(String[] args) {
        //表示起始利率
        final double startRate = 10;
        //表示列
        final int NRATES = 6;
        //表示行
        final int NYEARS = 10;

        //存放了利率
        double[] interestRate = new double[NRATES];
        //利率从10-15
        for (int i = 0; i < interestRate.length; i++) {
            interestRate[i] = (startRate + i) / 100.0;
        }
        //存放金额
        double[][] balance = new double[NYEARS][NRATES];
        //先初始化资金，第一行
        for (int j = 0; j < balance[0].length; j++) {
            balance[0][j] = 10000.00;
        }
        //控制行
        for (int i = 1; i < balance.length; i++) {
            //控制列
            for (int j = 0; j < balance[i].length; j++) {
                //获取初始金额
                double oldBalance = balance[i - 1][j];
                //通过利率算出利息金额
                double interest = oldBalance * interestRate[j];
                //初始金额加上利息
                balance[i][j] = oldBalance + interest;
            }
        }
        for(int i = 0; i < interestRate.length; i++) {
            System.out.printf("%9.0f%%", 100 * interestRate[i]);
        }
        System.out.println();
        for (double[] temp : balance) {
            for(double re : temp) {
                System.out.printf("%10.2f", re);
            }
            System.out.println();
        }
    }
}
