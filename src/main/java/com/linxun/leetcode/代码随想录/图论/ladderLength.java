package com.linxun.leetcode.代码随想录.图论;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.图论
 * @date 2023/6/7 22:20
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
            int path  = map.get(word); //获取到该单词的路径长度
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


    // 判断单词之间是否之差了一个字母
    public boolean isValid(String currentWord, String chooseWord) {
        int count = 0;
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) != chooseWord.charAt(i)) {
                ++count;
            }
        }
        return count == 1;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;      // 如果 endWord 不在 wordList 中，那么无法成功转换，返回 0
        }

        // ansLeft 记录从 beginWord 开始 BFS 时能组成的单词数目
        // ansRight 记录从 endWord 开始 BFS 时能组成的单词数目
        int ansLeft = 0, ansRight = 0;

        // queueLeft 表示从 beginWord 开始 BFS 时使用的队列
        // queueRight 表示从 endWord 开始 BFS 时使用的队列
        Queue<String> queueLeft = new ArrayDeque<>(), queueRight = new ArrayDeque<>();
        queueLeft.add(beginWord);
        queueRight.add(endWord);

        // 从 beginWord 开始 BFS 时把遍历到的节点存入 hashSetLeft 中
        // 从 endWord 开始 BFS 时把遍历到的节点存入 hashSetRight 中
        Set<String> hashSetLeft = new HashSet<>(), hashSetRight = new HashSet<>();
        hashSetLeft.add(beginWord);
        hashSetRight.add(endWord);

        // 只要有一个队列为空，说明 beginWord 无法转换到 endWord
        while (!queueLeft.isEmpty() && !queueRight.isEmpty()) {
            ++ansLeft;
            int size = queueLeft.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queueLeft.poll();
                // 只要 hashSetRight 中存在 currentWord，说明从 currentWord 可以转换到 endWord
                if (hashSetRight.contains(currentWord)) return ansRight + ansLeft;
                for (String chooseWord : wordList) {
                    if (hashSetLeft.contains(chooseWord) || !isValid(currentWord, chooseWord)) continue;
                    hashSetLeft.add(chooseWord);
                    queueLeft.add(chooseWord);
                }
            }
            ++ansRight;
            size = queueRight.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queueRight.poll();
                // 只要 hashSetLeft 中存在 currentWord，说明从 currentWord 可以转换到 beginWord
                if (hashSetLeft.contains(currentWord)) return ansLeft + ansRight;
                for (String chooseWord : wordList) {
                    if (hashSetRight.contains(chooseWord) || !isValid(currentWord, chooseWord)) continue;
                    hashSetRight.add(chooseWord);
                    queueRight.add(chooseWord);
                }
            }
        }
        return 0;
    }
}
