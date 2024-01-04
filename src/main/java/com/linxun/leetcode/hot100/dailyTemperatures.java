package com.linxun.leetcode.hot100;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/24 15:20
 */
public class dailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures={73,74,75,71,69,72,76,73};
        dailyTemperatures2(temperatures);
    }

    /**
     * 双重for循环
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        int[] ans=new int[len];
        for (int i=0;i<len-1;i++){
            for (int j=i+1;j<len;j++){
                if(temperatures[i]<temperatures[j]){
                    ans[i]=j-i;
                    break;
                }
            }
        }
        return ans;
    }


    /**
     * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
     * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
     * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
     * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
     * - 若T[i] < T[i+1]，那么res[i]=1；
     * - 若T[i] > T[i+1]
     *   - res[i+1]=0，那么res[i]=0;
     *   - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */



    public static int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        //倒数第二个开始
        for (int i = T.length - 2; i >= 0; i--) {
            //倒数第一个开始
            for (int j = i + 1; j < T.length; j += res[j]) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }


    /**
     * 单调栈
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures3(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            /**
             * 取出下标进行元素值的比较
             */
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            /**
             * 注意 放入的是元素位置
             */
            stack.push(i);
        }
        return res;
    }
}
