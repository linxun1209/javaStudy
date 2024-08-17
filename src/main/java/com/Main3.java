package com;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/17 19:35
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
        }
        Arrays.sort(nums);
        //要想使得最少的次数得到最小的极差，
        System.out.println(nums.length%2==0?(nums[nums.length/2]+nums[nums.length/2+1]/2):nums[nums.length/2]);
    }

}

