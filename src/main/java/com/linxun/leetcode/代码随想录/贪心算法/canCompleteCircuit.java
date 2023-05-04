package com.linxun.leetcode.代码随想录.贪心算法;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/5/4 21:34
 */
public class canCompleteCircuit {
//    1、两个数组之差的总和必须大于等于0，否则不能完成绕行
//    2、 一个站的收益如果小于0，肯定不能作为起点；而连续的多个站也可以等效地看做一个站，
//    如果其累积收益小于0，就跳过，寻找下一个。
    public int canCompleteCircuit(int[] gas,int[] cost){
        int n=gas.length;
        int total_tank=0;
        int curr_tank=0;
        int start_station=0;
        for (int i=0;i<n;i++){
            total_tank+=gas[i]-cost[i];
            curr_tank+=gas[i]-cost[i];
            if(curr_tank<0){
                start_station=i+1;
                curr_tank=0;
            }
        }
        return total_tank>=0?start_station:-1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            min = Math.min(sum, min);
        }

        if (sum < 0) {
            return -1;
        }
        if (min >= 0) {
            return 0;
        }

        for (int i = gas.length - 1; i > 0; i--) {
            min += (gas[i] - cost[i]);
            if(min >= 0) {
                return i;
            }
        }

        return -1;
    }

    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length ;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return index;
    }

}
