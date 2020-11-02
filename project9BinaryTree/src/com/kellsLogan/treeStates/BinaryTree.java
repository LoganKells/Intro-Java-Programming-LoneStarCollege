package com.kellsLogan.treeStates;


/**
 * A special type of binary tree called a binary search tree (BST) is often useful.
 * A BST (with no duplicate elements) has the property that for every node in the tree,
 * the value of any node in its left subtree is less than the value of the node,
 * and the value of any node in its right subtree is greater than the value of the node.
 */
public class BinaryTree {
    protected TreeNode rootNode;

    // Constructors
    public BinaryTree(){
        this.rootNode = null;
    }
    public BinaryTree(TreeNode rootNode){
        this.rootNode = rootNode;
    }

    // **********************************************************
    //              Accessors
    // **********************************************************
    public Boolean isRoot(){
        return this.isRoot();
    }
    public Object getRootValue(){
        return this.rootNode.value;
    }




    // **********************************************************
    //              Mutators
    // **********************************************************

    public void add(int value, String name){
        // This method will create a new rootNode if the rootNode is originally null when a value is first
        // added to the tree.
        // If a root node already exists, then the new TreeNode will be inserted based on the value provided
        // in comparison to parent nodes recursively.
        this.rootNode = insertNode(rootNode, value, name);
    }

    public TreeNode insertNode(TreeNode currentNode, int newValue, String newName){
        // Note - Review the insertion animation here: http://liveexample.pearsoncmg.com/liang/animation/web/BST.html
        // Note - Reviewed this example of a binary tree https://www.baeldung.com/java-binary-tree which I found useful
        //      compared to the book which simply used the Tree class.
        // This method will insert a TreeNode object in the correct location in the BinaryTree

        // Create a root to the tree if one does not exist already when a new node is being inserted.
        if(currentNode == null){
            // Create a new TreeNode object w/ the provided new value and new name.
            TreeNode newNode = new TreeNode(newValue, newName);
            return newNode;
        }
        else{
            // Find the proper location to insert.
            if(newValue < currentNode.value){
                currentNode.left = insertNode(currentNode.left, newValue, newName);
            }
            else if (newValue > currentNode.value){
                currentNode.right = insertNode(currentNode.right, newValue, newName);
            }
            // Otherwise the new value to be inserted is equivalent to the current value.
            else{
                return currentNode;
            }
        }
        return currentNode;
    }
}
