package com.kellsLogan.StateCapitals;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Random;

// testState.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 10/4/2020

public class testStates {
    /**
     * main() method:
     * (2) Quiz the user to enter the capital of states
     * Create a quiz that asks users to enter the correct capital for a random state and give the user "professional"
     * feedback if the user is correct or not.
     * NOTE: Quiz creation is worth 50 points.
     * @param args
     */
    public static void main(String[] args){
        // Load the data from state.txt file to an ArrayList
        ArrayList<String> stateData = loadData("./resources/states.txt");

        // Initialize an ArrayList for just state abbreviations. We'll use this list to identify a random state to prompt the user.
        ArrayList<String> stateAbbrs = new ArrayList<>();

        // Create an empty TreeMap, with string keys that are State Abbreviations
        TreeMap<String, State> stateTreeMap = new TreeMap<>();

        // Use a forEach loop to create State objects and load them to a TreeMap with the following k,v pair:
        // Keys: state abbreviations such as "AL"
        // Values: State object
        for(int i=0; i<stateData.size(); i+=3){
            // Walk a cursor down the ArrayList to get each state's data.
            String currName = stateData.get(i);
            String currAbbr = stateData.get(i+1);
            String currCapital = stateData.get(i+2);

            // Create a State object and load to the TreeMap
            State currState = new State(currAbbr, currName, currCapital);
            stateTreeMap.put(currState.getAbbr(), currState);

            // Also load the abbreviations to the ArrayList.
            // We'll use this list to identify a random state to prompt the user.
            stateAbbrs.add(currAbbr);
        }
        // Identify a random state to use between the ArrayList of state abbreviations
        Random rm = new Random();
        int min = 0;
        int max = stateAbbrs.size();
        int randomIndex = rm.nextInt(max - min + 1) + min;
        String randomStateAbbr = stateAbbrs.get(randomIndex);

        // Get the corresponding state name from the randomly selected abbreviation
        String randomStateName = stateTreeMap.get(randomStateAbbr).getName();

        // Print a random state and ask for the user to enter the capital for that state.
        System.out.println("We've randomly selected the state: " + randomStateAbbr + " = " + randomStateName);
        System.out.println("What is the capital of " + randomStateName + "? Enter your response: ");

        // Create a Scanner object to load the user's input.
        Scanner userInput = new Scanner(System.in);
        String userCapital = userInput.nextLine();

        // Test if the user entered the appropriate capital
        String correctCapital = stateTreeMap.get(randomStateAbbr).getCapital();
        if(correctCapital.toLowerCase().compareTo(userCapital.toLowerCase()) == 0){
            System.out.println("That is correct! The capital of " + randomStateName + " is " + correctCapital + ". Great job!");
        }
        else{
            System.out.println("Sorry that is incorrect. The capital of " + randomStateName + " is " + correctCapital + ". You entered " + userCapital + ".");
        }
    }

    /**
     * loadData(String f) method:
     * Method to load the states.txt file into a ArrayList from states.txt
     * Create a program that will read in each abbreviation, state name and, capital from the file attached
     * and store the data into a TreeMap. The key value for the map should be the state abbreviation.
     * The file will have to be adjusted so that it can be read properly.
     * The file is set up to have the state name, state abbreviation, then abbreviation on separate lines.
     * NOTE: Reading data into the map is worth 30 points.
     * @param filename please enter a local filepath and filename to a .txt file.
     */
    public static ArrayList<String> loadData(String filename){
        // Initialize ArrayList<String>
        ArrayList<String> dataList = new ArrayList<>();
        // Use a try-catch block for loading the text file
        try{
            // Create a File object for the states.txt data
            File dataFile = new File(filename);

            // Use the Scanner object to load all the data from the dataFile
            Scanner dataScanner = new Scanner(dataFile);

            // Read all the lines
            while(dataScanner.hasNextLine()){
                // Add data to the ArrayList
                dataList.add(dataScanner.nextLine());
            }
        }
        // Catch any unhandled exceptions
        catch (FileNotFoundException e){
            System.out.println("File not found." + "Error: " + e);
        }
        return dataList;
    }
}
