package com.Exercise_19_01;

// Created by: Logan Kells
// Date: 9/20/2020

// Intro to Java 11th Edition Liang, Exercise 19.1
// (Revising Listing 19.1)
// Revise the GenericStack class in Listing 19.1 to implement it using an array rather than an ArrayList.
// You should check the array size before adding a new element to the stack. If the array is full,
// create a new array that doubles the current array size and copy the elements from the current array to the new array.

public class TestStack {
    public static void main(String[] args){
        // Test a ArrayList<E> generic stack
        GenericStack<String> currStack = new GenericStack<>();
        currStack.push("London");
        currStack.push("Paris");
        currStack.push("Berlin");

        // Test an Array generic stack (NOT ArrayList)
        GenericStackArray<String> stack2 = new GenericStackArray<>();
        stack2.push("Hi");
        stack2.push("My");
        stack2.push("Name");

        // Print stacks
        System.out.println(currStack.toString());



        for(int j = 0; j < stack2.getSize(); j++){
            System.out.println(stack2.pop());
        }

    }
}
