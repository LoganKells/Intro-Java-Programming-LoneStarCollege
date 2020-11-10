package com.kellsLogan.treeStates;

// BinaryTree.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 11/2/2020

/**
 * A special type of binary tree called a binary search tree (BST) is often useful.
 * A BST (with no duplicate elements) has the property that for every node in the tree,
 * the value of any node in its left subtree is less than the value of the node,
 * and the value of any node in its right subtree is greater than the value of the node.
 */
public class BinaryTree {
    protected AVLTreeNode rootNode;

    // Constructors
    public BinaryTree(){
        this.rootNode = null;
    }
    public BinaryTree(AVLTreeNode rootNode){
        this.rootNode = rootNode;
    }

    // **********************************************************
    //              Accessors
    // **********************************************************
    public Object getRootValue(){
        return this.rootNode.value;
    }
    public AVLTreeNode getRootNode(){
        return this.rootNode;
    }
    public void inOrderWalk(AVLTreeNode currentRoot){
        // In Order Tree Traversal (Walk)
        // With inorder traversal, the left subtree of the current node is visited first recursively,
        // then the current node, and finally the right subtree of the current node recursively.
        // The inorder traversal displays all the nodes in a BST in increasing order.

        // NOTE - Recursive end condition: If the current node is null.
        if(currentRoot != null){
            // First, recursively visit all left leaves.
            inOrderWalk(currentRoot.left);
            // Second, once left leaves are visited recursively, print the current root's values.
            System.out.print(currentRoot.value + "-" + currentRoot.name + ", ");
            // Third, recursively visit all right leaves.
            inOrderWalk(currentRoot.right);
        }
    }
    public void postOrderWalk(AVLTreeNode currentRoot){
        // Post Order Tree Traversal (Walk)
        // With postorder traversal, the left subtree of the current node is visited recursively first,
        // then recursively the right subtree of the current node, and finally the current node itself.

        // NOTE - Recursive end condition: If the current node is null.
        if(currentRoot != null){
            // First, recursively visit all left leaves.
            postOrderWalk(currentRoot.left);
            // Second, recursively visit all right leaves.
            postOrderWalk(currentRoot.right);
            // Third, once left leaves AND right leaves are visited recursively, print the current root's values.
            System.out.print(currentRoot.value + "-" + currentRoot.name + ", ");
        }
    }
    public void preOrderWalk(AVLTreeNode currentRoot){
        // Pre Order Tree Traversal (Walk)
        // With preorder traversal, the current node is visited first,
        // then recursively the left subtree of the current node, and
        // finally the right subtree of the current node recursively.

        // NOTE - Recursive end condition: If the current node is null.
        if(currentRoot != null){
            // First print the root node.
            System.out.print(currentRoot.value + "-" + currentRoot.name + ", ");
            // Second, recursively visit all left leaves.
            preOrderWalk(currentRoot.left);
            // Third, recursively visit all right leaves.
            preOrderWalk(currentRoot.right);
        }
    }


    // **********************************************************
    //              Mutators
    // **********************************************************
    public void add(int value, String name){
        // This method will create a new rootNode if the rootNode is originally null when a value is first
        // added to the tree.
        // If a root node already exists, then the new TreeNode will be inserted based on the value provided
        // in comparison to parent nodes recursively.
        // The root node itself will become a leaf of a new node if the new node value is > or < the root.
        this.rootNode = insertNode(rootNode, value, name);
    }
    public AVLTreeNode insertNode(AVLTreeNode currentNode, int newValue, String newName){
        // Note - Review the insertion animation here: http://liveexample.pearsoncmg.com/liang/animation/web/BST.html
        // Note - Reviewed this example of a binary tree https://www.baeldung.com/java-binary-tree which I found useful
        //      compared to the book which simply used the Tree class.
        // This method will insert a TreeNode object in the correct location in the BinaryTree

        // Create a root to the tree if one does not exist already when a new node is being inserted.
        if(currentNode == null){
            // Create a new TreeNode object w/ the provided new value and new name.
            AVLTreeNode newNode = new AVLTreeNode(newValue, newName);
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
        // Returning the currentNode returns the proper parent node for the new Node to be inserted below, to the left or right.
        return currentNode;
    }
}
