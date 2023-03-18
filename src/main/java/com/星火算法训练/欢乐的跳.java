package com.星火算法训练;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.星火算法训练
 * @date 2022/10/17 21:00
 */
public class 欢乐的跳 {
    public static void main(String[] args) {
        List<Integer> ans=new ArrayList<>();
        List<Integer> ans1=new LinkedList<>();

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=n-1-1;
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        int result=Math.abs(a[0]-a[1]);
        ans.add(result);
        for (int i = 2; i <n; i++) {
            result=Math.abs(a[i-1]-a[i]);
            ans.add(result);
        }
        Collections.sort(ans);
        List<Integer> list2 = new ArrayList<>();
        for(int i=0 ; i < ans.size() ; i++){
            list2.add(ans.get(i));
        }
        Integer integer = list2.get(k);
        if(integer==n-1){
            System.out.println("Jolly");
        }else {
            System.out.println("Not jolly");
        }
    }
}
