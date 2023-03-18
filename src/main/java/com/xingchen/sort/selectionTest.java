package com.xingchen.sort;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.sort
 * @date 2022/8/30 21:15
 */
public class selectionTest {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,1};
        String end="\n";
        int index;
        for (int i = 0; i < arr.length; i++) {
            index=0;
            for (int j = 1; j < arr.length; j++) {
                if(arr[j]>arr[index]){
                    index=j;
                }

            }
            end=arr[index]+" "+end;
            int temp=arr[arr.length-1];
            arr[arr.length-1]=arr[index];
            arr[index]=temp;
            System.out.print("[");
            for (int j = 0; j < arr.length-1; j++) {
                System.out.print(arr[j]+" ");

            }
            System.out.print("]"+end);
        }

    }
}
