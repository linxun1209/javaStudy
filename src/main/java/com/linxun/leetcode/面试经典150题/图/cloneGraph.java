package com.linxun.leetcode.面试经典150题.图;

import com.linxun.leetcode.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 133. 克隆图
 * @date 2024/4/12 9:17
 */
public class cloneGraph {
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList());
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }


    public Node cloneGraph2(Node node) {
        if (node == null) {
            return node;
        }

        HashMap<Node, Node> visited = new HashMap();

        // 将题目给定的节点添加到队列
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList()));

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出队列的头节点
            Node n = queue.remove();
            // 遍历该节点的邻居
            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }


    Node[] nodes = new Node[100];

    public Node cloneGraph3(Node node) {
        if (node == null) return null;
        if (nodes[node.val - 1] != null) {
            return nodes[node.val - 1];
        }
        List<Node> neighbors = node.neighbors;
        ArrayList<Node> newNeighbors = new ArrayList<>();
        Node ans = new Node(node.val, newNeighbors);
        nodes[ans.val - 1] = ans;
        for (Node n : neighbors) {
            Node cur = cloneGraph3(n);
            newNeighbors.add(cur);
        }
        return ans;
    }
}


