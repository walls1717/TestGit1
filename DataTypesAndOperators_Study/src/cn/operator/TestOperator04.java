package cn.operator; /**
 * BMI计算
 * @author CJ
 *
 */

import java.util.Scanner;//调用scanner

public class TestOperator04 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);//定义s

        //获取身高体重
        System.out.println("请输入你的身高(M)：");
        float high = s.nextFloat();
        System.out.println("请输入你的体重（KG）：");
        float weight = s.nextFloat();

        //计算BMI
        float BMI = weight/(high*high);
        System.out.println("你的BMI是："+BMI);

        //比较体重的范围
        System.out.println("你的体重属于：");
        if(BMI<18.5){
            System.out.println("体重过轻");
        }else if(BMI>=18.5 && BMI<24){
            System.out.println("正常范围");
        }else if(BMI>=24 && BMI<27){
            System.out.println("体重过重");
        }else if(BMI>=27 && BMI<30){
            System.out.println("轻度肥胖");
        }else if(BMI>=30 && BMI<35){
            System.out.println("中度肥胖");
        }else if(BMI>=35){
            System.out.println("重度肥胖");
        }
    }
}
