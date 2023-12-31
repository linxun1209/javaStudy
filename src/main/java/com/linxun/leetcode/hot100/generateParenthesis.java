package com.linxun.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/7/29 18:04
 */
public class generateParenthesis {



    /**
     * 报错
     * @param n
     * @return
     */
    List<String> str=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dns(n,n,"");
        return str;
    }

    private void dns(int left, int right, String s) {
        if(left==0&&right==0){
            str.add(s);
            return;
        }
        if(left>0){
            dns(left-1,right,str+"(");
        }
        if(right>0){
            dns(left,right-1,str+")");
        }
    }


    /**
     * 回溯
     *
     * @param n
     * @return
     */
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


    StringBuffer path = new StringBuffer();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis3(int n) {
        backtracking(0, 0, n);
        return res;
    }

    void backtracking(int l, int r, int n) {
        if (l > n || l < r) { // 剪枝
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path.toString());
        }
        for (int i = 0; i < 2; i++) { // 将括号看作大小为 2 的数组，求他们的有效组合，括号个数决定了树的深度
            if (i == 0) {
                path.append("(");
                backtracking(l + 1, r, n);
                path.deleteCharAt(path.length() - 1); // 回溯
            }
            if (i == 1) {
                path.append(")");
                backtracking(l, r + 1, n);
                path.deleteCharAt(path.length() - 1); // 回溯
            }
        }
    }


    /**
     * 找规律递归
     * @param n
     * @return
     */

    public List<String> generateParenthesis4(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }

    public List<String> generateParenthesis5(int n) {
        List<String > ans=new ArrayList<>();
        backtracking1(n,ans,0,0,"");
        return ans;
    }
    private void backtracking1(int n,List<String> ana,int left,int right,String s){
        if(right>left){
            return;
        }
        if(left==n&&right==n){
            ana.add(s);
            return;
        }
        if(left<n){
            backtracking1(n,ana,left+1,right,s+"(");
        }
        if(right<left){
            backtracking1(n,ana,left,right+1,s+")");
        }
    }





}
