package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/8/1 22:08
 */
public class searchRange {
    public int[] searchRange2(int[] nums, int target) {
        int left=0,rigt=nums.length-1;
        while (left<=rigt){
            while (left<rigt&&nums[left]<target){
                left++;
            }
            while (left<rigt&&nums[rigt]>target){
                rigt--;
            }
            if(nums[left]==target&&nums[rigt]==target){
                return new int[]{left,rigt};
            }else {
                break;
            }
        }
        return new int[]{-1,-1};
    }

    public int[] searchRange(int[] nums, int target) {

        int left=0,right=nums.length-1;
        while(left<=right){
            while(left<right&&nums[left]<target){
                left++;

            }while(left<right&&nums[right]>target){
                right--;

            }
            if(nums[left]==target&&nums[right]==target){
                return new int[]{left,right};

            }else{
                break;
            }
        }
        return new int[]{-1,-1};
    }

    public int[] searchRange3(int[] nums, int target) {
        int[] res=new int[]{-1,1};
        res[0]=binarySearch(nums,target,true);
        res[1]=binarySearch(nums,target,false);
        return res;

    }
    public int binarySearch(int[] nums,int target,boolean leftOrRight){
        int res=-1;
        int left=0,right=nums.length-1,mid;
        while(left<=right){
            mid=left+(right-left)/2;
            if(target<nums[mid]){
                right=mid-1;
            }
            else if(target>nums[mid]){
                left=mid+1;
            }
            else{
                res=mid;
                if(leftOrRight) {
                    right=mid-1;
                } else {
                    left=mid+1;
                }

            }

        }
        return res;

    }
}
