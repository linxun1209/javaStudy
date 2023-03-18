package com.xingchen.sort;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.sort
 * @date 2022/8/30 21:30
 */
public class InsertTest {
    //直接插入排序的基本思想是：将 n 个有序数存放在数组 a 中，要插入的数为 x，
    // 首先确定 x 插在数组中的位置 p，然后将 p 之后的元素都向后移一个位置，
    // 空出 a(p)，将 x 放入 a(p)，这样可实现插入 x 后仍然有序。
    public static void main(String[] args) {
        int[] number = { 13, 15, 24, 99, 4, 1 };
        System.out.println("排序前：");
        for (int val : number) { // 遍历数组元素
            System.out.print(val + " "); // 输出数组元素
        }
        int temp, j;
        for (int i = 1; i < number.length; i++) {
            temp = number[i];
            for (j = i - 1; j >= 0 && number[j] > temp; j--) {
                number[j + 1] = number[j];
            }
            number[j + 1] = temp;
        }
        System.out.println("\n排序后：");
        for (int val : number) { // 遍历数组元素
            System.out.print(val + " "); // 输出数组元素
        }
    }
}
