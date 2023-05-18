package com.linxun.leetcode.代码随想录.单调栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.单调栈
 * @date 2023/5/17 22:40
 */
public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> temp=new Stack<>();
        int[] res=new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<nums1.length;i++){
            hashMap.put(nums1[i],1);
        }
        temp.add(0);
        for (int i=1;i<nums2.length;i++){
            if(nums2[i]<=nums2[temp.peek()]){
                temp.add(i);
            }else {
                while (!hashMap.isEmpty()&&nums2[temp.peek()]<nums2[i]){
                    if(hashMap.containsKey(nums2[temp.peek()])){
                        Integer index=hashMap.get(nums2[temp.peek()]);
                        res[index]=nums2[i];
                    }
                    temp.pop();
                }
                temp.add(i);
            }
        }
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int pre = nums2[stack.pop()];
                if (map.containsKey(pre)) {
                    res[map.get(pre)] = nums2[i];
                }
            }
            stack.push(i);
        }

        return res;
    }
}
