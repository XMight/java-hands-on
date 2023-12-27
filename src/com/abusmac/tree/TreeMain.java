package com.abusmac.tree;

import java.util.*;

public class TreeMain {
    static Queue<Integer> bfsTraversalQueue = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
    static Queue<Integer> dfsTraversalQueue = new LinkedList<>(Arrays.asList(0, 2, 6, 5, 1, 4, 3));

    public static void main(String[] args) {
        Node<Integer> rootNode = getTree();

        bfs(rootNode);
        dfs(rootNode);
    }

    private static void dfs(Node<Integer> tree) {
        Stack<Node<Integer>> traversalStack = new Stack<>();
        traversalStack.push(tree);

        while(!traversalStack.empty()) {
            Node<Integer> node = traversalStack.pop();

            List<Node<Integer>> children = node.getChildren();
            traversalStack.addAll(children);

            printNodeWithCheck(node, dfsTraversalQueue);
        }
    }

    private static void bfs(Node<Integer> treeNode) {
        Queue<Node<Integer>> traversalQueue = new LinkedList<>();
        traversalQueue.add(treeNode);

        while (traversalQueue.peek() != null) {
            Node<Integer> node = traversalQueue.remove();

            List<Node<Integer>> children = node.getChildren();
            traversalQueue.addAll(children);

            printNodeWithCheck(node, bfsTraversalQueue);
        }
    }

    static Node<Integer> getTree() {
        // 0
        // |       \
        // 1        2
        // | \      | \
        // 3  4     5  6
        Node<Integer> root = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);

        node1.addChild(node3);
        node1.addChild(node4);

        node2.addChild(node5);
        node2.addChild(node6);

        root.addChild(node1);
        root.addChild(node2);

        return root;
    }

    static void printNodeWithCheck(Node<Integer> node, Queue<Integer> queue) {
        System.out.println(node.data);
        Integer peek = queue.peek();

        boolean isOrderCorrect = false;

        if (peek != null) {
            isOrderCorrect = peek.intValue() == node.data.intValue();
        }

        if (isOrderCorrect) {
            queue.remove();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
