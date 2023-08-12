package com.linxun.leetcode.周赛.number357;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.周赛.number357
 * @date 2023/8/11 8:47
 */
public class canSplitArray {

    /**
     * 根据题意就是需要将数组分成最后全部单个的则是true，
     * 并且分的过程中大的数组必须满足大于等于m，又必须是子数组。
     * 所以可以这么认为只要有两个相连的数组元素大于等于m，
     * 则其它数组元素，无论从这两个元素的左边或者右边开始分出去，
     * 其大的这个数组永远满足大于等于m。
     * 1、则只需要找相连的两个元素是否大于等于m。
     * 2、其次一种情况就是初始数组长度小于等于2，不分或者只需要分一次则是true，
     * 所以无论数组和是否大于或等于m，返回都是true。
     * @param nums
     * @param m
     * @return
     */
    public boolean canSplitArray2(List<Integer> nums, int m) {
        if(nums.size()<2){
            return false;
        }
        for(int i=0,j=1;j<nums.size();i++,j++){
            if(nums.get(i)+nums.get(j)>=m){
                return true;
            }

        }
        return false;

    }
    public boolean canSplitArray(List<Integer> nums, int m) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.size();
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=nums.get(i);
        }
        if(n<2){
            return false;
        }
        for (int i=0;i<n-1;i++){

            f(ans,nums,sum,i,n,m);
        }
        return ans.size()==n;
    }

    private void f(List<List<Integer>> ans, List<Integer> nums, int sum, int i, int n,int m) {
        if(i==n){
            return;
        }
        if(sum-nums.get(i)<m&&sum-nums.get(n-i-1)<m){
            return;
        }
        if(sum-nums.get(i)<m){
            ans.add(new ArrayList<>(nums.get(i)));
            nums.remove(nums.get(i));
        }else {
            ans.add(new ArrayList<>(nums.get(n-1)));
            nums.remove(nums.get(n-1));
        }
    }


    /**
     * 动态规划
     *
     * @param nums
     * @param m
     * @return
     */
    public boolean canSplitArray3(List<Integer> nums, int m) {
        //区间DP
        int n=nums.size();
        //f[i][j]:nums[i...j]能否拆分成合法数组
        boolean[][] f=new boolean[n][n];
        int[] pre=new int[n];
        pre[0]=nums.get(0);
        //构建前缀和数组
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums.get(i);
        }
        for(int i=n-1;i>=0;i--){
            f[i][i]=true;
            if(i+1<n) {
                f[i][i+1]=true;
            }
            for(int j=i+2;j<n;j++){
                //pre[j]-pre[i]表示sum(nums[i+1...j])
                //若sum(nums[i+1...j])>=m,那么nums[i...j]能否合法拆分取决于nums[i+1...j]能否合法拆分
                if(pre[j]-pre[i]>=m&&f[i+1][j]){
                    f[i][j]=true;
                }
                //pre[j]-pre[i]+nums.get(i)-nums.get(j)表示sum(nums[i...j-1])
                //这种写法可以防止数组越界
                //若sum(nums[i...j-1])>=m,那么nums[i...j]能否合法拆分取决于nums[i...j-1]能否合法拆分
                else if(pre[j]-pre[i]+nums.get(i)-nums.get(j)>=m&&f[i][j-1]){
                    f[i][j]=true;
                }else{
                    f[i][j]=false;
                }
            }
        }
        return f[0][n-1];
    }

}
