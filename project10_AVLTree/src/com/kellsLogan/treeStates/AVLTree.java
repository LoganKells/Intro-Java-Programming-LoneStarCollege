package com.kellsLogan.treeStates;
import java.util.ArrayList;

// AVLTree.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 11/9/2020

// NOTE - methods such as balancing the path and the rotations (LL, LR, RR, RL) are based
// on Listing 26.3 in "Introduction to Java Programming and Data Structures,
// Comprehensive Version, 11th Edition, Y. Daniel Liang"

/**
 * AVLTree extends BinaryTree which was created separately for project9_BinaryTree.
 */
public class AVLTree extends BinaryTree {
    // Create an AVLTreeNode as the root of the AVLTree.
    //protected AVLTreeNode rootNode;

    // **********************************************************
    //              Constructors
    // **********************************************************
    public AVLTree(AVLTreeNode rootNode){
        this.rootNode = rootNode;
    }
    public AVLTree(){
    }

    // **********************************************************
    //              Accessors
    // **********************************************************

    /** Balance factor = height(rightnode) - height(leftnode)*/
    public int getBalanceFactor(AVLTreeNode currNode){
        if(currNode == null){
            return 0;
        }

        else if(currNode.left == null && currNode.right == null){
            // This case will occur if the balance factor is calculated for the root node
            // prior to any leaves being added left/right.
            return 0;
        }
        else if(currNode.left != null && currNode.right != null){
            return currNode.right.getHeight() - currNode.left.getHeight();
        }
        else if(currNode.left == null){
            return currNode.getHeight() + 1;
        }
        else{
            // if the right node is null then height is -1
            return currNode.getHeight() - 1;
        }
    }


    // **********************************************************
    //              Mutators
    // **********************************************************

