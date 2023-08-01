package com.linxun.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/29 18:04
 */
public class generateParenthesis {
    List<String> str=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dns(n,n,"");
        return str;
    }

    private void dns(int left, int right, String s) {
        if(left==0&&right==0){
            str.add(s);
        }
        if(left>0){
            dns(left-1,right,str+"(");
        }
        if(right>0){
            dns(left,right-1,str+")");
        }
    }

    public List<String> generateParenthesis2(int n) {
        backtracking(n,0,0,new StringBuilder());
        return str;
    }

    private void backtracking(int n, int i, int i1, StringBuilder stringBuilder) {
        if(i==n&&i1==n){
            str.add(new StringBuilder(stringBuilder).toString());
            return;
        }
        if(i<n){
            stringBuilder.append("(");
            backtracking(n,i+1,i1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if(i1<i){
            stringBuilder.append(")");
            backtracking(n,i,i1+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }


}
