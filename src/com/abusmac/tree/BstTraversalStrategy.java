package com.abusmac.tree;

public interface BstTraversalStrategy {
    <T> void traverse(BstTree<T> tree);
}
