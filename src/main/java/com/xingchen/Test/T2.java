package com.xingchen.Test;


import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.Test
 * @date 2022/9/2 15:43
 */
public class T2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3};
        List<Integer> ans = new ArrayList<>();
        int target = 5;
        int[] temp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (ans.contains(target - nums[i])) {
                temp[0] = i;
                temp[1] = ans.get(target - nums[i]);

            }


        }
        System.out.println(Arrays.toString(temp));
    }
}
//        //定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//        LinkedList<Integer> ans=new LinkedList<>();
//        ans.add(1);
//        ans.add(2);
//        ans.add(3);
//        ans.add(4);
//        System.out.println(ans);