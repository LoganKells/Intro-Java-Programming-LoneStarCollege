# Readme
The included java classes will create a test AVL tree from a .txt file of values separated by a 
comma with the value's corresponding name (e.g. "1,Alabama" and "19,MyName"). 
Each item is stored on a separate line in the .txt file. 

The AVL tree will be printed to the console using the following traversal (cursor walk) methods:
* In-order
* Post-order
* Pre-order

Use the TestAVLTree class to test. This will search in the local "./resources" path for the file you enter in the console after prompted. 

## Included Files
The following files are included in this package.
* ./src/package/TestAVLTree.java
* ./src/package/AVLTreeNode.java
* ./src/package/BinaryTree.java
* ./src/package/Instructions.md
* ./src/package/readme.md
* ./resources/states_usa_ordered.txt
* ./resources/states_usa_unordered.txt

## .txt file format
* Please add any .txt files to a resource folder in a local "./resources" path.
* Please format with a number and a name on each line (e.g. "1,Alabama").
* Please include ".txt" in the filename when prompted in the console.

## Run a sample
1. Please utilize the "TestAVLTree" class to run samples of the "BinaryTree" class.
2. Enter the filename when prompted. Provided are two sample .txt files. 
One is ordered while the other is not ordered: "states_usa_ordered.txt", "states_usa_unordered.txt".
3. Review the results from the cursor walks of the binary search tree: inorder, preorder, postorder.

