package com.abusmac.tree;

import java.util.ArrayList;
import java.util.List;

public class NaryNode<T> {
    NaryNode<T> parent;
    List<NaryNode<T>> children;
    T data;

    public NaryNode(T data) {
        children = new ArrayList<>();
        this.data = data;
    }

    public void setParent(NaryNode<T> parent) {
        this.parent = parent;
    }

    public List<NaryNode<T>> getChildren() {
        return children;
    }

    public NaryNode<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean addChild(NaryNode<T> child) {
        child.setParent(this);

        return children.add(child);
    }

    public void removeParent() {
        parent = null;
    }
}
