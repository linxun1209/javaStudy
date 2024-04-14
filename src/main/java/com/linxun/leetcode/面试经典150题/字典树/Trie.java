package com.linxun.leetcode.面试经典150题.字典树;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 208. 实现 Trie (前缀树)
 * @date 2024/4/14 21:09
 */
public class Trie {
    // 前缀树节点
    class Node {
        boolean end;    // 标记该节点是否为单词结尾字母
        Node[] childNodes;  // 触手节点

        public Node() {
            end = false;
            childNodes = new Node[26];
        }
    }

    Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        Node cur = root;    // 节点指针
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a'; // 触手索引
            if (cur.childNodes[idx] == null) cur.childNodes[idx] = new Node();  // 没有节点则创建
            cur = cur.childNodes[idx];
        }
        // 记住要标记最后一个为结束节点
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.childNodes[idx] == null) return false;
            cur = cur.childNodes[idx];
        }
        return cur.end; // 看看走到最后是否为结束标志
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.childNodes[idx] == null) return false;
            cur = cur.childNodes[idx];
        }
        return true;    // 无论最后是否为结束标志，一律返回true
    }




    /*
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    */
}

