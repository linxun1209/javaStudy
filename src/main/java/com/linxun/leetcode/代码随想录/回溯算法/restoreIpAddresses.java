package com.linxun.leetcode.代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.回溯算法
 * @date 2023/4/17 11:59
 */
public class restoreIpAddresses {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
            // 算是剪枝了
        }
        backTrack(s, 0, 0);
        return result;
    }

    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {// 逗点数量为3时，分隔结束
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s,startIndex,s.length()-1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后⾯插⼊⼀个逗点
                pointNum++;
                backTrack(s, i + 2, pointNum);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;// 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }


    class Solution {
        List<String> result = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();

        public List<String> restoreIpAddresses(String s) {
            restoreIpAddressesHandler(s, 0, 0);
            return result;
        }

        // number表示stringbuilder中ip段的数量
        public void restoreIpAddressesHandler(String s, int start, int number) {
            // 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
            if (start == s.length() && number == 4) {
                result.add(stringBuilder.toString());
                return;
            }
            // 如果start等于s的长度但是ip段的数量不为4，或者ip段的数量为4但是start小于s的长度，则直接返回
            if (start == s.length() || number == 4) {
                return;
            }
            // 剪枝：ip段的长度最大是3，并且ip段处于[0,255]
            for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
                    && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
                // 如果ip段的长度大于1，并且第一位为0的话，continue
                if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                    continue;
                }
                stringBuilder.append(s.substring(start, i + 1));
                // 当stringBuilder里的网段数量小于3时，才会加点；如果等于3，说明已经有3段了，最后一段不需要再加点
                if (number < 3) {
                    stringBuilder.append(".");
                }
                number++;
                restoreIpAddressesHandler(s, i + 1, number);
                number--;
                // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
                stringBuilder.delete(start + number, i + number + 2);
            }
        }
    }
}
