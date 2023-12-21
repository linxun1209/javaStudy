package com.linxun.leetcode.hot100;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/12/21 16:39
 */
public class orangesRotting {


    public static void main(String[] args) {
        int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        orangesRotting(grid);
    }



    public static int orangesRotting(int[][] grid) {
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }



    public int orangesRotting2(int[][] grid) {
        //1.定义2个int数组，2个一组来记录腐烂橘子的上下左右位置。腐烂橘子(0，0)
        //在矩阵中 上{-1,0}   下{1,0}  左{0,-1}   右{0,1}
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int step = 0;//感染次数
        int flash = 0;//新鲜橘子数（后面用于判定是否为-1）

        int row = grid.length;//所给矩阵行
        int col = grid[0].length;//列

        Queue<int[]> queue = new ArrayDeque<>();
        //2.遍历矩阵 将所有的腐烂橘子入队，并且记录初始新鲜橘子数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    flash++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        //3.遍历所有腐烂橘子，同时感染四周
        while (flash > 0 && !queue.isEmpty()) {//有橘子且队列不空
            step++;
            //队列中现有的所有腐烂橘子都要进行一次感染
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] poll = queue.poll();//腐烂橘子
                for (int i = 0; i < 4; i++) {
                    //4个位置dx[i] dy[i]  ， xy 为要感染的橘子位置
                    int x = poll[0] + dx[i];//第x行
                    int y = poll[1] + dy[i];//第y列
                    if ((x >= 0 && x < row) && (y >= 0 && y < col) && grid[x][y] == 1) {
                        //xy不越界，并且要感染的地方是 新鲜橘子
                        grid[x][y] = 2;
                        //把被感染的橘子 入队
                        queue.offer(new int[]{x, y});
                        //新鲜橘子-1
                        flash--;
                    }
                }
            }

        }

        //感染完了之后如果还有新鲜橘子
        if (flash > 0) {
            return -1;
        } else {
            return step;
        }
    }

    int[] dirX = new int[] {-1, 0, 1, 0};
    int[] dirY = new int[] {0, 1, 0, -1};

    public int orangesRotting3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 是否新鲜橘子标记
        boolean[][] isFresh = new boolean[m][n];
        // 广度优先搜索是否遍历标记
        boolean[][] vis = new boolean[m][n];
        int res = 0, fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 新鲜橘子标记，新鲜橘子总数量加一
                    isFresh[i][j] = true;
                    fresh += 1;
                }
                if (grid[i][j] == 2) {
                    // 广度优先遍历腐烂橘子
                    queue.offer(new int[] {i, j});
                    vis[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty() && fresh > 0) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] org = queue.poll();
                // 上下左右方向
                for (int j = 0; j < 4; j++) {
                    int dx = org[0] + dirX[j];
                    int dy = org[1] + dirY[j];
                    if (dx < 0 || dx >= m || dy < 0 || dy >= n || grid[dx][dy] == 0 || vis[dx][dy]) {
                        continue;
                    }
                    // 新鲜橘子 -> 腐烂橘子
                    if (grid[dx][dy] == 1 && isFresh[dx][dy]) {
                        fresh--;
                        isFresh[dx][dy] = false;
                    }
                    queue.offer(new int[] {dx, dy});
                    vis[dx][dy] = true;
                }
            }
        }
        // 所有腐烂橘子已经扩散腐烂完，仍有新鲜橘子
        if (queue.isEmpty() && fresh > 0) {
            return -1;
        }
        return res;
    }

}
