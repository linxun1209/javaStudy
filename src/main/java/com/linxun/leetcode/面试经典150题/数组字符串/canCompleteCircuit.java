package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 134. 加油站
 * @date 2024/3/5 20:19
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
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}

