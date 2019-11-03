package _2019秋招笔试题.flytech_1009;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-09 19:20
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String name = sc.next ();
        String pwd = sc.next ();
        String phone = sc.next ();

        if (name.equals ("zhangsan") || name.equals ("lisi")) {
            System.out.println ("该用户名已存在");
            return;
        }
        if (!varifyPwd (pwd)) {
            System.out.println ("密码格式错误");
            return;
        }

        if (phone.length () == 11 && phone.charAt (0) == '1') {
            System.out.println ("注册成功");
        } else {
            System.out.println ("请输入正确的手机号码");
        }

    }

    public static boolean varifyPwd(String pwd) {
        if (pwd.length () < 8 || pwd.length () > 16) {
            return false;
        }
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < pwd.length (); i++) {
            char c = pwd.charAt (i);
            if (!Character.isDigit (c) && !Character.isAlphabetic (c)) {
                return false;
            }
            if (Character.isAlphabetic (c)) flag2 = true;
            if (Character.isDigit (c)) flag1 = true;
        }
        


        return flag1 && flag2;
    }

/*
zhangsana
abcd1234A
13111111111
 */
}
