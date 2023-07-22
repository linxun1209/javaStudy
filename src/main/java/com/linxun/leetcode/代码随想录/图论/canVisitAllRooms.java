package com.linxun.leetcode.代码随想录.图论;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.图论
 * @date 2023/6/7 21:45
 */
public class canVisitAllRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<Integer>()); // 添加一个空的子List
        canVisitAllRooms(rooms);
    }
    private static void dfs(int key, List<List<Integer>>  rooms, List<Boolean> visited) {
        if (visited.get(key)) {
            return;
        }
        visited.set(key, true);
        for (int k : rooms.get(key)) {
            // 深度优先搜索遍历
            dfs(k, rooms, visited);
        }
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<Boolean>(){{
            for(int i = 0 ; i < rooms.size(); i++){
                add(false);
            }
        }};
        dfs(0, rooms, visited);
        //检查是否都访问到了
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }


    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];    // 用一个 visited 数据记录房间是否被访问
        visited[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);           // 第 0 个房间标记为已访问
        while (!queue.isEmpty()) {
            int curKey = queue.poll();
            for (int key: rooms.get(curKey)) {
                if (visited[key]) {
                    continue;
                }
                visited[key] = true;
                queue.add(key);
            }
        }
        for (boolean key: visited) {
            if (!key) {
                return false;
            }
        }
        return true;
    }


    public boolean canVisitAllRooms3(List<List<Integer>> rooms) {
        int count = 1;      // 用来记录可以被访问的房间数目，因为初始状态下 0 号房间可以被访问，所以置为 1
        boolean[] visited = new boolean[rooms.size()];      // 用一个 visited 数据记录房间是否被访问
        visited[0] = true;          // 第 0 个房间标记为已访问
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curKey = queue.poll();
            for (int key: rooms.get(curKey)) {
                if (visited[key]) {
                    continue;
                }
                ++count;                // 每访问一个访问房间就让 count 加 1
                visited[key] = true;
                queue.add(key);
            }
        }
        return count == rooms.size();       // 如果 count 等于房间数目，表示能进入所有房间，反之不能
    }
}
