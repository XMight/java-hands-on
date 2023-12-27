package com.abusmac.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    Node<T> parent;
    List<Node<T>> children;
    T data;

    public Node(T data) {
        children = new ArrayList<>();
        this.data = data;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean addChild(Node<T> child) {
        child.setParent(this);

        return children.add(child);
    }

    public void removeParent() {
        parent = null;
    }
}
