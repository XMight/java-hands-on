package com.abusmac.tree;

public class BstTreeMain {
    public static void main(String[] args) {
        BstTree<Integer> tree = new BstTree<>(Integer::compareTo);

        // Data and order of insertion taken from Baeldung article for easier testing that I implemented correctly the BST tree traversal
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        BstTraversalStrategy ts = BstTraversalStrategyFactory.get(BstTraversalStrategyEnum.DFS_PRE_ORDER);
        ts.traverse(tree);
        System.out.println();

        ts = BstTraversalStrategyFactory.get(BstTraversalStrategyEnum.DFS_IN_ORDER);
        ts.traverse(tree);
        System.out.println();

        ts = BstTraversalStrategyFactory.get(BstTraversalStrategyEnum.DFS_POST_ORDER);
        ts.traverse(tree);
        System.out.println();

        ts = BstTraversalStrategyFactory.get(BstTraversalStrategyEnum.BFS_LEVEL_ORDER);
        ts.traverse(tree);
    }
}
