package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/18 10:50
 */
public class checkPalindromeFormation {
    public static void main(String[] args) {
        String a="abc",b="cbd";
        checkPalindromeFormation2(a,b);
    }





    public boolean checkPalindromeFormation1(String a, String b) {
        String a_ = new StringBuilder(a).reverse().toString();
        String b_ = new StringBuilder(b).reverse().toString();
        return checkPalindromeFormation_(a,b) || checkPalindromeFormation_(b,a)
                || checkPalindromeFormation_(a_,b_) || checkPalindromeFormation_(b_,a_);
    }
    private boolean checkPalindromeFormation_(String a,String b){
        int left = 0 , right = a.length()-1;
        while(left < right){
            if(a.charAt(left) != b.charAt(right)){
                if(b != a){
                    b = a;
                    continue;
                }
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



    public static boolean checkPalindromeFormation2(String a, String b) {
        //sign为true表示分开走，false表示走a或b
        //chose为true表示走a路，false表示走b路
        boolean sign=true,chose=true;
        int n=a.length(),i=0,j=n-1;
        for(;i<j;i++,j--) {
            if(sign) {
                if(a.charAt(i)!=b.charAt(j)) {
                    sign=!sign;
                } else {
                    continue;
                }
            }
            if(chose) {
                if(a.charAt(i)!=a.charAt(j)) {
                    chose=!chose;
                } else {
                    continue;
                }
            }
            if(b.charAt(i)!=b.charAt(j)) {
                break;
            }
        }
        if(i>=j) {
            return true;
        }

        String tmp=a;
        //交换串a串b，重置变量后再来一次
        a=b;
        b=tmp;
        for(;i<j;i++,j--) {
            if(sign) {
                if(a.charAt(i)!=b.charAt(j)) {
                    sign=!sign;
                } else {
                    continue;
                }
            }
            if(chose) {
                if(a.charAt(i)!=a.charAt(j)) {
                    chose=!chose;
                } else {
                    continue;
                }
            }
            if(b.charAt(i)!=b.charAt(j)) {
                break;
            }
        }
        return i>=j;
    }
}
