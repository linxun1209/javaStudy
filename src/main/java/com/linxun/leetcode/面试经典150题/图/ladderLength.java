package com.linxun.leetcode.面试经典150题.图;

import java.util.*;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 127. 单词接龙
 * @date 2024/4/14 16:48
 */
public class ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //特殊情况判断
            return 0;
        }
        Queue<String> queue = new LinkedList<>(); //bfs 队列
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>(); //记录单词对应路径长度
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll(); //取出队头单词
            int path = map.get(word); //获取到该单词的路径长度
            for (int i = 0; i < word.length(); i++) { //遍历单词的每个字符
                char[] chars = word.toCharArray(); //将单词转换为char array，方便替换
                for (char k = 'a'; k <= 'z'; k++) { //从'a' 到 'z' 遍历替换
                    chars[i] = k; //替换第i个字符
                    String newWord = String.valueOf(chars); //得到新的字符串
                    if (newWord.equals(endWord)) {  //如果新的字符串值与endWord一致，返回当前长度+1
                        return path + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) { //如果新单词在set中，但是没有访问过
                        map.put(newWord, path + 1); //记录单词对应的路径长度
                        queue.offer(newWord);//加入队尾
                    }
                }
            }
        }
        return 0; //未找到
    }


    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}


    /**
     *  Map<String, Integer> wordId = new HashMap<String, Integer>();
     *     List<List<Integer>> edge = new ArrayList<List<Integer>>();
     *     int nodeNum = 0;
     *
     *     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     *         for (String word : wordList) {
     *             addEdge(word);
     *         }
     *         addEdge(beginWord);
     *         if (!wordId.containsKey(endWord)) {
     *             return 0;
     *         }
     *
     *         int[] disBegin = new int[nodeNum];
     *         Arrays.fill(disBegin, Integer.MAX_VALUE);
     *         int beginId = wordId.get(beginWord);
     *         disBegin[beginId] = 0;
     *         Queue<Integer> queBegin = new LinkedList<Integer>();
     *         queBegin.offer(beginId);
     *
     *         int[] disEnd = new int[nodeNum];
     *         Arrays.fill(disEnd, Integer.MAX_VALUE);
     *         int endId = wordId.get(endWord);
     *         disEnd[endId] = 0;
     *         Queue<Integer> queEnd = new LinkedList<Integer>();
     *         queEnd.offer(endId);
     *
     *         while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
     *             int queBeginSize = queBegin.size();
     *             for (int i = 0; i < queBeginSize; ++i) {
     *                 int nodeBegin = queBegin.poll();
     *                 if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
     *                     return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
     *                 }
     *                 for (int it : edge.get(nodeBegin)) {
     *                     if (disBegin[it] == Integer.MAX_VALUE) {
     *                         disBegin[it] = disBegin[nodeBegin] + 1;
     *                         queBegin.offer(it);
     *                     }
     *                 }
     *             }
     *
     *             int queEndSize = queEnd.size();
     *             for (int i = 0; i < queEndSize; ++i) {
     *                 int nodeEnd = queEnd.poll();
     *                 if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
     *                     return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
     *                 }
     *                 for (int it : edge.get(nodeEnd)) {
     *                     if (disEnd[it] == Integer.MAX_VALUE) {
     *                         disEnd[it] = disEnd[nodeEnd] + 1;
     *                         queEnd.offer(it);
     *                     }
     *                 }
     *             }
     *         }
     *         return 0;
     *     }
     *
     *     public void addEdge(String word) {
     *         addWord(word);
     *         int id1 = wordId.get(word);
     *         char[] array = word.toCharArray();
     *         int length = array.length;
     *         for (int i = 0; i < length; ++i) {
     *             char tmp = array[i];
     *             array[i] = '*';
     *             String newWord = new String(array);
     *             addWord(newWord);
     *             int id2 = wordId.get(newWord);
     *             edge.get(id1).add(id2);
     *             edge.get(id2).add(id1);
     *             array[i] = tmp;
     *         }
     *     }
     *
     *     public void addWord(String word) {
     *         if (!wordId.containsKey(word)) {
     *             wordId.put(word, nodeNum++);
     *             edge.add(new ArrayList<Integer>());
     *         }
     *     }
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/word-ladder/solutions/473600/dan-ci-jie-long-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */


