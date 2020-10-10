package com.Exercise_21_01;
import java.util.Stack;
import java.lang.String;

// Created by: Logan Kells
// Date: 10/2/2020

// Exercise 21.01
// (Perform set operations on hash sets) Given two stacks of textbooks of the following subjects:
// {"Chemistry", "Mathematics", "Biology", "English"} and
// {"Biology", "English", "Geography", "Physics"} respectively, find the subjects that are
// (1) only present in the first stack;
// (2) only present in the second stack;
// (3) present in both stacks.
// (You may clone the sets to preserve the original sets from being changed by set methods.)

public class TestStacks {
    public static void main(String[] args){
        // Declare stacks of books
        Stack<String> books1 = new Stack<>();
        Stack<String> books2 = new Stack<>();

        // add elements
        books1.push("Chemistry");
        books1.push("Mathematics");
        books1.push("Biology");
        books1.push("English");

        // add elements
        books2.push("Biology");
        books2.push("English");
        books2.push("Geography");
        books2.push("Physics");

        // Find the items only present in the first stack
        Stack<Object> uniqueSubjects1 = findUnique(books1, books2);

        // Find the items only present in the second stack
        Stack<Object> uniqueSubjects2 = findUnique(books2, books1);

        // Find the items present in both stacks
        Stack<Object> nonUniqueSubjects = findNonUnique(books1, books2);

        // Print the results
        System.out.println("Unique subjects in stack 1: " + uniqueSubjects1.toString());
        System.out.println("Unique subjects in stack 2: " + uniqueSubjects2.toString());
        System.out.println("Items present in both stacks: " + nonUniqueSubjects.toString());

    }

    /**
     * This will identify the items that are only present in the first stack s1, and not present in the second stack s2.
     * @param originalS1 stack 1
     * @param originalS2 stack 2
     * @return uniqueStack List of items only present in s1, not s2.
     */
    public static Stack<Object> findUnique(Stack<?> originalS1, Stack<?> originalS2){
        // Clone the original stacks to avoid data loss when pop()
        Stack<?> s1 = (Stack<?>) originalS1.clone();
        Stack<?> s2 = (Stack<?>) originalS2.clone();

        // Declare return stack
        Stack<Object> uniqueStack = new Stack<>();

        // Pop the top element of s1 and search for that element in s2. If the element is not in s2, then add it to the return stack.
        while(!(s1.empty())){
            Object currItem = s1.pop();
            if(s2.search(currItem) == -1){
                uniqueStack.push(currItem);
            }
        }
        return uniqueStack;
    }

    /**
     * This will identify the items that are only present in both stacks s1, s2.
     * @param originalS1 stack 1
     * @param originalS2 stack 2
     * @return nonUniqueStack items present in both stacks s1, s2.
     */
    public static Stack<Object> findNonUnique(Stack<?> originalS1, Stack<?> originalS2){
        // Clone the original stacks to avoid data loss when pop()
        Stack<?> s1 = (Stack<?>) originalS1.clone();
        Stack<?> s2 = (Stack<?>) originalS2.clone();

        // Declare return stack
        Stack<Object> nonUniqueStack = new Stack<>();

        // Pop the top element of s1 and search for that element in s2.
        // If the element IS in s2, then add it to the return stack.
        while(!(s1.empty())){
            Object currItem = s1.pop();
            if(s2.search(currItem) >= 0){
                nonUniqueStack.push(currItem);
            }
        }
        return nonUniqueStack;
    }
}
