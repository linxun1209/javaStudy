package com.linxun.leetcode.hot;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/8/1 21:30
 */
public class search {
    public static void main(String[] args) {
        int[] nums={1,3};
        int target=3;
        search4(nums,target);
    }

    /**
     * 错误示范
     * 该方法弊端是会导致错乱
     * @param nums
     * @param target
     * @return
     */
    public static int search4(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r - 1) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[0]) {
                l = mid;
            } else if (nums[mid] < nums[0]) {
                r = mid;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }else{
                i++;
                continue;
            }

        }
        return -1;

    }
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r - 1) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[0]) {
                l = mid;
            } else if (nums[mid] < nums[0]) {
                r = mid;
            }
        }
        if (nums[0] <= target && nums[l] >= target) {
            r = l;
            l = 0;
        } else if (l < nums.length - 1 && nums[nums.length - 1] >= target && nums[l + 1] <= target) {
            l = l + 1;
            r = nums.length - 1;
        } else {
            return -1;
        }
        int pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                pos = mid;
                break;
            }
        }
        return pos;
    }

    public int search2(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else{
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }

    public int search3(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int len=nums.length;
        int l=0,r=len-1;
        while (l<=r){
            int mid=(r+l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<nums[r]){
                if(nums[mid]<target&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }else {
                if(nums[l]<=target&&target<nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}
