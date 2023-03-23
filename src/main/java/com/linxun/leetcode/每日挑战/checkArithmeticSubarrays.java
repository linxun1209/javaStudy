package com.linxun.leetcode.每日挑战;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/23 12:52
 */
public class checkArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int arr[]= Arrays.copyOfRange(nums,l[i],r[i]+1);
            Arrays.sort(arr);
            int d=arr[1]-arr[0];
            boolean ch=true;
            for(int j=2;j<=r[i]-l[i];j++){
                if(d!=arr[j]-arr[j-1]){
                    ch=false;
                    break;
                }
            }
            ans.add(ch);
        }
        return ans;
    }


    public List<Boolean> checkArithmeticSubarrays2(int[] nums, int[] l, int[] r) {
        int m=l.length;
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            ans.add(check(nums,l[i],r[i]));
        }
        return ans;
    }
    boolean check(int nums[],int l,int r){
        int max=-(int)1e6,min=(int)1e6;
        for(int i=l;i<=r;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        if(max==min){return true;}
        if((max-min)%(r-l)!=0){return false;}
        boolean has[]=new boolean[r-l+1];
        int d=(max-min)/(r-l);
        for(int i=l;i<=r;i++){
            if((nums[i]-min)%d!=0||has[(nums[i]-min)/d]){return false;}
            has[(nums[i]-min)/d]=true;
        }
        return true;
    }


    public List<Boolean> checkArithmeticSubarrays3(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int arr[]=Arrays.copyOfRange(nums,l[i],r[i]+1);
            Arrays.sort(arr);
            int d=arr[1]-arr[0];
            boolean ch=true;
            for(int j=2;j<=r[i]-l[i];j++){
                if(d!=arr[j]-arr[j-1]){
                    ch=false;
                    break;
                }
            }
            ans.add(ch);
        }
        return ans;
    }
}
