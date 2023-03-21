package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/21 18:13
 *
 * 开氏度 = 摄氏度 + 273.15
 * 华氏度 = 摄氏度 * 1.80 + 32.00
 *
 */
public class convertTemperature {
    public double[] convertTemperature(double celsius) {

        double[] doubles=new double[2];
        doubles[0]=celsius+273.15;
        doubles[1]=celsius*1.80+32.00;
        return doubles;


    }
}
