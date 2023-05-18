package com.linxun.leetcode.代码随想录.单调栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.单调栈
 * @date 2023/5/18 17:48
 */
public class nextGreaterElements {
        public int[] nextGreaterElements(int[] nums) {
            //边界判断
            if (nums == null || nums.length <= 1) {
                return new int[]{-1};
            }
            int size = nums.length;
            int[] result = new int[size];//存放结果
            Arrays.fill(result, -1);//默认全部初始化为-1
            Stack<Integer> st = new Stack<>();//栈中存放的是nums中的元素下标
            for (int i = 0; i < 2 * size; i++) {
                while (!st.empty() && nums[i % size] > nums[st.peek()]) {
                    result[st.peek()] = nums[i % size];//更新result
                    st.pop();//弹出栈顶
                }
                st.push(i % size);
            }
            return result;
        }
    public int[] nextGreaterElements2(int[] nums) {
            if(nums.length<=1||nums==null){
                return new int[]{-1};
            }
            int size=nums.length;
            int[] result=new int[size];
            Arrays.fill(result,-1);
            Stack<Integer> stack=new Stack<>();
            for (int i=0;i<size*2;i++){
                while (!stack.isEmpty()&&nums[i%size]>nums[stack.peek()]){
                    result[stack.peek()]=nums[i%size];
                    stack.pop();
                }
                stack.push(i%size);
            }
            return result;
    }
}
