package com.Exercise_11_04;
import java.util.Scanner;
import java.util.ArrayList;

// Created by: Logan Kells
// Date: 9/13/2020

// 11.4
// (Maximum element in ArrayList) Write the following method that returns the maximum value in an ArrayList of integers.
// The method returns null if the list is null or the list size is 0.
// public static Integer max(ArrayList<Integer> list)
// Write a test program that prompts the user to enter a sequence of numbers ending
// with 0 and invokes this method to return the largest number in the input.

public class Main {
    public static void main(String[] args){
        // Scanner class used for reading console input.
        Scanner input = new Scanner(System.in);

        // Test program that prompts the user to enter a sequence of numbers ending
        //// with 0 and invokes this method to return the largest number in the input.
        System.out.print("Please enter a series of numbers that ends in 0. Separate digits with spaces: ");

        // Set the input values to an ArrayList class
        ArrayList<Integer> digitsInput = new ArrayList<>();
        int currVal = input.nextInt();
        while(currVal != 0){
            digitsInput.add(currVal);
            currVal = input.nextInt();
        }

        // Call the max method that returns the max value.
        System.out.print("Max value: " + max(digitsInput));
    }

    public static Integer max(ArrayList<Integer> listIn){
        int maxVal = 0;
        int currVal = listIn.get(0);
        if(currVal == 0){
            return null;
        }
        else{
            for(int i = 0; i < listIn.size(); i++){
                if(listIn.get(i) > maxVal){
                    maxVal = listIn.get(i);
                }
            }
            return maxVal;
        }
    }
}
