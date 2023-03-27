package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/27 8:10
 */
public class countSubstrings {
    public static void main(String[] args) {
        String a="aba";
        String b="baba";
        countSubstrings3(a,b);
    }


        public int countSubstrings4(String s, String t) {
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < s.length(); j++) {
                    sb.append(s.charAt(j));
                    for (int z = 0; z < t.length(); z++) {
                        StringBuilder sb1 = new StringBuilder();
                        for (int m = z; m < t.length(); m++) {
                            sb1.append(t.charAt(m));
                            int tmp = 0;
                            if (sb1.length() != sb.length()) {
                                continue;
                            }
                            for (int k = 0; k < sb.length(); k++) {
                                if (sb.charAt(k) != sb1.charAt(k)) {
                                    tmp++;
                                }
                            }
                            if (tmp == 1) {
                                ans++;
                            }
                        }
                    }
                }
            }
            return ans;
        }


    /**
     * 枚举法
     *
     * @param s
     * @param t
     * @return
     */
    public static int countSubstrings(String s, String t) {
        int m=s.length(),n=t.length(),ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int p1=i,p2=j,count=0;p1<m&&p2<n;p1++,p2++){
                    if(s.charAt(p1)!=t.charAt(p2)){count++;}
                    if(count==1){ans++;}
                    if(count==2){break;}
                }
            }
        }
        return ans;
    }


    /**
     * 动态规划
     *
     * @param s
     * @param t
     * @return
     */
    public static int countSubstrings3(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dpl = new int[m + 1][n + 1];
        int[][] dpr = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpl[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? (dpl[i][j] + 1) : 0;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dpr[i][j] = s.charAt(i) == t.charAt(j) ? (dpr[i + 1][j + 1] + 1) : 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    ans += (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }

}
