package com.kellsLogan.treeStates;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

// TestTree.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 11/2/2020

public class TestTree {
    public static void main(String[] args){
        // This test will utilize the state_usa.txt input file of the 50 USA state names.
        // These states will be inserted into a binary search tree where each state is a node in the tree.

        // First we need to load the state_usa.txt data.
        ArrayList<String> stateNames = loadText();

        // Create a BinaryTree object
        System.out.println("Creating Binary Search Tree...");
        BinaryTree stateTree = new BinaryTree();

        // Load each state
        for (int i=1; i<stateNames.size()+1; i++){
            String currState = stateNames.get(i-1);
            // Slice the string into the state value and the state name (e.g. "01,Alabama" -> value=1, name="Alabama")
            int loc = currState.indexOf(",");
            int currValue = Integer.parseInt(currState.substring(0,loc));
            String currName = currState.substring(loc+1,currState.length());
            // Load a new node for each state.
            stateTree.add(currValue, currName);
        }
        System.out.println("Tree created.");

        // Test the inorder cursor walk of the tree.
        System.out.println(".\n.\n.\nPrintout of In-Order cursor walk of tree:");
        stateTree.inOrderWalk(stateTree.getRootNode());

        // Test the postorder cursor walk of the tree.
        System.out.println(".\n.\n.\nPrintout of Post-Order cursor walk of tree:");
        stateTree.postOrderWalk(stateTree.getRootNode());

        // Test the Pre-Order cursor walk of the tree.
        System.out.println(".\n.\n.\nPrintout of Pre-Order cursor walk of tree:");
        stateTree.preOrderWalk(stateTree.getRootNode());

        // End
        System.out.println("\n.\n.\n.\nEnding program.");
    }

    public static ArrayList<String> loadText(){
        // This method will load all lines in a txt file found in the local

        // Initialize an ArrayList which will store each line of data from the .txt input file.
        ArrayList<String> data = new ArrayList<>();

        // Prompt the user to enter the local filepath.
        System.out.println("Please enter the filename:");
        Scanner userInput = new Scanner(System.in);
        String filename = userInput.nextLine();

        // Update the path to the file to the local resources folder.
        String localPath = "./resources/" + filename;

        System.out.println("Loading data from " + localPath + " ...");

        // Use a try-catch block to attempt to create a File object from the filename.
        try{
            // Create the File object to the .txt file
            File myFile = new File(localPath);

            // Create a Scanner object to read each line in the .txt file
            Scanner lineScanner = new Scanner(myFile);

            // Load all lines in the .txt file to the ArrayList.
            while(lineScanner.hasNextLine()){
                data.add(lineScanner.nextLine());
            }
        }
        // Catch a FileNotFoundException and print an error to the console.
        catch(FileNotFoundException e){
            System.out.println("The file " + localPath + "was not found in the local ./resources folder");
        }

        System.out.println("Done loading data.");

        // Return the ArrayList of data
        return data;
    }
}
