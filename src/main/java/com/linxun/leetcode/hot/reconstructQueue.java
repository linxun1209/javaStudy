package com.linxun.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/23 17:39
 */
public class reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);
        }

        return que.toArray(new int[people.length][]);
    }


    public static int[][] reconstructQueue2(int[][] people) {
        // 身高相同，按照个数升序排序；身高不同，按照身高降序排列（x 在 y 前面，x - y > 0 则交换位置。Arrays.sort默认升序
        Arrays.sort(people, (int[] a, int[] b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] i : people) {
            res.add(i[1], i);
            // 把数组放在目标索引位置上，原来有数了，会被往后挤

            // System.out.println(Arrays.deepToString(res.toArray()));
        }
        return res.toArray(new int[0][2]);
        // 容器转成数组
    }


}
