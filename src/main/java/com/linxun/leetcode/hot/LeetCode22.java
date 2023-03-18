package com.linxun.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2022/9/5 11:04
 */

/**
 * 方法一
 */
//public class LeetCode22 {
//    List<String> res = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        String ans="";
//        backtracking(ans,n,n);
//        return res;
//    }
//    void backtracking(String ans,int left,int right){
//        if(left==0&&right==0){
//            res.add(ans);
//            return;
//        }
//
////        if(left==right){
////            backtracking(ans+"(",left-1,right);
////        }
////        else if(left<right){
////            if(left>0){
////                backtracking(ans+"(",left-1,right);
////            }
////
////            backtracking(ans+")",left,right-1);
////        }
//
//    }
//}
/**
 * 方法二
 *
 */
public class LeetCode22 {
        List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtracking(n,0,0,new StringBuilder());


        return  res;
    }
    void backtracking(int n,int left,int right,StringBuilder sb){
        if(right==n&&right==n){
            res.add(new StringBuffer(sb).toString());
            return;
        }
        if(left<n){
            sb.append("(");
            backtracking(n,left+1,right,sb);
            sb.deleteCharAt(sb.length()-1);

        }
        if(right<left){
            sb.append(")");
            backtracking(n,left,right+1,sb);
            sb.deleteCharAt(sb.length()-1);

        }

    }

}