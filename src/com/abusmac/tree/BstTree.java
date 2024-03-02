package com.abusmac.tree;

import java.util.Comparator;

public class BstTree<T> {
    private BstNode<T> root;
    private final Comparator<T> comparator;

    public BstTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public BstNode<T> add(T data) {
        root = addRecursive(root, data);

        return root;
    }

    private BstNode<T> addRecursive(BstNode<T> currentNode, T data) {
        if(currentNode == null) {
            return new BstNode<>(data);
        }

        int compareResult = comparator.compare(currentNode.data, data);

        if(compareResult > 0) {
            currentNode.left = addRecursive(currentNode.left, data);
        } else if(compareResult < 0) {
            currentNode.right = addRecursive(currentNode.right, data);
        } else {
            return currentNode;
        }

        return currentNode;
    }

    public BstNode<T> getRoot() {
        return root;
    }
}
