package com.kellsLogan.treeStates;

public class AVLTreeNode extends AVLTree {
    protected int value; // this will value will be used for sorting
    protected String name; // This can store a useful identifying String w/ the value.
    protected int height; // height of the node, used for calculated balance factor
    protected AVLTreeNode left; // left sub-node (leaf)
    protected AVLTreeNode right; // right sub-node (leaf)

    // Constructors
    public AVLTreeNode(int value, String name){
        this.value = value;
        this.name = name;
        // Set any sub-leaf nodes to null initially. This is used in recursive algorithms that test if the left/right
        // tree leaf nodes are null as a base case.
        this.left = null;
        this.right = null;
    }
    public AVLTreeNode(){
        // Set any sub-leaf nodes to null initially. This is used in recursive algorithms that test if the left/right
        // tree leaf nodes are null as a base case.
        this.left = null;
        this.right = null;
    }

    // Accessors
    public int getValue(){
        return this.value;
    }
    public int getHeight(){
        return this.height;
    }
    public String getName(){
        return this.name;
    }

    // Mutators


}
