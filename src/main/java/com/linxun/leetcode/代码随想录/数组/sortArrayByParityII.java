package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2023/5/21 13:43
 */
public class sortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        // 分别存放 nums 中的奇数、偶数
        int len = nums.length;
        int evenIndex = 0;
        int oddIndex = 0;
        int[] even = new int[len / 2];
        int[] odd = new int[len / 2];
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                even[evenIndex++] = nums[i];
            } else {
                odd[oddIndex++] = nums[i];
            }
        }
        // 把奇偶数组重新存回 nums
        int index = 0;
        for (int i = 0; i < even.length; i++) {
            nums[index++] = even[i];
            nums[index++] = odd[i];
        }
        return nums;
    }

    public int[] sortArrayByParityII2(int[] nums) {
        //定义双指针
        int oddPoint = 1, evenPoint = 0;
        //开始移动并交换，最后一层必然为相互交换后再移动或者相同直接移动
        while(oddPoint < nums.length && evenPoint < nums.length){
            //进行判断
            if(nums[oddPoint] % 2 == 0 && nums[evenPoint] % 2 == 1){    //如果均不满足
                int temp = 0;
                temp = nums[oddPoint];
                nums[oddPoint] = nums[evenPoint];
                nums[evenPoint] = temp;
                oddPoint += 2;
                evenPoint += 2;
            }else if(nums[oddPoint] % 2 == 0 && nums[evenPoint] % 2 == 0){  //偶数满足
                evenPoint += 2;
            }else if(nums[oddPoint] % 2 == 1 && nums[evenPoint] % 2 == 1){  //奇数满足
                oddPoint += 2;
            }else{
                oddPoint += 2;
                evenPoint += 2;
            }
        }
        return nums;
    }

}
