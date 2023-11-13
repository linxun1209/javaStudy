package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/8/3 13:15
 *
 * 普通字符第三题
 *轮转数字
 *
 */
public class rotate {


    public void rotate3(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<=i;j++){
                int temp=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length/2;j++){
                int temp=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-j-1]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
    /**
     * 先转置再镜像
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<=i;j++){
                int temp=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;i<matrix.length/2;j++){
                int temp=matrix[i][matrix.length-i-j];
                matrix[i][matrix.length-i-j]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int tem=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=tem;

            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int tem=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=matrix[i][j];
                matrix[i][j]=tem;


            }
        }
    }
    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

}
