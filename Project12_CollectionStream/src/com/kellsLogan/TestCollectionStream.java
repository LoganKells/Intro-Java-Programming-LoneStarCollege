package com.kellsLogan;

import java.util.ArrayList;

// TestCollectionStream.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 11/30/2020

public class TestCollectionStream {
    public static void main(String[] args){
        // Load the data in ./resources/newStates.txt into an ArrayList<String> object
        LoadData myDataloader = new LoadData();
        ArrayList<String> data = new ArrayList<>();
        myDataloader.loadText();
        data = myDataloader.getData();

        // (1) Create a stream object of the states data. Print all elements
        System.out.println("\n-------------------------------------------------");
        System.out.println("\nPrinting list of all strings in the .txt file selected:");
        // NOTE: Another method could be: Stream.of(data).forEach(e -> System.out.println(e));
        data.stream().forEach(System.out::println);

        // (2) Print all the states that have the letter 'r' (any case) in it.
        System.out.println("\n-------------------------------------------------");
        System.out.println("\nPrinting list of Strings that contains the char \"r\":");
        data.stream().filter(e -> e.contains(Character.toString('r'))).forEach(System.out::println);

        // (3) Print any state that has multiple words in the state name (e.g. New York)
        System.out.println("\n-------------------------------------------------");
        System.out.println("\nThe following data has a space in the string:");
        data.stream().filter(e -> e.contains(Character.toString(' '))).forEach(System.out::println);

        System.out.println("\nEnding program...");
    }
}
