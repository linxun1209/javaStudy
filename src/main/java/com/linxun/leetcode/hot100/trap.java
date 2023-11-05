package com.linxun.leetcode.hot100;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/8/2 8:34
 *
 * 双指针4
 * 接雨水
 *
 */
public class trap {
    public int trap(int[] height) {
        int len=height.length;
        int ans=0;
        if(len<3){
            return 0;
        }
        int left_max[]=new int[len];
        int right_max[]=new int[len];
        left_max[0]=height[0];
        right_max[len-1]=height[len-1];
        for(int i=1;i<len;i++){
            left_max[i]=Math.max(left_max[i-1],height[i]);
        }
        for(int i=len-2;i>=0;i--){
            right_max[i]=Math.max(right_max[i+1],height[i]);
        }
        for(int i=0;i<len;i++){
            ans+=Math.min(left_max[i],right_max[i])-height[i];
        }
        return ans;

    }

    public int trap3(int[] height) {
        int i=0,ans=0;
        Stack<Integer> Stack=new Stack<>();
        while(i<height.length){
            while(!Stack.isEmpty()&&height[i]>height[Stack.peek()]){
                int top=Stack.pop();
                if(Stack.isEmpty()){
                    break;
                }
                int distance=i-Stack.peek()-1;
                int bought_height=Math.min(height[i],height[Stack.peek()])-
                        height[top];
                ans+=distance*bought_height;
            }
            Stack.push(i++);
        }
        return ans;
    }


    public int trap4(int[] height){
        int size = height.length;

        if (size <= 2) {
            return 0;
        }

        // in the stack, we push the index of array
        // using height[] to access the real height
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        int sum = 0;
        for (int index = 1; index < size; index++){
            int stackTop = stack.peek();
            if (height[index] < height[stackTop]){
                stack.push(index);
            }else if (height[index] == height[stackTop]){
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop();
                stack.push(index);
            }else{
                //pop up all lower value
                int heightAtIdx = height[index];
                while (!stack.isEmpty() && (heightAtIdx > height[stackTop])){
                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        int left = stack.peek();

                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) {
                            sum += hold;
                        }
                        stackTop = stack.peek();
                    }
                }
                stack.push(index);
            }
        }

        return sum;
    }

}
