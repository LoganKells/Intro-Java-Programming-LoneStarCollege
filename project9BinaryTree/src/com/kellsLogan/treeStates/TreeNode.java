package com.kellsLogan.treeStates;

// TreeNode.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 11/2/2020


public class TreeNode<E> {
    protected int value; // this will value will be used for sorting
    protected String name; // This can store a useful identifying String w/ the value.
    protected Boolean isRoot; // Flag if the node is the tree root.
    protected TreeNode<E> left; // left sub-node (leaf)
    protected TreeNode<E> right; // right sub-node (leaf)

    // accessors
    public int getValue(){
        return this.value;
    }

    // constructor
    TreeNode(int value, String name){
        this.value = value;
        this.name = name;
        //this.isRoot = isRoot;
        // Be sure that the left and right sub-nodes are set to null initially.
        this.left = null;
        this.right = null;
    }
}
