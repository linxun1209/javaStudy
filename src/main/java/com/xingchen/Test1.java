package com.xingchen;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen
 * @date 2022/8/28 14:02
 */
import java.util.Scanner;
import java.util.*;

class Test1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // code here
        int n=input.nextInt(),q=input.nextInt(),k=input.nextInt(),x=input.nextInt(),count=0;
        input.nextLine();
        int []num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=input.nextInt();
        }
        input.nextLine();
        String[] s=new String[q];
        while(count<q){
            int l=input.nextInt(),r=input.nextInt();
            int []nums=new int[r-l];
            for(int a=l-1,b=0;a<r-1;a++,b++){
                nums[b]=num[a];
            }
            s[count]=getRight(x,k,nums);
            count++;
        }
        input.close();
    }
    public static String getRight(int x,int k,int []nums){
        Arrays.sort(nums);
        int sum=0;
        if(nums.length>=k){
            for(int i=0;i<k;i++){
                sum=sum+nums[i];
            }
        }else{
            for(int i=0;i<nums.length;i++){
                sum=sum+nums[i];
            }
        }
        if(sum>=x)return "Y";
        else return "N";
    }
}