package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/12/27 22:38
 */
public class Trie1 {
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

    public Trie1() {

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





    class Trie2 {
        private Trie2[] children;
        private boolean isEnd;

        public Trie2() {
            children = new Trie2[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie2 node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie2();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie2 node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie2 searchPrefix(String prefix) {
            Trie2 node = this;
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
    }




    class Trie {
        class Node{
            boolean end;

            Node[] childNodes;

            public Node(){
                end=false;
                childNodes=new Node[26];
            }
        }
        Node root=new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node cur=root;
            for (int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                if(cur.childNodes[index]==null){
                    cur.childNodes[index]=new Node();
                }
                cur=cur.childNodes[index];
            }
            cur.end=true;

        }

        public boolean search(String word) {
            Node node=root;
            for (int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                if(node.childNodes[index]==null) return false;
                node=node.childNodes[index];
            }
            return node.end;




        }

        public boolean startsWith(String prefix) {
            Node node=root;
            for (int i=0;i<prefix.length();i++){
                int index=prefix.charAt(i)-'a';
                if(node.childNodes[index]==null){
                    return false;
                }
                node=node.childNodes[index];
            }
            return true;

        }
    }
}
