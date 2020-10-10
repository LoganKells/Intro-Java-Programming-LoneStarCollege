package com.kellsLogan.Generics;
import java.util.Scanner;

// Main.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 9/20/2020

// Instructions:
// For this assignment, choose a sorting algorithm and make it generic.
// Also, choose a search algorithm and make it generic as well.
// Create a demonstration main method with a menu option (switch statement),
//      1 - for sorting, 2 - for searching, and then demonstrate the sort and search functionality.
// You can demonstrate with self-generated arrays.

public class TestGenericArrayList {
    public static void main(String[] args){
        // Create arrays Integer type.
        //GenericArray<Integer> intArray = new GenericArray<>();
        GenericArrayList<Integer> intArray = new GenericArrayList<>();
        intArray.push(8);
        intArray.push(1);
        intArray.push(17);
        intArray.push(11);
        intArray.push(2);

        // Create array of Character type
        //GenericArray<Character> charArray = new GenericArray<>();
        GenericArrayList<Character> charArray = new GenericArrayList<>();
        charArray.push('C');
        charArray.push('x');
        charArray.push('h');
        charArray.push('s');
        charArray.push('a');
        charArray.push('b');
        charArray.push('t');
        charArray.push('B');
        charArray.push('A');

        // Prompt the user 1 - for sorting, 2 - for searching.
        // NOTE: I added a 3rd option which enables the sorting THEN searching for the values.
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter \"1\" to sort each array, \"2\" to search, or \"3\" to sort-then-search: ");
        int userSelection = userInput.nextInt();
        // Use a switch statement based on the userSelection
        switch(userSelection){
            case 1:
                System.out.println("...\nRunning selection-sort algorithm\n...");
                // Sort each array
                intArray.selectionSort();
                charArray.selectionSort();
                // Print the Final Sorted arrays
                System.out.println("Final Sorted Integer Array: " + intArray.toString());
                System.out.println("Final Sorted Character Array: " + charArray.toString());
                System.out.println("...\nprogram ended.");
                break;
            case 3:
                // Sort each array
                System.out.println("...\nRunning selection-sort algorithm");
                intArray.selectionSort();
                charArray.selectionSort();
            case 2:
                System.out.println("...\nInitializing search algorithm\n....");
                // Search the integer array for a value entered by the user
                System.out.print("Enter an Integer to search the Integer array: ");
                int searchInt = userInput.nextInt();
                int intLoc = intArray.linearSearch(searchInt);
                // Print the location
                if(intLoc >= 0){
                    System.out.println("The integer was located at index \"" + intLoc + "\" in the array " + intArray.toString());
                }
                else{
                    System.out.println("The integer is not in the array " + intArray.toString());
                }
                // Search the character array for a value entered by the user
                System.out.print("Enter an Character to search the Character array: ");
                char searchChar = userInput.next().charAt(0);
                int charLoc = charArray.linearSearch(searchChar);
                // Print the location
                if(charLoc >= 0){
                    System.out.println("The character was located at index \"" + charLoc + "\" in the array " + charArray.toString());
                }
                else{
                    System.out.println("The characters is not in the array " + charArray.toString());
                }
                System.out.println("...\nprogram ended.");
        }
    }
}
