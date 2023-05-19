package com.linxun.leetcode.每日挑战;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/5/18 21:40
 */
public class addNegabinary {
        // 将十进制转换为负二进制（1017. 负二进制转换）
        private int[] convert(BigInteger num) {
            BigInteger zero = new BigInteger("0");
            BigInteger one = new BigInteger("1");
            BigInteger negTwo = new BigInteger("-2");
            if (num.equals(zero)) {
                return new int[]{0};
            }
            ArrayList<Integer> res = new ArrayList<>();
            while (!num.equals(zero)) {
                BigInteger t;
                if (num.compareTo(zero) < 0) {
                    t = num.subtract(one).divide(negTwo);
                } else {
                    t = num.divide(negTwo);
                }
                res.add(num.subtract(t.multiply(negTwo)).intValue());
                num = t;
            }
            Collections.reverse(res);
            return res.stream().mapToInt(t -> t).toArray();
        }

        // 将负二进制转换为十进制
        private BigInteger to10(int[] arr) {
            BigInteger negTwo = new BigInteger("-2");
            int n = arr.length;
            BigInteger res = new BigInteger("0");
            for (int i = 0; i < n; i++) {
                res = res.add(negTwo.pow(i).multiply(new BigInteger(String.valueOf(arr[n - i - 1]))));
            }
            return res;
        }

        public int[] addNegabinary(int[] arr1, int[] arr2) {
            return convert(to10(arr1).add(to10(arr2)));
        }


    public int[] addNegabinary2(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        if(arr1.length < arr2.length){
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int l = arr1.length-1, r = arr2.length-1, k = 0;
        while(l >= 0){
            int m = arr1[l] + k;
            if(r >= 0) {
                m += arr2[r];
            }
            k = 0;
            if(m >= 2) {
                k = -1;
                m -= 2;
            } else if(m == -1) {
                m = 1;
                k = 1;
            }
            list.add(m);
            l--;
            r--;
        }
        if(k == 1) {
            list.add(1);
        } else if(k == -1) {
            list.add(1);
            list.add(1);
        }
        int size = list.size();
        l = size-1;
        while(list.get(l) == 0 && l > 0) {
            l--;
        }
        int[] arr = new int[l+1];
        for(int i=0;l >= 0; i++){
            arr[i] = list.get(l--);
        }
        return arr;
    }

}
