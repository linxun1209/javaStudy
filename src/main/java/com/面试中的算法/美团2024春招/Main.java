package com.面试中的算法.美团2024春招;

import java.util.*;

public class Main {
   
        public static void main(String[] args) {   
   
            Scanner in = new Scanner(System.in);
   
            // 注意 hasNext 和 hasNextLine 的区别    
   
            while (in.hasNextInt()) { // 注意 while 处理多个 case    
   
                int n = in.nextInt();   
   
                int m = in.nextInt();   
   
                int q = in.nextInt();   
             //初始化HashSet容量以避免扩容
   
                Set<Long> edgesSet = new HashSet<>(m);
   
                while (m-- > 0) {   
   
                    long node1 = in.nextInt();   
   
                    long node2 = in.nextInt();   
   
                    long edge = node1 < node2 ? (node1 << 32) + node2 : (node2 << 32) + node1;   
   
                    edgesSet.add(edge);   
   
                }   
   
                  
   
                int[][] ops = new int[q][3];   
   
                while (q-- > 0) {   
   
                    ops[q][0] = in.nextInt();   
   
                    ops[q][1] = in.nextInt();   
   
                    ops[q][2] = in.nextInt();   
   
                    if (ops[q][0] == 1) {   
   
                        long edgeNum = ops[q][1] < ops[q][2] ? ((long)ops[q][1] << 32) + ops[q][2] : ((   
   
                                           long)ops[q][2] << 32) + ops[q][1];   
   
                        if (edgesSet.contains(edgeNum)) {   
   
                            edgesSet.remove(edgeNum);   
   
                        } else {   
   
                            ops[q][0] = 3;   
   
                        }   
   
                    }   
   
                }   
   
                //这里是Math.min(n, 100000)的原因是：有一个案例会阴你一手，给n=10^9，初始化并查集里的HashMap时会OOM
   
   
                UnionFind2 uf = new UnionFind2(Math.min(n, 100000));   
   
                for (long edge : edgesSet) {   
   
                    int a = (int) (edge >> 32);   
   
                    int b = (int) (edge & Integer.MAX_VALUE);   
   
                    uf.union(a, b );   
   
                }   
   
                boolean[] stack = new boolean[ops.length];   
   
                int top = 0;   
   
                for (int[] op : ops) {   
   
                    if (op[0] == 1) {   
   
                        uf.union(op[1], op[2] );   
   
                    } else if (op[0] == 2) {   
   
                        stack[top++] = uf.find(op[1] ) == uf.find(op[2]);   
   
                    }   
   
                }   
   
                //用StringBuilder一次性输出答案，以避免多次调用System.out.print()
   
   
                StringBuilder sb = new StringBuilder();   
   
                while (top > 0) {   
   
                    sb.append(stack[--top] ? "Yes\n" : "No\n");   
   
                }   
   
                System.out.print(sb.toString());   
   
            }   
   
        }   
 
   
        static class UnionFind2 {   
   
            Map<Integer, Integer> parents;
 
   
            public UnionFind2(int n) {   
   
                //初始化HashMap容量以避免扩容
   
   
                parents = new HashMap<>(n);
   
            }   
 
   
            public int find(int x) {   
   
                int xParent = parents.getOrDefault(x, -1);   
   
                if (xParent < 0) {   
   
                    return x;   
   
                }   
   
                parents.put(x, find(xParent));   
   
                return parents.get(x);   
   
            }   
 
   
            public void union(int x, int y) {   
   
                int rootX = find(x), rootY = find(y);   
   
                if (rootX == rootY) return;   
   
                int xRank = parents.getOrDefault(rootX, -1);   
   
                int yRank = parents.getOrDefault(rootY, -1);   
   
                if (xRank < yRank) {   
   
                    parents.put(rootX, xRank + yRank);   
   
                    parents.put(rootY, rootX);   
   
                } else {   
   
                    parents.put(rootY, xRank + yRank);   
   
                    parents.put(rootX, rootY);   
   
                }   
   
            }   
   
        }   
   
    }   