    /** Override the BinaryTree insertNode(o) method to add method that balances the tree.*/
    @Override
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
                balanceTree(currentNode.left);
            }
            else if (newValue > currentNode.value){
                currentNode.right = insertNode(currentNode.right, newValue, newName);
                balanceTree(currentNode.right);
            }
            // Otherwise the new value to be inserted is equivalent to the current value.
            else{
                return currentNode;
            }
        }
        // Returning the currentNode returns the proper parent node for the new Node to be inserted below, to the left or right.
        return currentNode;
    }


    /** This method will perform the LL, LR, RR, RL rotation methods to balance the AVLTree,
     * beginning at a starting node.*/
    public void balanceTree(AVLTreeNode currNode){
        // Get the path to the node. This path will be a list [rootNode .... currNode].
        ArrayList<AVLTreeNode> nodePath = getPath(currNode);

        // Loop through the path and update the height of each node.
        for(int i=nodePath.size()-1; i>=0; i--){
            AVLTreeNode endNode = nodePath.get(i);
            AVLTreeNode parentOfEndNode;
            // Update the height of the node as it's accessed.
            calcHeight(endNode);
            // Determine the parent of the endpoint node.
            // Of course the parent is null if the endpoint node IS the root node.
            if(endNode == this.rootNode){
                parentOfEndNode = null;
            }
            // Ensure there are enough sub-tree leaves to perform a rotation.
            else if(endNode.left != null && endNode.right != null && endNode.right.left != null && endNode.left.right != null){
                parentOfEndNode = nodePath.get(i-1);
                if(parentOfEndNode != null){
                    // Perform rotations based on the balance factor at the end node.
                    if(getBalanceFactor(endNode) == -2 && getBalanceFactor(endNode.left) <= 0){
                        rotationLL(endNode, parentOfEndNode);
                    }
                    else if(getBalanceFactor(endNode) == -2 && getBalanceFactor(endNode.left) > 0){
                        rotationLR(endNode, parentOfEndNode);
                    }
                    else if(getBalanceFactor(endNode) == +1 && getBalanceFactor(endNode.right) >= 0){
                        rotationRR(endNode, parentOfEndNode);
                    }
                    else{
                        rotationRL(endNode, parentOfEndNode);
                    }
                }
            }
        }
    }

    /**An LL imbalance occurs at a node A, such that A has a balance factor of −2 and a left child B with a balance factor of −1 or 0, as shown in Figure 26.3a. This type of
     imbalance can be fixed by performing a single right rotation at A, as shown in Figure 26.3b. Listing 26.2 */
    public void rotationLL(AVLTreeNode currNode, AVLTreeNode currNodeParent){
        // Using notation of Figure 26.3 (A=currNode and B=currNode.left node).
        AVLTreeNode nodeB = currNode.left;
        // Updated the root node to nodeB.
        if(currNode == this.rootNode){
            this.rootNode = nodeB;
        }
        // Otherwise if A is a left child of parent, Let B be a left child of parentOfA;
        else{
            if(currNodeParent.left == currNode){
                currNodeParent.left = nodeB;
            }
            else{
                currNodeParent.right = nodeB;
            }
        }
        // Swap sub-trees
        currNode.left = nodeB.right;
        nodeB.right = currNode;
        // Recalculate heights now that rotations are completed.
        calcHeight(currNode);
        calcHeight(nodeB);
    }

    /** An RR imbalance occurs at a node A, such that A has a balance factor of +2 and a right child B with a balance factor of +1 or 0, as shown in Figure 26.4a. This type of
     imbalance can be fixed by performing a single left rotation at A, as shown in Figure 26.4b.*/
    public void rotationRR(AVLTreeNode currNode, AVLTreeNode currNodeParent){
        // Using notation of Figure 26.4 (A=currNode and B=currNode.right node).
        AVLTreeNode nodeB = currNode.right;
        // Updated the root node to nodeB.
        if(currNode == this.rootNode){
            this.rootNode = nodeB;
        }
        // Otherwise if A is a left child of parent, Let B be a left child of parentOfA;
        else{
            if(currNodeParent.left == currNode){
                currNodeParent.left = nodeB;
            }
            else{
                currNodeParent.right = nodeB;
            }
        }
        // Swap sub-trees
        currNode.right = nodeB.left;
        nodeB.left = currNode;
        // Recalculate heights now that rotations are completed.
        calcHeight(currNode);
        calcHeight(nodeB);
    }

    /** An LR imbalance occurs at a node A, such that A has a balance factor of −2 and a left child B with a balance factor of +1, as shown in Figure 26.5a. Assume B’s right child is C. This type of imbalance can be fixed by performing a double rotation (first a single left rotation at B, then a single right rotation at A), as shown in Figure 26.5b.*/
    public void rotationLR(AVLTreeNode currNode, AVLTreeNode currNodeParent){
        // Using notation of Figure 26.6 (A=currNode and B=currNode.right and C=currNode.right.left).
        AVLTreeNode nodeB = currNode.left;
        AVLTreeNode nodeC = currNode.left.right;
        // Update the root not to nodeC
        if(currNode == this.rootNode){
            this.rootNode = nodeC;
        }
        else{
            if(currNodeParent.left == currNode){
                currNodeParent.left = nodeC;
            }
            else{
                currNodeParent.right = nodeC;
            }
        }
        // Swap sub-trees
        currNode.left = nodeC.right;
        nodeB.right = nodeC.left;
        nodeC.left = nodeB;
        nodeC.right = currNode;
        // Recalculate heights now that rotations are completed.
        calcHeight(currNode);
        calcHeight(nodeB);
        calcHeight(nodeC);
    }

    /** An RL imbalance occurs at a node A, such that A has a balance factor of +2 and a right child B with a balance factor of −1, as shown in Figure 26.6a. Assume B’s left child is C. This type of imbalance can be fixed by performing a double rotation (first a single right rotation at B, then a single left rotation at A), as shown in Figure 26.6b.*/
    public void rotationRL(AVLTreeNode currNode, AVLTreeNode currNodeParent){
        // Using notation of Figure 26.6 (A=currNode and B=currNode.right and C=currNode.right.left).
        AVLTreeNode nodeB = currNode.right;
        AVLTreeNode nodeC = currNode.right.left;
        // Update the root not to nodeC
        if(currNode == this.rootNode){
            this.rootNode = nodeC;
        }
        else{
            if(currNodeParent.left == currNode){
                currNodeParent.left = nodeC;
            }
            else{
                currNodeParent.right = nodeC;
            }
        }
        // Swap sub-trees
        currNode.right = nodeC.left;
        nodeB.left = nodeC.right;
        nodeC.left = currNode;
        nodeC.right = nodeB;
        // Recalculate heights now that rotations are completed.
        calcHeight(currNode);
        calcHeight(nodeB);
        calcHeight(nodeC);
    }

    /** This method will return an ArrayList of the path from the root node
     * to the node input.*/
    public ArrayList<AVLTreeNode> getPath(AVLTreeNode endNode){
        // Initialize the list (path) to be returned.
        ArrayList<AVLTreeNode> treePath = new ArrayList<>();

        // Begin the cursor walk at the root node.
        AVLTreeNode currNode = rootNode;

        // Cursor walk the tree; add each current node to the path ArrayList
        while(currNode != null){
            treePath.add(currNode);
            // Move the cursor to the left leaf node if endNode's value is less than the currNode's value.
            // This means the end-point is on the left side of the tree.
            if(endNode.getValue() < currNode.getValue()){
                currNode = currNode.left;
            }
            // Otherwise the end-point is on the left side of the tree.
            else if(endNode.getValue() > currNode.getValue()){
                currNode = currNode.right;
            }
            else{
                break;
            }
        }
        return treePath;
    }

    /** This method will calculate the height of a given node.
     * Note: Each node must have the proper height initiated for the height to be calculated correctly.*/
    public void calcHeight(AVLTreeNode currNode){
        // Each node can have several options for sub leaf nodes.
        // Option 1: No sub leaf nodes -> height is 0
        // Option 2: Left leaf exists with no right leaf -> height is 1 + height(leftleaf)
        // Option 3: Right leaf exists with no left leaf -> height is 1 + height(rightleaf)
        // Option 4: Left and right leaves exist -> height is 1 + max(height(leftleaf), height(rightleaf))

        // Option 1
        if(currNode.left == null && currNode.right == null){
            currNode.height = 0;
        }
        // Option 2
        else if(currNode.left != null && currNode.right == null){
            currNode.height = 1 + currNode.left.height;
        }
        // Option 3
        else if(currNode.left == null){
            currNode.height = 1 + currNode.right.height;
        }
        // Option 4
        else{
            currNode.height = Math.max(currNode.left.height, currNode.right.height);
        }
    }
}
