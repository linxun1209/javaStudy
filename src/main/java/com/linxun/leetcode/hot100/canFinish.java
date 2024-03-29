package com.linxun.leetcode.hot100;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/12/21 17:48
 */
public class canFinish {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        canFinish(numCourses,prerequisites);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int len=prerequisites.length;
        if (len==0){
            return true;
        }
        int[] pointer=new int[numCourses];
        //首先，统计每个课程的入度，即有多少课程依赖于该课程
        for (int[] p:prerequisites){
            ++pointer[p[1]];
        }
        //接着，使用一个布尔数组 removed 来标记每个先修关系是否被移除。初始化时，所有先修关系都未被移除。
        boolean[] removed=new boolean[len];
        int remove=0;
        //进入主循环，循环的目标是移除所有可以被移除的先修关系。
        while (remove<len){

            int currentRemove=0;
            for (int i=0;i<len;i++){

                if(removed[i]) continue;
                int[] p=prerequisites[i];
                //在每次循环中，遍历所有的先修关系，检查每个先修关系是否可以被移除。
                //如果可以被移除，即该先修关系的起始课程入度为 0，则将终点课程的入度减 1，并将该先修关系标记为已移除。
                if(pointer[p[0]]==0){
                    --pointer[p[1]];
                    removed[i]=true;
                    ++currentRemove;
                }
            }
            //如果在一次循环中没有移除任何先修关系，则说明存在循环依赖，返回 false。
            if(currentRemove==0){
                return false;
            }
            remove+=currentRemove;
        }
        //当所有先修关系都被移除后，返回 true，即课程先修关系合法。
        return true;
    }

    public boolean canFinish2(int n, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len == 0) return true;
        int[] pointer = new int[n];// 每个课程被指向的次数
        for (int[] p : prerequisites) ++pointer[p[1]];
        boolean[] removed = new boolean[len];// 标记prerequisites中的元素是否被移除
        int remove = 0;// 移除的元素数量
        while (remove < len) {
            int currRemove = 0;// 本轮移除的元素数量
            for (int i = 0; i < len; i++) {
                if (removed[i]) continue;// 被移除的元素跳过
                int[] p = prerequisites[i];
                if (pointer[p[0]] == 0) {// 如果被安全课程指向
                    --pointer[p[1]];// 被指向次数减1
                    removed[i] = true;
                    ++currRemove;
                }
            }
            if (currRemove == 0) return false;// 如果一轮跑下来一个元素都没移除，则没必要进行下一轮
            remove += currRemove;
        }
        return true;
    }

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public  boolean canFinish3(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }


    public boolean canFinish4(int n, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len == 0) return true;
        int[] pointer = new int[n];
        Queue<int[]> queue = new ArrayDeque<>(len);
        for (int[] p : prerequisites) {
            ++pointer[p[1]];
            queue.offer(p);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                if (pointer[p[0]] == 0) --pointer[p[1]];
                else queue.offer(p);
            }
            if (size == queue.size()) return false;
        }
        return true;
    }




         /*
     拓扑排序解决
     １．将入度为０的节点加入队列
     ２．出队列的时候将这个顶点的所有临界点的入度减１，并将出队列的元素加入结果集合，如果入度为０则继续入队列
     ３．最后检查结果集合中的元素是否和课程数相同
      */
     public boolean canFinish5(int numCourses, int[][] prerequisites) {
         //存储各个课程的入度
         int[] input = new int[numCourses];
         //入度为０的顶点个数
         int count = 0;
         LinkedList<Integer> queue = new LinkedList<>();
         for(int[] pre:prerequisites){
             //统计入度
             input[pre[0]]++;
         }
         //寻找入度为０的元素，入队
         for(int i=0;i<numCourses;i++){
             if(input[i]==0){
                 queue.addLast(i);
             }
         }

         while(!queue.isEmpty()){
             int node = queue.removeFirst();
             count++;
             //把与node相关的临界点的入度减１
             for(int[] pre:prerequisites){
                 if(pre[1]==node){
                     input[pre[0]]--;
                     if(input[pre[0]]==0){
                         queue.addLast(pre[0]);
                     }
                 }
             }
         }

         return count==numCourses;
     }
}