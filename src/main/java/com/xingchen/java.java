package com.xingchen;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen
 * @date 2022/8/23 20:02
 */
public class java {
    public static void main(String[] args) {

        int[][] local = {{0,-1},{0,1},{-1,0},{1,0}};
        for(int[] arr:local){
            int newX = 1+arr[0];
            int newY = 1+arr[1];
            System.out.println(newX);
            System.out.println(newY);
        }
    }
}
