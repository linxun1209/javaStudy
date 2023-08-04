package com.linxun.leetcode.hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/23 17:29
 */
public class calcEquation {


     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int count=0;
            //统计出现的所有字符，并赋予对应的index
            Map<String,Integer> map=new HashMap<>();
            for (List<String> list:equations){
                for (String s:list){
                    if(!map.containsKey(s)){
                        map.put(s,count++);
                    }
                }
            }

            //构建一个矩阵来代替图结构
            double[][] graph=new double[count+1][count+1];

            //初始化
            for (String s:map.keySet()){
                int x=map.get(s);
                graph[x][x]=1.0;
            }
            int index=0;
            for (List<String> list:equations){
                String a=list.get(0);
                String b=list.get(1);
                int aa=map.get(a);
                int bb=map.get(b);
                double value=values[index++];
                graph[aa][bb]=value;
                graph[bb][aa]=1/value;
            }

            //通过Floyd算法进行运算
            int n=count+1;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    for (int k=0;k<n;k++){
                        if(j==k||graph[j][k]!=0) {
                            continue;
                        }
                        if(graph[j][i]!=0&&graph[i][k]!=0){
                            graph[j][k]=graph[j][i]*graph[i][k];
                        }
                    }
                }
            }

            //直接通过查询矩阵得到答案
            double[] res=new double[queries.size()];
            for (int i=0;i<res.length;i++){
                List<String> q=queries.get(i);
                String a=q.get(0);
                String b=q.get(1);
                if(map.containsKey(a)&&map.containsKey(b)){
                    double ans=graph[map.get(a)][map.get(b)];
                    res[i]=(ans==0?-1.0:ans);
                }else {
                    res[i]=-1.0;
                }
            }
            return res;
     }

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;

        /**
         * 指向的父结点的权值
         */
        private double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // 关系式的推导请见「参考代码」下方的示意图
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return 根结点的 id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }


}
