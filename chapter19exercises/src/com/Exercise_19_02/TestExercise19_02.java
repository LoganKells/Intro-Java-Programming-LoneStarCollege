package com.Exercise_19_02;
import java.util.Scanner;

// Created by: Logan Kells
// Date: 10/4/2020

// Intro to Java 11th Edition Liang, Exercise 19.2
// (Implement GenericStack using inheritance)
// In Listing 19.1, GenericStack is implemented using composition.
// Define a new stack class that extends ArrayList.
// Draw the UML diagram for the classes then implement GenericStack.
// Write a test program that prompts the user to enter five strings and displays them in reverse order.

public class TestExercise19_02 {
    public static void main(String[] args){
        // Create a stack using the class (generic stack that extends ArrayList)
        GenericStackInheritance<String> testStack = new GenericStackInheritance<>();

        // Test isEmpty
        System.out.print("The newly created stack is empty: ");
        System.out.println(testStack.isEmpty());

        // Create a Scanner object
        Scanner userInput = new Scanner(System.in);

        // Prompt the user to input strings
        System.out.println("Please enter 5 strings...");
        for(int i=1; i<6; i++){
            System.out.print("String #" + i + ": ");
            testStack.add(userInput.nextLine());
        }

        // Peek test
        System.out.println("Peek test:");
        System.out.println(testStack.peek());
        // Test isEmpty
        System.out.print("The newly created stack is empty: ");
        System.out.println(testStack.isEmpty());


        // Display the strings in reverse order
        System.out.println("Printing stack in reverse order...");
        for(int i=testStack.size()-1; i >= 0; i--){
            System.out.println(testStack.get(i));
        }



    }
}
