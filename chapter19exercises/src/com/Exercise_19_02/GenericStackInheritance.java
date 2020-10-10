package com.Exercise_19_02;
import java.util.ArrayList;

// Created by: Logan Kells
// Date: 10/4/2020

// Intro to Java 11th Edition Liang, Exercise 19.2
// (Implement GenericStack using inheritance)
// In Listing 19.1, GenericStack is implemented using composition.
// Define a new stack class that extends ArrayList.
// Draw the UML diagram for the classes then implement GenericStack.
// Write a test program that prompts the user to enter five strings and displays them in reverse order.

public class GenericStackInheritance<E> extends ArrayList<E> {
    // NOTE: No constructors required
    // NOTE: We'll use the methods included in ArrayList such as size() and get(i).

    // Stack peek method
    public E peek(){
        return this.get(this.size()-1);
    }

    // Stack push method
    public void push(E currObj){
        this.add(currObj);
    }

    // Stack pop method: returns the top item and deletes it from the stack
    public E pop(){
        // Save the top object in memory
        E currTopObj = this.get(this.size()-1);
        // delete the top object
        this.remove(this.size()-1);
        return currTopObj;
    }

    // Stack isEmpty() method

    public boolean isEmpty(){
        return this.size() - 1 == -1;
    }

}
