package com.linxun.leetcode.代码随想录.二叉树;

import java.util.*;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.二叉树
 * @date 2023/4/1 20:59
 */
public class postorder {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        LinkedList<Node> l = new LinkedList<>();
        l.add(root);

        while(!l.isEmpty()){
            Node t = l.pollLast();
            for(Node n : t.children) {
                l.addLast(n);
            }
            res.addFirst(t.val);
        }
        return res;
    }




    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        // 创建一个队列 来执行迭代
        Deque<Node> st = new ArrayDeque<>();
        // 创建一个 HashSet 来统计 每个节点的子节点是否完全被遍历过一次
        Set<Node> cnt = new HashSet();
        st.push(root);
        // 不停的循环，直到 栈中的元素为空
        while (!st.isEmpty()) {
            // 取栈中的顶层元素进行判断
            Node temp = st.peek();
            // 如果 其没有 children 序列
            // 或者 其子序列已经被遍历过一次
            // 就进行统计
            // 并将其移除
            if (temp.children.size() == 0 || cnt.contains(temp)) {
                res.add(temp.val);
                st.pop();
                continue;
            }

            // 如果其子节点序列不为空
            // 或者仍未访问过，则将其子节点序列压入栈中
            // 等待下一次迭代

            // 由于我们统计是从左到右顺序统计，因此我们在压入栈中的时候要倒序压入，以便后续迭代
            for (int i = temp.children.size() - 1; i >= 0; i--) {
                st.push(temp.children.get(i));
            }
            // 此节点其子节点已经被遍历过了，因此放入 HashSet 中进行标记
            cnt.add(temp);
        }
        return res;
    }


        public List<Integer> postorder3(Node root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }
            Map<Node, Integer> map = new HashMap<Node, Integer>();
            Deque<Node> stack = new ArrayDeque<Node>();
            Node node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    stack.push(node);
                    List<Node> children = node.children;
                    if (children != null && children.size() > 0) {
                        map.put(node, 0);
                        node = children.get(0);
                    } else {
                        node = null;
                    }
                }
                node = stack.peek();
                int index = map.getOrDefault(node, -1) + 1;
                List<Node> children = node.children;
                if (children != null && children.size() > index) {
                    map.put(node, index);
                    node = children.get(index);
                } else {
                    res.add(node.val);
                    stack.pop();
                    map.remove(node);
                    node = null;
                }
            }
            return res;
        }

    public List<Integer> postorder4(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new ArrayDeque<Node>();
        Set<Node> visited = new HashSet<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            /* 如果当前节点为叶子节点或者当前节点的子节点已经遍历过 */
            if (node.children.size() == 0 || visited.contains(node)) {
                stack.pop();
                res.add(node.val);
                continue;
            }
            for (int i = node.children.size() - 1; i >= 0; --i) {
                stack.push(node.children.get(i));
            }
            visited.add(node);
        }
        return res;
    }
}
