package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/24 15:12
 */
public class StreamChecker {


    /**
     * 方法一
     */
    String[] str = null;
    StringBuilder sb = null;

    public StreamChecker(String[] words) {
        this.str = words;
        this.sb = new StringBuilder();
    }

    public boolean query(char letter) {
        this.sb = this.sb.append(letter);
        String curString = sb.toString();
        for (String temp : str) {
            if (curString.endsWith(temp)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 方法二
     *
     */
    class Node {
        Node[] node = new Node[26];
        boolean isEnd;

        public Node() {
        }

        public Node(boolean _isEnd) {
            this.isEnd = _isEnd;
        }
    }

    Node root = new Node();

    /**
     * 倒着存字符串
     * @param word
     */
    public void insert(String word) {
        Node p = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (p.node[idx] == null) {
                p.node[idx] = new Node();
            }
            p = p.node[idx];
        }
        p.isEnd = true;
    }

    /**
     * 倒着查询，这样一次查询即可实现查询所有后缀
     * @return
     */
    public boolean search() {
        Node p = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int idx = sb.charAt(i) - 'a';
            if (p.isEnd) {
                return true;
            }
            if (p.node[idx] == null) {
                return false;
            }
            p = p.node[idx];
        }
        return p.isEnd;
    }

    public void StreamChecker2(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    StringBuilder sb2 = new StringBuilder();

    public boolean query2(char letter) {
        sb.append(letter);
        return search();
    }
}
