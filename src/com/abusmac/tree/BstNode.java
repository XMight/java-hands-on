package com.abusmac.tree;

public class BstNode<T> {
    BstNode<T> parent;
    BstNode<T> left;
    BstNode<T> right;
    T data;

    public BstNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

