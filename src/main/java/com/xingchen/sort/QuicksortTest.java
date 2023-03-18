package com.xingchen.sort;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.sort
 * @date 2022/8/30 20:58
 */
public class QuicksortTest {
    //通过一趟排序，将要排序的数据分隔成独立的两部分，其中一部分的所有数据比另外一部分的所有数据都要小
    // ，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此使整个数据变成有序序列。
    public static void main(String[] args) {
        int[] number={13,15,24,99,14,11,1,2,3};
        System.out.println("排序前：");
        for(int val:number) {
            System.out.print(val+" ");
        }
        quick(number);
        System.out.println("\n排序后：");
        for(int val:number) {
            System.out.print(val +" ");
        }

    }
    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low]; // 数组的第一个值作为中轴（分界点或关键数据）
        while (low < high) {
            while (low < high && list[high] > tmp) {
                high--;
            }
            list[low] = list[high]; // 比中轴小的记录移到低端
            while (low < high && list[low] < tmp) {
                low++;
            }
            list[high] = list[low]; // 比中轴大的记录移到高端
        }
        list[low] = tmp; // 中轴记录到尾
        return low; // 返回中轴的位置
    }
    public static void unckSort(int[] list,int low,int high) {
        if(low < high) {
            int middle = getMiddle(list,low,high);    // 将list数组一分为二
            unckSort(list,low,middle-1);    // 对低字表进行递归排序
            unckSort(list,middle+1,high);    // 对高字表进行递归排序
        }
    }
    public static void quick(int[] str) {
        if(str.length > 0) {
            // 查看数组是否为空
            unckSort(str,0,str.length-1);
        }
    }
}
