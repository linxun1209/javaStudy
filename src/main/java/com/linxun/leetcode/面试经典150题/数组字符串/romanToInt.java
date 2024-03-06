package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 13. 罗马数字转整数
 * @date 2024/3/6 23:03
 */
public class romanToInt {
    public int romanToInt(String s) {
        int length = s.length();
        int[] num = new int[length];
        for (int i = 0; i < length; i++)
            switch (s.charAt(i)) {
                case 'I':
                    num[i] = 1;
                    break;
                case 'V':
                    num[i] = 5;
                    break;
                case 'X':
                    num[i] = 10;
                    break;
                case 'L':
                    num[i] = 50;
                    break;
                case 'C':
                    num[i] = 100;
                    break;
                case 'D':
                    num[i] = 500;
                    break;
                case 'M':
                    num[i] = 1000;
                    break;
            }
        //存放整数数组遍历的值和
        int sum=0;
        //遍历整数数组，数组尾数右边没有数，则最后一个数不用判断正负，就是它本身
        //所以遍历只遍历到数组倒数第二个数，同时避免了下标越界
        for (int i = 0; i <length-1; i++) {
            //有效罗马字符串拼接题目有给出，找出规律为下个数是当前数的10或5倍是有效拼接
            //题目给出的罗马字符串都是有效的，这里就简写判断为<=10,
            //否则要更加严谨的判断等于5或10倍，因为<=10包含2倍，但2倍实际上也是无效的，
            //如：500为D而不是DM
            num[i]=num[i]<num[i+1]&&num[i+1]/num[i]<=10?-num[i]:num[i];

            //将修改好的值相加
            sum+=num[i];
        }
        //整数数组和加上最后一个值
        return sum+num[length-1];
    }



    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}

