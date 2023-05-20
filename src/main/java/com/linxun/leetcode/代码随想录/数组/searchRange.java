package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2023/5/20 18:13
 */
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
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



    int[] searchRange2(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        // 情况三
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        // 情况二
        return new int[]{-1, -1};
    }

    int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        // 记录一下rightBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                right = middle - 1;
            } else { // 寻找右边界，nums[middle] == target的时候更新left
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        // 记录一下leftBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target) {
                // 寻找左边界，nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }



    // 解法2
// 1、首先，在 nums 数组中二分查找 target；
// 2、如果二分查找失败，则 binarySearch 返回 -1，表明 nums 中没有 target。此时，searchRange 直接返回 {-1, -1}；
// 3、如果二分查找成功，则 binarySearch 返回 nums 中值为 target 的一个下标。
// 然后，通过左右滑动指针，来找到符合题意的区间

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int index = binarySearch(nums, target); // 二分查找

            if (index == -1) { // nums 中不存在 target，直接返回 {-1, -1}
                return new int[] {-1, -1}; // 匿名数组
            }
            // nums 中存在 target，则左右滑动指针，来找到符合题意的区间
            int left = index;
            int right = index;
            // 向左滑动，找左边界
            while (left - 1 >= 0 && nums[left - 1] == nums[index]) {
                // 防止数组越界。逻辑短路，两个条件顺序不能换
                left--;
            }
            // 向右滑动，找右边界
            while (right + 1 < nums.length && nums[right + 1] == nums[index]) { // 防止数组越界。
                right++;
            }
            return new int[] {left, right};
        }

        /**
         * 二分查找
         * @param nums
         * @param target
         */
        public int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1; // 不变量：左闭右闭区间

            while (left <= right) { // 不变量：左闭右闭区间
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1; // 不变量：左闭右闭区间
                }
            }
            return -1; // 不存在
        }
    }


    // 解法三
    class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            int left = searchLeft(nums,target);
            int right = searchRight(nums,target);
            return new int[]{left,right};
        }
        public int searchLeft(int[] nums,int target){
            // 寻找元素第一次出现的地方
            int left = 0;
            int right = nums.length-1;
            while(left<=right){
                int mid = left+(right-left)/2;
                // >= 的都要缩小 因为要找第一个元素
                if(nums[mid]>=target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            // right = left - 1
            // 如果存在答案 right是首选
            if(right>=0&&right<nums.length&&nums[right]==target){
                return right;
            }
            if(left>=0&&left<nums.length&&nums[left]==target){
                return left;
            }
            return -1;
        }

        public int searchRight(int[] nums,int target){
            // 找最后一次出现
            int left = 0;
            int right = nums.length-1;
            while(left<=right){
                int mid = left + (right-left)/2;
                // <= 的都要更新 因为我们要找最后一个元素
                if(nums[mid]<=target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            // left = right + 1
            // 要找最后一次出现 如果有答案 优先找left
            if(left>=0&&left<nums.length&&nums[left]==target){
                return left;
            }
            if(right>=0&&right<=nums.length&&nums[right]==target){
                return right;
            }
            return -1;
        }
    }
}
