package com.kellsLogan.PrimeNumber;
import java.util.ArrayList;
import java.util.Scanner;

// TestMyNumber.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 10/12/2020

public class TestMyNumber {
    public static void main(String[] args){
        // Create an ArrayList of MyNumber objects
        ArrayList<MyNumber> intList = new ArrayList<>();

        // Create Scanner object for user input
        Scanner userInput = new Scanner(System.in);

        // Prompt user to enter a few integer
        for(int i=0; i<3; i++){
            System.out.print("Please enter an integer: ");
            // Read the user's input
            int n = userInput.nextInt();
            // Create a MyNumber object
            MyNumber currNumber = new MyNumber(n);
            // Add to the list
            intList.add(currNumber);
        }

        // Print results
        System.out.println("**********************\nProcessing...");
        for(MyNumber number : intList){
            // Return results if the number entered is a prime number.
            System.out.println("The integer " + number.getNumber() + " is prime?: " + number.isPrime());
            // Return the number of prime number between 2 and the user entered integer
            if(number.numberOfPrimes() == 1){
                System.out.println("There is " + number.numberOfPrimes() + " prime number between 2 and " + number.getNumber() + "\n");
            }
            else{
                System.out.println("There are " + number.numberOfPrimes() + " prime numbers between 2 and " + number.getNumber() + "\n");
            }
        }
    }
}
