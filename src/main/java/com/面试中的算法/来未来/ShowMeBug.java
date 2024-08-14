package com.面试中的算法.来未来;

import java.util.HashMap;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 从升序数组中找出两个数字，使得相加等于-个指定的值，时间复杂度O(n)
 * ，输出结果:是否找到，如果找到分别输出这两个数字
 * @date 2024/8/14 16:47
 */
public class ShowMeBug {
    /**
     * 解释:
     *     HashMap: 使用HashMap存储已经遍历过的元素及其索引。
     *     计算补数: 对于数组中的每个元素，计算补数 (sum - data[i])。
     *     检查配对: 如果HashMap中存在这个补数，说明找到了两个数，它们的和等于给定的值。
     *     返回结果: 如果找到配对，创建并返回Result对象；如果未找到配对，则返回null。
     *     这个实现的时间复杂度为O(n)，适合处理这个任务。
     */
    public static Result find(int data[], int sum) {
        // 使用HashMap存储差值和当前元素的索引。
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            int complement = sum - data[i];
            if (map.containsKey(complement)) {
                Result result = new Result();
                result.setNum1(complement);
                result.setNum2(data[i]);
                result.setSucess(true);
                return result;
            }
            map.put(data[i], i);
        }

        // 如果未找到任何配对，返回null
        return null;
    }

    public static class Result {
        private int num1;
        private int num2;
        private boolean sucess;

        public int getNum1() {
            return num1;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }

        public boolean isSucess() {
            return sucess;
        }

        public void setSucess(boolean sucess) {
            this.sucess = sucess;
        }
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 4, 7, 12, 15 };
        int sum = 14;
        Result rs = find(data, sum);
        if (null != rs) {
            System.out.println("found: " + rs.isSucess() + ", " + rs.getNum1() + ", " + rs.getNum2());
        } else {
            System.out.println("found: null");
        }
    }
}
