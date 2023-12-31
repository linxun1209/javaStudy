package com.linxun.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 回溯思路
 *
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/22 17:44
 */
public class letterCombinations {
    //设置全局列表存储最后的结果
    List<String> list = new ArrayList<>();



    public List<String> letterCombinations2(String digits) {
        if(digits==null||digits.length()==0){
            return list;
        }
        //模拟案件手机的键盘
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backend1(digits,numString,0);
        return list;
    }


    StringBuilder temp1 = new StringBuilder();
    private void backend1(String digits,String[] numString,int k){
        if (digits.length()==k){
            list.add(temp1.toString());
            return;
        }
        String s = numString[digits.charAt(k) - '0'];
        for (int i=0;i<s.length();i++){
            temp1.append(s.charAt(i));
            backend1(digits,numString,k+1);
            temp1.deleteCharAt(temp1.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, numString, 0);
        return list;
    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public void backTracking(String digits, String[] numString, int num) {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
