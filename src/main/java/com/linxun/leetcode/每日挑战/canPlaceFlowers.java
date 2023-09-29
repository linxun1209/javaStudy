package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/9/29 20:30
 */
public class canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=0;
        int m=flowerbed.length;
        while (i<m) {
            if (flowerbed[i] == 0) {
                if (i == m - 1) {
                    n--;
                    break;
                } else if (flowerbed[i + 1] == 0) {
                    n--;
                    i += 2;
                } else {
                    i += 3;
                }
            } else {
                i += 2;
            }
        }
        return n <= 0;
    }


    public boolean canPlaceFlowers2(int[] flowerbed, int n) {

            int available = 0;
            boolean valid = true;
            for (int i = 0; i < flowerbed.length; i++) {
                if(flowerbed[i]==1){
                    valid=false;
                }else if(flowerbed[i]==0) {
                    if (valid && (i < flowerbed.length - 1 && flowerbed[i+1] == 0 || i == flowerbed.length - 1)) {
                        available++;
                        valid = false;
                    } else {
                        valid = true;
                    }
                }
            }
            return available >= n;

    }


    public boolean canPlaceFlowers3(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }
}
