package com.linxun.leetcode.面试经典150题.字典树;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/4/14 21:26
 */
public class WordDictionary {
    private Trie1 root;

    public WordDictionary() {
        root = new Trie1();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie1 node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            Trie1 child = node.getChildren()[childIndex];
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                Trie1 child = node.getChildren()[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Trie1 {
    private Trie1[] children;
    private boolean isEnd;

    public Trie1() {
        children = new Trie1[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie1 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie1();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public Trie1[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }

}

