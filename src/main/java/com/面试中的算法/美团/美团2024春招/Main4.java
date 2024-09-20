package com.面试中的算法.美团.美团2024春招;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/8/18 13:34
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        int[][] arr = new int[m][2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            map.put(a, b);
            map.put(b, a);
        }
        int[][] ans = new int[q][3];
        for (int i = 0; i < q; i++) {
            ans[i][0] = sc.nextInt();
            ans[i][1] = sc.nextInt();
            ans[i][2] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            if (ans[i][0] == 1 && map.containsKey(ans[i][1])) {
                map.remove(map.get(ans[i][1]));
                map.remove(ans[i][1]);
                continue;
            }else if(ans[i][0]==2){
                if (check(map, ans[i])) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");

                }

            }

            //保证至少存在一次查询操作。
        }
    }
    private static boolean check(Map<Integer, Integer> map, int[] ans) {
        Integer value1 = map.get(ans[1]);
        Integer value2 = map.get(ans[2]);
        if(map.containsKey(ans[1])&&map.containsKey(ans[2])){
            if(map.get(ans[1])==2&&map.get(ans[2])==2)
                return true;
        }
        return false;
    }
}


