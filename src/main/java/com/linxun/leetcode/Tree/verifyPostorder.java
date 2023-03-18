package com.linxun.leetcode.Tree;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.Tree
 * @date 2022/11/10 10:37
 */
public class verifyPostorder {
    public static void main(String[] args) {
        int[] p={1,6,3,2,5};
        verifyPostorder(p);

    }
    public static boolean verifyPostorder(int[] postorder) {
        boolean sign=false;
        for(int i=0;i<postorder.length;i++){
            for(int j=i;j>=0;j--){
                if(postorder[j]<postorder[i]){
                    //出现了比当前小的
                    sign=true;
                }
                //出现了比当前结点大的且之前已经出现了比当前结点小的
                if(sign==true&&postorder[j]>postorder[i]) {
                    return false;
                }
            }
            sign=false;
        }
        return true;
    }
}
