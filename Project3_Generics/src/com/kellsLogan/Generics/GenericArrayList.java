package com.kellsLogan.Generics;
import java.util.ArrayList;

// GenericArrayList.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 9/20/2020

// Instructions:
// For this assignment, choose a sorting algorithm and make it generic.
// Also, choose a search algorithm and make it generic as well.
// Create a demonstration main method with a menu option (switch statement),
//      1 - for sorting, 2 - for searching, and then demonstrate the sort and search functionality.
// You can demonstrate with self-generated arrays.

public class GenericArrayList<E extends Comparable<E>> {
    // Create a generic ArrayList
    ArrayList<E> myList = new ArrayList<>();
    private int rightCursor;
    private E rightCursorVal;
    private E currMin;

    // Push method
    public void push(E element){
        myList.add(element);
    }

    // Print using toString() method override
    @Override
    public String toString(){
        return myList.toString();
    }

    // Sort method
    public void selectionSort(){
        // Cool visual of sort algorithms: https://visualgo.net/en/sorting
        // Selection sort works by splitting the original array into two subarrays.
        // One sub-array is sorted (on the left)
        // Another sub-array is unsorted (on the right)

        // Selection sort algorithm implemented w/ loop.
        for(int i=0; i < myList.size(); i++){
            // Start the sorted sub-array within LEFT (starting with LEFT 1 element long)
            // This is marked as sorted
            rightCursor = i;
            currMin = myList.get(i);

            // Linear search for a new currMin within the RIGHT sub-array
            for(int j=(i+1); j < myList.size(); j++){
                rightCursorVal = myList.get(j);
                // NOTE: compareTo(E o) method returns a negative integer, zero, or a positive integer as
                //       this object is less than, equal to, or greater than the specified object.
                // Check if(currMin > rightCursorVal)
                if(currMin.compareTo(rightCursorVal) > 0) {
                    currMin = rightCursorVal;
                    this.rightCursor = j;
                }
            }
            // Delete the current min from it's original location
            myList.remove(rightCursor);

            // Insert the current min in the new location
            myList.add(i, currMin);

        }
    }

    // Search method
    public int linearSearch(E item){
        // Linear search implemented w/ a loop
        for(int i=0; i<myList.size(); i++){
            rightCursorVal = myList.get(i);
            // NOTE: compareTo(E o) method returns a negative integer, zero, or a positive integer as
            //       this object is less than, equal to, or greater than the specified object.
            // Check if(item == rightCursorVal)
            if(item.compareTo(rightCursorVal) == 0){
                return i;
            }
        }
        // If the value isn't found, return -1, which we'll use when printing results of the search.
        return -1;
    }
}
