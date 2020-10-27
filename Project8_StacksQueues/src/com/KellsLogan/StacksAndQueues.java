package com.KellsLogan;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StacksAndQueues {
    public static void main(String[] args){
        // Create a Scanner object for user input in console.
        Scanner userInput = new Scanner(System.in);

        // Prompt the user if the want to reverse, convert, or compare.
        System.out.println("Do you want to (1) reverse the file text order, (2) convert a file text to uppercase, or (3) compare the text in two files?");
        System.out.println("Please enter your selection as 1, 2, or 3:");
        int userSelection = userInput.nextInt();

        if(userSelection == 1){
            // Reverse using a Stack with pop method.

            // Create a new Stack
            Stack<Character> myStack = new Stack<>();

            // Read the first line from the file
            String line = readLine();

            // Push each string character to the Stack object
            for(int i=0; i<line.length(); i++){
                myStack.push(line.charAt(i));
            }

            // Pop the characters from the Stack object and add to a final string.
            // NOTE - We'll use StringBuilder object to access the append method.
            StringBuilder reverseLine = new StringBuilder();
            for(int i=0; i<line.length(); i++){
                char currChar = myStack.pop();
                reverseLine.append(currChar);
            }
            // Cast the StringBuilder object to String object.
            String reverseLineFinal = reverseLine.toString();

            // Save the results to the output file
            System.out.println("Saving reverse results...");
            saveData("ReverseOutput.txt", reverseLineFinal);
        }
        else if(userSelection == 2){
            // Convert using a Queue with a dequeue method.

            // Create a new Queue
            Queue<Character> myQueue = new Queue<>();

            // Read the first line from the file.
            String line = readLine();

            // Enqueue each string character to the Queue object.
            for(int i=0; i<line.length(); i++){
                myQueue.enqueue(line.charAt(i));
            }

            // Dequeue each character from the Queue object, convert it to uppercase, and add to the final string.
            // NOTE - We'll use StringBuilder object to access the append method.
            StringBuilder upperCaseLine = new StringBuilder();
            for(int i=0; i<line.length(); i++){
                Character currChar = myQueue.dequeue();
                char currUpper = java.lang.Character.toUpperCase(currChar);
                upperCaseLine.append(currUpper);
            }

            // Cast the StringBuilder object to String object.
            String upperLineFinal = upperCaseLine.toString();

            // Save the results to the output file.
            System.out.println("Saving uppercase results...");
            saveData("UpperCaseOutput.txt", upperLineFinal);
        }
        else if(userSelection == 3){
            // Create two new Queue objects
            Queue<Character> myQueue1 = new Queue<>();
            Queue<Character> myQueue2 = new Queue<>();

            // Load the lines from two files.
            String line1 = readLine();
            String line2 = readLine();

            // Enqueue each character in each line to the Queue object.
            for(int i=0; i<line1.length(); i++){
                myQueue1.enqueue(line1.charAt(i));
            }
            for(int i=0; i<line2.length(); i++){
                myQueue2.enqueue(line2.charAt(i));
            }

            // Compare the Character one by one between each queue. Of course if the Queue are different sizes then
            // they are certainly not equivalent.
            if(myQueue1.getSize() != myQueue2.getSize()){
                System.out.println("The files are not equivalent.");
            }
            else{
                for(int i=0; i<myQueue1.getSize(); i++){
                    char currChar1 = myQueue1.dequeue();
                    char currChar2 = myQueue2.dequeue();
                    // Use Character.compare(c1, c2) to compare the two characters.
                    // Break the loop and print not equivalent if the two chars are not equivalent.
                    // Otherwise complete the loop & print equivalent.
                    // See - https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#compare(char,char)
                    if(java.lang.Character.compare(currChar1, currChar2) != 0){
                        System.out.println("The .txt files are not equivalent.");
                        break;
                    }
                }
                System.out.println("The .txt files are equivalent.");
            }
        }
        else{
            System.out.println("Ending program. Please select 1, 2, or 3 next time.");
        }
    }

    public static String readLine(){
        // This method will load a SINGLE line from a file.
        String textLine = "";

        // Prompt the user to select a .txt file
        System.out.println("Please enter the filename of the local .txt file. Include .txt in the name:");

        // Load the first line from the file
        Scanner userFile = new Scanner(System.in);
        String filename = userFile.nextLine();

        // Use a try-catch block for loading the text file
        try{
            // Update the path to the file
            String filepath = "./resources/" + filename;

            // Create a File object for the states.txt data
            File dataFile = new File(filepath);

            // Use the Scanner object to load all the data from the dataFile
            Scanner dataScanner = new Scanner(dataFile);

            // Read the first line from the text file
            textLine = dataScanner.nextLine();
        }
        // Catch any unhandled exceptions
        catch (FileNotFoundException error){
            System.out.println("File not found." + "Error: " + error);
        }
        return textLine;
    }

    public static void saveData(String filename, String line){
        // This method will write a SINGLE line to a file.

        // Update the path to the file
        String filepath = "./resources/" + filename;

        // Create the output file in the specified filepath location.
        File myFile = new File(filepath);

        // Write the line to the file.
        try{
            // Create FileWriter object which has the write() method
            FileWriter myWriter = new FileWriter(myFile);
            // Write the line to the file & close it.
            myWriter.write(line);
            myWriter.close();
        }
        catch(IOException error){
            System.out.println("Error during write to file process: " + error);
        }

    }
}