package cn.operator;

/**
 * 条件运算符(三元运算符)
 * @author CJ
 */

public class TestOperator11 {
    public static void main(String[] args){
        int score = 100;
        int x = 0;

        String type = score>60?"及格":"不及格";//如果score大于60则为及格，小于等于60为不及格
        int y = x>0?1:(x==0?2:1);//如果x大于0，则y=1，如果小于等于0则判断是否等于0，等于0则y=2，小于0 y=1

        if(score>90){
            System.out.println("优秀");
        }else{
            System.out.println("及格");
        }

        System.out.println(type);
        System.out.println(y);
    }
}
