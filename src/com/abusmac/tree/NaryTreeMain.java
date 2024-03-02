package com.abusmac.tree;

import java.util.*;

public class NaryTreeMain {
    static Queue<Integer> bfsTraversalQueue = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
    static Queue<Integer> dfsTraversalQueue = new LinkedList<>(Arrays.asList(0, 2, 6, 5, 1, 4, 3));

    public static void main(String[] args) {
        NaryNode<Integer> rootNode = getTree();

        bfs(rootNode);
        System.out.println();
        dfs(rootNode);
    }



    private static void dfs(NaryNode<Integer> tree) {
        Stack<NaryNode<Integer>> traversalStack = new Stack<>();
        traversalStack.push(tree);

        while(!traversalStack.empty()) {
            NaryNode<Integer> node = traversalStack.pop();

            List<NaryNode<Integer>> children = node.getChildren();
            traversalStack.addAll(children);

            printNodeWithCheck(node, dfsTraversalQueue);
        }
    }

    private static void bfs(NaryNode<Integer> treeNode) {
        Queue<NaryNode<Integer>> traversalQueue = new LinkedList<>();
        traversalQueue.add(treeNode);

        while (traversalQueue.peek() != null) {
            NaryNode<Integer> node = traversalQueue.remove();

            List<NaryNode<Integer>> children = node.getChildren();
            traversalQueue.addAll(children);

            printNodeWithCheck(node, bfsTraversalQueue);
        }
    }

    static NaryNode<Integer> getTree() {
        // 0
        // |       \
        // 1        2
        // | \      | \
        // 3  4     5  6
        NaryNode<Integer> root = new NaryNode<>(0);
        NaryNode<Integer> node1 = new NaryNode<>(1);
        NaryNode<Integer> node2 = new NaryNode<>(2);
        NaryNode<Integer> node3 = new NaryNode<>(3);
        NaryNode<Integer> node4 = new NaryNode<>(4);
        NaryNode<Integer> node5 = new NaryNode<>(5);
        NaryNode<Integer> node6 = new NaryNode<>(6);

        node1.addChild(node3);
        node1.addChild(node4);

        node2.addChild(node5);
        node2.addChild(node6);

        root.addChild(node1);
        root.addChild(node2);

        return root;
    }

    static void printNodeWithCheck(NaryNode<Integer> node, Queue<Integer> queue) {
        System.out.print(node.data + " ");
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
