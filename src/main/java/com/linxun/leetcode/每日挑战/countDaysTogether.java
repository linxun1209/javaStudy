package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/17 12:47
 */
public class countDaysTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aa = getTime(arriveAlice);
        int la = getTime(leaveAlice);
        int ab = getTime(arriveBob);
        int lb = getTime(leaveBob);
        return Math.max(0, Math.min(la, lb) - Math.max(aa, ab) + 1);
    }
    // 求出日期所对应的时间戳
    public int getTime(String date) {
        int m = (date.charAt(0) - '0') * 10 + date.charAt(1) - '0';
        int n = (date.charAt(3) - '0') * 10 + date.charAt(4) - '0';
        if (m == 1) {
            return n;
        }
        int i = 1;
        int t = 0;
        while (i < m) {
            t += getdays(i++);
        }
        return t + n;
    }

    /**
     * 获得某个月有多少天数;
     * @param k
     * @return
     */
    public int getdays(int k) {
        if (k == 2) {
            return 28;
        } else if (k == 1 || k == 3 || k == 5 || k == 7 || k == 8 || k == 10 || k == 12) {
            return 31;
        }
        return 30;
    }


    class Solution {
        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            int[] datesOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int[] prefixSum = new int[13];
            for (int i = 0; i < 12; i++) {
                prefixSum[i + 1] = prefixSum[i] + datesOfMonths[i];
            }

            int arriveAliceDay = calculateDayOfYear(arriveAlice, prefixSum);
            int leaveAliceDay = calculateDayOfYear(leaveAlice, prefixSum);
            int arriveBobDay = calculateDayOfYear(arriveBob, prefixSum);
            int leaveBobDay = calculateDayOfYear(leaveBob, prefixSum);
            return Math.max(0, Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1);
        }

        public int calculateDayOfYear(String day, int[] prefixSum) {
            int month = Integer.parseInt(day.substring(0, 2));
            int date = Integer.parseInt(day.substring(3));
            return prefixSum[month - 1] + date;
        }
    }

}
