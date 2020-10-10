package com.Exercise_19_01;

// Created by: Logan Kells
// Date: 9/20/2020

// Intro to Java 11th Edition Liang, Exercise 19.1
// (Revising Listing 19.1)
// Revise the GenericStack class in Listing 19.1 to implement it using an array rather than an ArrayList.
// You should check the array size before adding a new element to the stack. If the array is full,
// create a new array that doubles the current array size and copy the elements from the current array to the new array.

public class GenericStackArray<E> {
    // Create a generic array using the restriction for Array generics detailed on Page 787 in the book.
    E[] arrList = (E[])new Object[2]; // from page 787
    private int cursor = 0;

    // ********************* Accessors *********************
    public int getSize(){
        return arrList.length;
    }
    public E getElement(int i){
        return arrList[i];
    }

    // ********************* Mutators *********************
    public void setCursor(int cursor){
        this.cursor = cursor;
    }

    // Push a new value
    public void push(E element){
        // Check the array length & double the size of the array if needed.
        if(cursor >= arrList.length){
            doubleSize();
        }
        // Add new element
        arrList[cursor] = element;
        cursor += 1;
    }

    // Pop the top of the stack
    public E pop(){
        cursor -= 1;
        if(cursor >= 0){
            E element = arrList[cursor];
            arrList[cursor] = null;
            return element;
        }
        else{
            return null;
        }
    }

    // Double the array size
    public void doubleSize(){
        // Create a new list that is 2x the size of the original list
        E[] newList = (E[])new Object[arrList.length * 2];
        System.arraycopy(arrList, 0, newList, 0, arrList.length);
        arrList = newList;
    }


    // Return

}
