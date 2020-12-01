package com.kellsLogan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// LoadData.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 11/30/2020

public class LoadData {
    // Initialize an ArrayList which will store each line of data from the .txt input file.
    private ArrayList<String> data = new ArrayList<>();

    public void loadText(){
        // This method will load all lines in a txt file found in the local ./resources file.

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
                this.data.add(lineScanner.nextLine());
            }
        }
        // Catch a FileNotFoundException and print an error to the console.
        catch(FileNotFoundException e){
            System.out.println("The file " + localPath + "was not found in the local ./resources folder");
        }

        System.out.println("Done loading data.");
    }

    public ArrayList<String> getData() {
        return data;
    }
}
