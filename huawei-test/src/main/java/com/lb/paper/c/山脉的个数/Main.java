package com.lb.paper.c.山脉的个数;

import java.util.Scanner;

/**
 * 考察点：数据结构
 */
public class Main {

    public static void main(String[] args) {
        //输入,此处仅为测试，考试时为leetcode模式
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();
        String[] tmp2 = input_str.split(",");
        int[] nums = new int[tmp2.length];
        for (int i = 0; i < tmp2.length; i++) {
            nums[i] = Integer.parseInt(tmp2[i]);
        }
        System.out.println(validMountainCount(nums));
    }

    public static int validMountainCount(int[] arr) {
        int result = 0;
        int i = 0;
        int arr_len = arr.length;
        while (true) {
            if (i >= arr_len) {
                return result;
            } else {
                //左边界
                if (i == 0) {
                    if (arr[i + 1] < arr[i]) {
                        result += 1;
                    }
                } else if (i == arr_len - 1) {
                    if (arr[i - 1] < arr[i]) {
                        result += 1;
                    }
                } else {
                    if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                        result += 1;
                    }
                }
            }
            i += 1;
        }
    }
}