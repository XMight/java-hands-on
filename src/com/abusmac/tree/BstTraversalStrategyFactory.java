package com.abusmac.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BstTraversalStrategyFactory {
    public static BstTraversalStrategy get(BstTraversalStrategyEnum strategy) {
        if (strategy == BstTraversalStrategyEnum.DFS_PRE_ORDER) {
            return new BstPreOrderTraversalStrategy();
        } else if (strategy == BstTraversalStrategyEnum.DFS_IN_ORDER) {
            return new BstInOrderTraversalStrategy();
        } else if(strategy == BstTraversalStrategyEnum.DFS_POST_ORDER) {
            return new BstPostOrderTraversalStrategy();
        } else if(strategy == BstTraversalStrategyEnum.BFS_LEVEL_ORDER) {
            return new BstBfsTraversalStrategy();
        }

        throw new IllegalArgumentException();
    }

    private static class BstPreOrderTraversalStrategy implements BstTraversalStrategy {
        @Override
        public <T> void traverse(BstTree<T> tree) {
            traversePreOrder(tree.getRoot());
        }

        private <T> void traversePreOrder(BstNode<T> node) {
            if (node != null) {
                System.out.print(node.data + " ");
                traversePreOrder(node.left);
                traversePreOrder(node.right);
            }
        }
    }

    private static class BstInOrderTraversalStrategy implements BstTraversalStrategy {
        @Override
        public <T> void traverse(BstTree<T> tree) {
            traverseInOrder(tree.getRoot());
        }

        private <T> void traverseInOrder(BstNode<T> node) {
            if (node != null) {
                traverseInOrder(node.left);
                System.out.print(node.data + " ");
                traverseInOrder(node.right);
            }
        }
    }

    private static class BstPostOrderTraversalStrategy implements BstTraversalStrategy {
        @Override
        public <T> void traverse(BstTree<T> tree) {
            traversePostOrder(tree.getRoot());
        }

        private <T> void traversePostOrder(BstNode<T> node) {
            if (node != null) {
                traversePostOrder(node.left);
                traversePostOrder(node.right);
                System.out.print(node.data + " ");
            }
        }
    }

    private static class BstBfsTraversalStrategy implements BstTraversalStrategy {
        @Override
        public <T> void traverse(BstTree<T> tree) {
            Queue<BstNode<T>> queue = new LinkedList<>();
            queue.add(tree.getRoot());

            while(queue.size() > 0) {
                BstNode<T> element = queue.remove();
                System.out.print(element.data + " ");

                if(element.left != null) {
                    queue.add(element.left);
                }

                if(element.right != null) {
                    queue.add(element.right);
                }
            }
        }
    }
}
