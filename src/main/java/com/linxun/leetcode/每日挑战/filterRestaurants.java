package com.linxun.leetcode.每日挑战;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/9/27 22:40
 */
public class filterRestaurants {
    public static void main(String[] args) {
        int[][] restaurants = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        int veganFriendly = 1, maxPrice = 50, maxDistance = 10;
        filterRestaurants(restaurants,veganFriendly,maxPrice,maxDistance);
    }
    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int n = restaurants.length;
        List<int[]> filtered = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            if (restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance && !(veganFriendly == 1 && restaurants[i][2] == 0)) {
                filtered.add(restaurants[i]);
            }
        }
        Collections.sort(filtered, (a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });
        List<Integer> res = new ArrayList<Integer>();
        for (int[] v : filtered) {
            res.add(v[0]);
        }
        return res;
    }
}
