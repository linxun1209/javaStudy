package com.linxun.leetcode.hot100;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2022/9/4 23:42
 */
public class LeetCode17 {
    // 数字到号码的映射
    private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    // 路径
    private StringBuilder sb = new StringBuilder();

    // 结果集
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0) return res;
        backtracking(digits,0);
        return res;

    }
    private void backtracking(String digits,int index){
        if(digits.length()==index){
            res.add(sb.toString());
            return;
        }
        String val=map[(digits.charAt(index)-'2')];
        for(char c:val.toCharArray()){
            sb.append(c);
            backtracking(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
