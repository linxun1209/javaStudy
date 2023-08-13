package com.linxun.leetcode.hot100;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/13 8:48
 */
public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        int[] minLeft=new int[len];
        int[] minRight=new int[len];
        minLeft[0]=-1;
        for (int i=1;i<len;i++){
            int t=i-1;
            while (t >= 0 && heights[t] >= heights[i]) {
                t = minLeft[t];
            }
            minLeft[i] = t;
        }
        minRight[len-1]=len;
        for (int i=len-2;i>=0;i--){
            int t=i+1;
            while(t < len && heights[t] >= heights[i]) {
                t = minRight[t];
            }
            minRight[i] = t;
        }
        int res=0;
        for (int i=0;i<len;i++){
            int sum=heights[i]*(minRight[i]-minLeft[i]-1);
                res=Math.max(sum,res);

        }
        return res;

    }


    int largestRectangleArea2(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();

        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }


    public int largestRectangleArea3(int[] heights) {
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        newHeight[heights.length+1] = 0;
        newHeight[0] = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int res = 0;
        for (int i = 1; i < newHeight.length; i++) {
            while (newHeight[i] < newHeight[stack.peek()]) {
                int mid = stack.pop();
                int w = i - stack.peek() - 1;
                int h = newHeight[mid];
                res = Math.max(res, w * h);
            }
            stack.push(i);

        }
        return res;
    }

}
