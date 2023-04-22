package com.linxun.leetcode.代码随想录.贪心算法;

import java.util.Arrays;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.贪心算法
 * @date 2023/4/22 10:41
 */
public class findContentChildren {
    // 思路1：优先考虑饼干，小饼干先喂饱小胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l=g.length;
        int m=s.length;
        int i=0,j=0;
        while(i<l&&j<m){
            if(g[i]<=s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }

    // 思路2：优先考虑胃口，先喂饱大胃口
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        // 遍历胃口
        for (int index = g.length - 1; index >= 0; index--) {
            if(start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }

}
