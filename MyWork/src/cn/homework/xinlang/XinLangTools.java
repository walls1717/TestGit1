package cn.homework.xinlang;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * 工具类
 *
 * @author CJ
 * @version 2020-5-10
 */
public class XinLangTools {
    public static User input() {
        var sc = new Scanner(System.in);

        //输入姓名
        System.out.print("姓名：");
        String name = sc.nextLine();

        //输入密码
        System.out.print("密码：");
        String password = sc.nextLine();

        //再次输入密码，并判断再次输入的密码是否与第一次输入的一样
        System.out.print("重复密码：");
        String rePassword = sc.nextLine();
        if (!password.equals(rePassword)) {
            System.out.println("两次密码输入不相同");
            sc.close();
            System.exit(0);
        }

        //输入出生日期
        System.out.print("出生日期(yyyy-MM-dd)：");
        String birthday = sc.nextLine();
        String[] birthdayArr = birthday.split("-");
        int[] numArr = toIntArray(birthdayArr);
        var date = LocalDate.of(numArr[0], numArr[1], numArr[2]);

        //输入电话，并且判断电话是否符和格式
        System.out.print("电话：");
        String phoneNum = sc.nextLine();
        char[] phoneArr = phoneNum.toCharArray();
        if (phoneArr.length != 11 || phoneArr[0] != '1'
                || (phoneArr[1] != '3' & phoneArr[1] != '5' & phoneArr[1] != '7' & phoneArr[1] != '8')) {
            System.out.println("电话号码格式不正确");
            sc.close();
            System.exit(0);
        }

        //输入邮箱，并且判断邮箱是否符和格式
        System.out.print("邮箱：");
        String eMail = sc.nextLine();
        char[] eMailArr = eMail.toCharArray();
        if (!isEmail(eMailArr)) {
            System.out.println("邮箱格式不正确");
            sc.close();
            System.exit(0);
        }

        //如果全部输入完并且符和，就会返回一个user对象
        return new User(name, password, rePassword, date, phoneNum, eMail);
    }

    /**
     * 判断用户输入的EMail中是否包含@
     * @param eMail 用户输入的@
     * @return 返回是否存在
     */
    private static boolean isEmail(char[] eMail) {
        for (char e : eMail) {
            if (e == '@') {
                return true;
            }
        }
        return false;
    }

    /**
     * 将字符串数组转化为整形数组
     * @param strArr 需要转化的字符串数组
     * @return 转化过后的整形数组
     */
    private static int[] toIntArray(String[] strArr) {
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
