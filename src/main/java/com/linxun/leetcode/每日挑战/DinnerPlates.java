package com.linxun.leetcode.每日挑战;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/28 8:37
 */
public class DinnerPlates {
    int capacity;
    List<List<Integer>> list;
    TreeSet<Integer> notFullSet, notEmptySet;

    void print() {
        for (List<Integer> t : list) {
            for (int x : t) {
                System.out.print(x + " ");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }


    /**
     * 初始化
     * @param _capacity
     */
    public DinnerPlates(int _capacity) {
        capacity = _capacity;
        list = new ArrayList<>();
        notEmptySet = new TreeSet<>();
        notFullSet = new TreeSet<>();
    }

    public void push(int val) {
        int index = -1;
        if (notFullSet.isEmpty()) {
            list.add(new ArrayList<>(capacity));
            index = list.size() - 1;
            notFullSet.add(index);
        } else {
            index = notFullSet.first();
        }
        List<Integer> stk = list.get(index);
        stk.add(val);
        if (stk.size() == capacity) {
            notFullSet.remove(index);
        }
        if (stk.size() == 1) {
            notEmptySet.add(index);
        }
    }

    public int pop() {
        if (notEmptySet.isEmpty()) {
            return -1;
        }
        return popAtStack(notEmptySet.last());
    }

    public int popAtStack(int index) {
        if (!notEmptySet.contains(index)) {
            return -1;
        }
        List<Integer> stk = list.get(index);
        int x = stk.get(stk.size() - 1);
        stk.remove(stk.size() - 1);
        if (stk.size() == 0) {
            notEmptySet.remove(index);
        }
        if (stk.size() == capacity - 1) {
            notFullSet.add(index);
        }
        return x;
    }
}
