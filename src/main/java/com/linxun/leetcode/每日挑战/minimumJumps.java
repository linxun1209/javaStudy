package com.linxun.leetcode.每日挑战;

import lombok.experimental.var;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/30 19:23
 */
public class minimumJumps {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // 一维bfs搜索
        // 将数轴0和正半轴作为范围，原点0为起点，正向步幅a逆向步幅b，通过bfs搜索的方式从出发点开始模拟合法行走过程中的位置。
        // 每一步可以向前+a，也可以向后-b，但是要满足边界范围。当模拟过程中位置到达x则当前步数step为最小跳跃次数。
        // 题中已给出边界范围最小值为0，最大范围需要讨论获得，与正逆向步幅a、b有关，
        // 1、当a >= b时，由于逆向最多只能连续走一步，所以若a>=b说明每走两步都都起码保持原地或前进无法后退，
        // 当位置大于x+b时就永远无法回到更小的x，所以a >= b时最大极限位置为x + b。
        // 2、当a < b时，最大边界应该设置为max(max(forbidden) + a + b, x)，或者最小步数限制下最大极限位置为5997，
        // 当f ={1998},a = 1999, b = 2000, x = 2000,只能连续向前走三步，再后退才是到达x的最小步数，第一步只能向前1999，
        // 第二部无法回头因为b==2000>当前下标1999，会到-1违法，所以第二步只能从199再向前到3998，此时超过x按正常需要回退，
        // 但是3998-b = 1998时f中的不可达点，所以第三部仍只能向前3998+1999 = 5997，这就是最优条件下的可达右极限，
        // 伺候每次后退b前进a，相当于整体后退一步，从5997循环-b+a共3997轮后到达x点。
        // 2.5、max(max(forbidden) + a + b, x)公式理解：与上面举例一样，当f中最大不可达点为f1，此时若当前在f1 + b步处，
        // 那么下一步无法后退,因为后退b步 = f1不可达，那么只能从当前的f1+b再次向前+a，达到最远点f1 + b + a，f1 = max(f)。
        // 因为前提a<b，所以从最远点f1+a+b回退-b时为f1+a不再是最大不可达点f1，再回退b会略过f1到达其左侧的f1+a-b处。
        // 而若x与f1关系未知，所以若x在更右侧则极限应取更大的x，在最达的不可达点f1后续不会再有限制。、
        int[] dir = {-b, a};
        var list = new ArrayList<Integer>();
        int max = 0;
        for(int num : forbidden){
            list.add(num);
            max = Math.max(max, num);
        }
        max = a >= b ? x + b : Math.max(max + a + b, x);
        var que = new ArrayDeque<int[]>();
        que.offer(new int[]{0,0});
        boolean[][] vis = new boolean[max+1][2];
        int step = 0;
        vis[0][0] = vis[0][1] = true;
        while(!que.isEmpty()){
            int n = que.size();
            for(int i = 0; i < n; ++i){
                int[] p = que.poll();
                if(p[0] == x){
                    return step;
                }
                // k==0代表dir[0]向左走b步，k==1代表dir[1]向右走a步。
                for(int k = 0; k < 2; ++k){
                    if(p[1] == 0 && k == 0) continue;
                    int index = p[0] + dir[k];
                    // 后续只搜索合法位置index
                    if(index >= 0 && index <= max && !vis[index][k] && !list.contains(index)){
                        vis[index][k] = true;
                        que.add(new int[]{index, k});
                    }
                }
            }
            ++step;
        }
        return -1;
    }



    /**
     * 广度优先
     * @param forbidden
     * @param a
     * @param b
     * @param x
     * @return
     */
    public static int minimumJumps2(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue = new ArrayDeque<int[]>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.offer(new int[]{0, 1, 0});
        visited.add(0);
        int lower = 0, upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a, x) + b;
        Set<Integer> forbiddenSet = new HashSet<Integer>();
        for (int position : forbidden) {
            forbiddenSet.add(position);
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int position = arr[0], direction = arr[1], step = arr[2];
            if (position == x) {
                return step;
            }
            int nextPosition = position + a;
            int nextDirection = 1;
            if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                visited.add(nextPosition * nextDirection);
                queue.offer(new int[]{nextPosition, nextDirection, step + 1});
            }
            if (direction == 1) {
                nextPosition = position - b;
                nextDirection = -1;
                if (lower <= nextPosition && nextPosition <= upper && !visited.contains(nextPosition * nextDirection) && !forbiddenSet.contains(nextPosition)) {
                    visited.add(nextPosition * nextDirection);
                    queue.offer(new int[]{nextPosition, nextDirection, step + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] forbidden ={14,4,18,1,15};
        int a=3,b=15,c=9;
        minimumJumps2(forbidden,a,b,c);
    }
}
