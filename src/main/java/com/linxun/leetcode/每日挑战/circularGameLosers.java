package com.linxun.leetcode.每日挑战;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/16 22:31
 */
public class circularGameLosers {
    public int[] circularGameLosers(int n, int k) {
        HashSet<Integer> set=new HashSet<>();
        //round代表第几轮
        int round=1,next=0;
        do {
            set.add(next);
            next=(next+round*k)%n;
        }while (!set.contains(next));
        int[] arr=new int[n-set.size()];
        int index=0;
        for (int i=0;i<n;i++){
            arr[index++]=i;
        }
        return arr;
    }
    public int[] circularGameLosers2(int n, int k) {
        int[] arr=new int[n];
        int index=1;
        int f=0;
        arr[f]++;
        int count=1;
        while (true){
            int target=(f+index*k)%n;
            arr[target]++;
            if(arr[target]==1){
                count++;
            }
            if(arr[target]==2){
                break;
            }
            f=target;
            index++;
        }
        int length=0;
        int[] r=new int[n-count];
        for (int i=0;i<arr.length;i++){
            if(arr[i]==0){
                r[length++]=i+1;
            }
        }
        return r;
    }
    public int[] circularGameLosers3(int n, int k) {
        boolean[] visited=new boolean[n];
        for (int i=k,j=0;!visited[j];i+=k){
            visited[i]=true;
            j=(j+i)%n;

        }
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            if(!visited[i]){
                list.add(i+1);
            }
        }
        int[] ans=new int[list.size()];
        for (int i=0;i<list.size();i++){
            ans[i++]=list.get(i);
        }
        return ans;
    }

}
