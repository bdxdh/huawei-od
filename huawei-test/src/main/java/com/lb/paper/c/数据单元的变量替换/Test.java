package com.lb.paper.c.数据单元的变量替换;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 考察点：字符串处理
 */
public class Test {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        String input_str = in.next();
        System.out.println(input_str);
        String[] tmp2 = input_str.split(",");
        //创建hashmap, 保存每个cell的值
        HashMap<Character, String> cells = new HashMap<Character, String>();
        for (int i = 0; i < tmp2.length; i++) {
            cells.put((char) ((int) 'A' + i), tmp2[i]);
        }

        String result = "";
        for (int i = 0; i < tmp2.length; i++) {
            int result1 = tmp2[i].indexOf("<");
            int result2 = tmp2[i].indexOf(">");

            if (result1 == -1 && result2 == -1) {
                result += tmp2[i];
            } else if (result1 == -1 || result2 == -1) {
                //异常
                System.out.println(-1);
                return;
            } else if (result1 > result2 || result2 - result1 != 2) {
                //异常
                System.out.println(-1);
                return;
            } else {
                //正常情况替换即可
                result += tmp2[i].substring(0, result1);
                result += cells.get(tmp2[i].substring(result1 + 1, result2).charAt(0));
                result += tmp2[i].substring(result2 + 1);
            }
            result += ",";
        }

        System.out.println(result.substring(0, result.length() - 1));
    }
}