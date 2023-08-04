package com.linxun.leetcode.hot100;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * @date 2023/3/24 16:02
 */
public class leastInterval {
    /**
     * 解题思路：
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，
     *      如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     *      则retCount++ ==> A->B->X->A->B->X->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) {
            return tasks.length;
        }
        //步骤1
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        //步骤2
        Arrays.sort(counts);
        int maxCount = counts[25];
        int retCount = (maxCount - 1) * (n + 1) + 1;
        int i = 24;
        //步骤3
        while (i >= 0 && counts[i] == maxCount) {
            retCount++;
            i--;
        }
        //步骤4
        return Math.max(retCount, tasks.length);
    }


    /**
     *    // 计字母出现次数
     * // 优先队列按照优先级升序，数量降序排序
     * // 优先队列取出，计算时间为优先级或者当前时间为新的时间
     * // 取新的时间作为答案
     * // 如果还有剩余，给定一个时间的优先级，加n，放回优先队列待命
     * // 直到所有字符拿完结束
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval2(char[] tasks, int n) {
            n++;
            int[] cnt=new int[26];
            for(char task:tasks){
                cnt[task-'A']++;
            }

            int[] prio=new int[26];
            PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->prio[a]==prio[b]?cnt[b]-cnt[a]:prio[a]-prio[b]);
            for(int i=0;i<26;i++){
                if(cnt[i]>0){
                    pq.offer(i);
                }
            }

            int ans=0;
            int time=0;
            while(pq.size()>0){
                int i=pq.poll();
                time=Math.max(time,prio[i]);
                ans=Math.max(ans,time);
                if(--cnt[i]>0){
                    prio[i]+=n;
                    pq.offer(i);
                }
                time++;
            }
            return ans+1;
        }


    /**
     * 贪心算法
     *
     */

    public int leastInterval3(char[] tasks, int n) {
        //统计每个任务出现的次数，找到出现次数最多的任务
        int[] hash = new int[26];
        for(int i = 0; i < tasks.length; ++i) {
            hash[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(hash);
        //因为相同元素必须有n个冷却时间，假设A出现3次，n = 2，任务要执行完，至少形成AXX AXX A序列（X看作预占位置）
        //该序列长度为
        int minLen = (n+1) *  (hash[25] - 1) + 1;

        //此时为了尽量利用X所预占的空间（贪心）使得整个执行序列长度尽量小，将剩余任务往X预占的空间插入
        //剩余的任务次数有两种情况：
        //1.与A出现次数相同，比如B任务最优插入结果是ABX ABX AB，中间还剩两个空位，当前序列长度+1
        //2.比A出现次数少，若还有X，则按序插入X位置，比如C出现两次，形成ABC ABC AB的序列
        //直到X预占位置还没插满，剩余元素逐个放入X位置就满足冷却时间至少为n
        for(int i = 24; i >= 0; --i){
            if(hash[i] == hash[25]) {
                ++ minLen;
            }
        }
        //当所有X预占的位置插满了怎么办？
        //在任意插满区间（这里是ABC）后面按序插入剩余元素，比如ABCD ABCD发现D之间距离至少为n+1，肯定满足冷却条件
        //因此，当X预占位置能插满时，最短序列长度就是task.length，不能插满则取最少预占序列长度
        return Math.max(minLen, tasks.length);
    }


    /**
     * 构造法
     *
     */

        public int leastInterval4(char[] tasks, int n) {
            Map<Character, Integer> freq = new HashMap<Character, Integer>();
            // 最多的执行次数
            int maxExec = 0;
            for (char ch : tasks) {
                int exec = freq.getOrDefault(ch, 0) + 1;
                freq.put(ch, exec);
                maxExec = Math.max(maxExec, exec);
            }

            // 具有最多执行次数的任务数量
            int maxCount = 0;
            Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                int value = entry.getValue();
                if (value == maxExec) {
                    ++maxCount;
                }
            }

            return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
        }


    /**
     * 模拟法
     *
     */



    public int leastInterval5(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // 任务总数
        int m = freq.size();
        List<Integer> nextValid = new ArrayList<Integer>();
        List<Integer> rest = new ArrayList<Integer>();
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int time = 0;
        for (int i = 0; i < tasks.length; ++i) {
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best = -1;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }

        return time;
    }
}

