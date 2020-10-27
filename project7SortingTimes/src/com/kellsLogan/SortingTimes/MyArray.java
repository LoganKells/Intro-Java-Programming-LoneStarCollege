package com.kellsLogan.SortingTimes;

import java.util.Arrays;
import java.util.ArrayList;

// MyArray.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 10/19/2020
// NOTE -
// All of the sorting algorithms were based on listings from this book:
// Introduction to Java Programming and Data Structures, Comprehensive Version, 11th Edition, Y. Daniel Liang
// Pearson also provides the example code online that can be downloaded and examined as this website:
// https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/

public class MyArray {
    private final int size;
    private final int[] data;
    private long selectionSortDuration;
    private long bubbleSortDuration;
    private long mergeSortDuration;
    private long quickSortDuration;
    private long heapSortDuration;
    private long radixSortDuration;

    // Constructors
    MyArray(int size){
        // Allocate heap memory for the array of the given size
        this.size = size;
        this.data = new int[this.size];
    }

    //***************** Mutators *****************
    public void set(int i, int value){
        this.data[i] = value;
    }
    public void setSelectionSortDuration(long t){
        this.selectionSortDuration = t;
    }
    public void setBubbleSortDuration(long t){
        this.bubbleSortDuration = t;
    }
    public void setMergeSortDuration(long t){
        this.mergeSortDuration = t;
    }
    public void setQuickSortDuration(long t){
        this.quickSortDuration = t;
    }
    public void setHeapSortDuration(long t){
        this.heapSortDuration = t;
    }
    public void setRadixSortDuration(long t){
        this.radixSortDuration = t;
    }

    // Method to populate random integers in the array
    public void populateRand(){
        for(int i=0; i<this.size; i++){
            // Get random integer from [1,100]
            int min = 1;
            int max = 101;
            double currValuedouble = min + (Math.random() * (max - min));
            // Cast the double to int type.
            int currVal = ((int) currValuedouble);
            // Populate the random value in the array
            set(i, currVal);
        }
    }

    public void selectionSort(){
        //Selection sort algorithm
        // NOTE - See the book section for selection sort "Introduction to Java Programming and Data Structures, Comprehensive Version,
        // 11th Edition, Y. Daniel Liang 7.11 Sorting Arrays"
        // returns time of this algorithm, long.

        // Initialize the start time.
        long startTime = System.currentTimeMillis();

        // Search from data[0] to data[size-1] for a new minimum
        for(int i=0; i<size-1; i++){
            // The cursor at i is assumed to be the minimum.
            // Next we'll test if this is there is a smaller value to the right of i.
            int currMin = data[i];

            // Test if data[i] is actually the minimum between data[i+1] to data[size]
            // NOTE - Anything from data[0] to data[i] is assumed to be sorted.
            for(int j=i+1; j<size; j++){

                if(data[j] < currMin & j!=i){
                    int oldMin = data[i];
                    currMin = data[j];
                    // Insert the current minimum into the correct position on the left side of the array.
                    data[i] = currMin;
                    // Swap the old minimum with the position of the new minimum
                    data[j] = oldMin;
                }
            }
        }
        // Calculate the duration of the sorting algorithm
        this.selectionSortDuration = System.currentTimeMillis() - startTime;
    }

    public void bubbleSort(){
        // Bubble sort algorithm
        // NOTE - See the book section for selection sort "Introduction to Java Programming and Data Structures, Comprehensive Version,
        // 11th Edition, Y. Daniel Liang 23.3 Bubble Sort"
        // returns time of this algorithm, long.
        // NOTE - This is based on Listing 23.2 in the book.

        // Initialize the start time.
        long startTime = System.currentTimeMillis();

        // Repeat the bubble sort algorithm i times. Size-1 repeats are required to fully sort all arrays.
        for(int i=0; i<size; i++){
            // Next loop through each left-right pair within the array
            for(int j=0; j<size-1; j++){
                int left = get(j);
                int right = get(j+1);
                if(left>right){
                    set(j, right);
                    set(j+1, left);
                }
            }
        }
        // Calculate the duration of the sorting algorithm
        this.bubbleSortDuration = System.currentTimeMillis() - startTime;
    }

    public void mergeSort(int[] dataInput){
        // Merge sort algorithm
        // NOTE - See the book section for selection sort "Introduction to Java Programming and Data Structures, Comprehensive Version,
        // 11th Edition, Y. Daniel Liang 23.4 Merge Sort"
        // This is based on Listing 23.6 in the book.
        // returns time of this algorithm, long.

        // Initialize the start time.
        long startTime = System.currentTimeMillis();

        // NOTE - Merge sort is recursive implementation
        // base condition... If the length of the array is > 1, then the mergesort should run.
        if(dataInput.length > 1){
            // sort first half
            int sizeLeft = dataInput.length / 2;
            // Copy the contents of the original array "data" to a "left" array
            int[] leftData = new int[sizeLeft];
            System.arraycopy(dataInput, 0, leftData, 0, sizeLeft);
            mergeSort(leftData);

            // sort second half
            int sizeRight = dataInput.length - dataInput.length / 2;
            int[] rightData = new int[sizeRight];
            System.arraycopy(dataInput, sizeLeft, rightData, 0, sizeRight);
            mergeSort(rightData);

            // merge two halves
            mergeLists(leftData, rightData, dataInput);
        }
        // Calculate the duration of the sorting algorithm
        this.mergeSortDuration = System.currentTimeMillis() - startTime;
    }

    public static void mergeLists(int[] left, int[] right, int[] merged){
        // This is based on Listing 23.6 in the book.

        // This method is used in the mergeSort() method to merge two lists during the recursion.
        int cursorLeft = 0;
        int cursorRight = 0;
        int cursorMerged = 0;

        while(cursorLeft < left.length && cursorRight < right.length){
            // Sort the two integers left vs. right.
            if(left[cursorLeft] < right[cursorRight]){
                merged[cursorMerged] = left[cursorLeft];
                cursorMerged += 1;
                cursorLeft += 1;
            }
            else{
                merged[cursorMerged] = right[cursorRight];
                cursorMerged += 1;
                cursorRight += 1;
            }
            // It's possible data remains in the left or right arrays.
            // Let's process those.
            while(cursorLeft < left.length){
                merged[cursorMerged] = left[cursorLeft];
                cursorMerged += 1;
                cursorLeft += 1;
            }
            while(cursorRight < right.length){
                merged[cursorMerged] = right[cursorRight];
                cursorMerged += 1;
                cursorRight += 1;
            }
        }
    }

    public void quickSort(int[] dataInput){
        // This is based on Listing 23.8 in the book.
        // Quick sort algorithm
        // NOTE - See the book section for selection sort "Introduction to Java Programming and Data Structures, Comprehensive Version,
        // 11th Edition, Y. Daniel Liang 23.5 Quick Sort"
        quickSortHelper(dataInput, 0, dataInput.length-1);
    }

    public static void quickSortHelper(int[] dataInput, int start, int end){
        // This is based on Listing 23.8 in the book.
        // This method implements the quickSort(int[]) method by passing the data by reference.
        if(end > start){
            // Find the index to pivot
            int cursor = partition(dataInput, start, end);
            // Recursively call quickSortHelper up to the cursor, and after the cursor.
            quickSortHelper(dataInput, start, cursor-1);
            quickSortHelper(dataInput, cursor+1, end);
        }
    }

    public static int partition(int[] dataInput, int start, int end){
        // This is based on Listing 23.8 in the book.

        // This method will partition the original array such that all the values
        // to the left of the cursor "pivot" are less than the pivot, and all the values
        // to the right of the cursor "pivot" are greater than the pivot.

        // partition list into list1 and list2 such that
        // - all elements in list1 <= pivot and
        // - all elements in list2 > pivot;
        int cursorValue = dataInput[start];
        int indexLow = start+1;
        int indexHigh = end;

        while(indexHigh > indexLow){
            // Search for values <= cursor value; from left to right beginning at the indexLow position.
            while(indexLow <= indexHigh && dataInput[indexLow] <= cursorValue){
                indexLow += 1;
            }
            // Search for values <= cursor value; from right to left beginning at the end ("indexHigh") position.
            while(indexLow <= indexHigh && dataInput[indexHigh] > cursorValue){
                indexHigh -= 1;
            }
            // Move the value at the lower index with the value at the  higher index.
            if(indexHigh > indexLow){
                // save the int temporarily
                int tempVal = dataInput[indexLow];
                dataInput[indexLow] = dataInput[indexHigh];
                dataInput[indexHigh] = tempVal;
            }
        }

        // It's possible the initial value for indexHigh is > the cursorValue for the pivot.
        // In that case reduce the index by 1.
        while(indexHigh > start && dataInput[indexHigh] >= cursorValue){
            indexHigh -= 1;
        }

        // Replace the cursor value with the dataInput[indexHigh] value
        if(cursorValue > dataInput[indexHigh]){
            dataInput[start] = dataInput[indexHigh];
            dataInput[indexHigh] = cursorValue;
            return indexHigh;
        }
        else{
            return start;
        }
    }

    public void heapSort(int[] dataInput){
        // Note - this is based on Listing 23.9 in the book and 23.10.

        // Convert the int[] to Integer[]
        Integer[] dataFormal = Arrays.stream(dataInput).boxed().toArray(Integer[]::new );

        // Create a heap
        // NOTE: This code for a heap is copied from Listing 23.9
        Heap<Integer> heapData = new Heap<Integer>(dataFormal);
        // Load data to the heap
        for (Integer integer : dataFormal) {
            heapData.add(integer);
        }
        // Remove elements from the heap
        for(int i=dataFormal.length-1; i>=0; i--){
            dataFormal[i] = heapData.remove();
        }
    }

    public void radixSort(int[] dataInput, int digits){
        // Initialize the start time.
        long startTime = System.currentTimeMillis();

        // NOTE -
        // This is based on the book listing in section 23.7 Bucket and Radix Sort
        // The radix sort is also documented online for exercise 23.12
        // https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/
        // Radix sort uses 10 buckets as described in the book.
        ArrayList<Integer>[] bucketList = new ArrayList[10];
        // Create a nested ArrayList within each bucket (of digit-keys)
        for(int i=0; i<bucketList.length; i++){
            bucketList[i] = new ArrayList<Integer>();
        }
        // Based on exercise 23.12 provided here https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/
        for (int cursor=0; cursor<=digits; cursor++) {
            // Clear buckets
            for (ArrayList<Integer> integers : bucketList) {
                integers.clear();
            }
            // Distribute the elements from list to buckets
            for (int value : dataInput) {
                int key = bucketKey(value, cursor);
                bucketList[key].add(value);
            }

            // Now move the elements from the buckets back to list
            int k = 0; // k is an index for list
            for (ArrayList<Integer> integers : bucketList) {
                for (Integer integer : integers) {
                    dataInput[k++] = integer;
                }
            }
        }
        // Calculate the duration of the sorting algorithm
        this.radixSortDuration = System.currentTimeMillis() - startTime;
    }

    public static int bucketKey(int num, int pos){
        // Initialize a key a 1, which is a multiple of the key value.
        int key = 1;
        for(int j=0; j<pos; j++){
            key *= 10;
        }
        int remainder = (num / key) % 10;
        return remainder;
    }
    //***************** End of Mutators *****************


    //***************** Accessors *****************
    public int getSize(){
        // Data array size.
        return this.size;
    }
    public int get(int i){
        // Get value at an index, i.
        return this.data[i];
    }
    public long getSelectionSortDuration(){
        return this.selectionSortDuration;
    }
    public long getBubbleSortDuration(){
        return this.bubbleSortDuration;
    }
    public long getMergeSortDuration(){
        return this.mergeSortDuration;
    }
    public long getQuickSortDuration(){
        return this.quickSortDuration;
    }
    public long getHeapSortDuration(){
        return this.heapSortDuration;
    }
    public long getRadixSortDuration(){
        return this.radixSortDuration;
    }
    public int[] getData(){
        return this.data;
    }

    // Override the java.util.Arrays method toString()
    @Override
    public String toString(){
        StringBuilder dataString = new StringBuilder();
        dataString.append("[");
        for(int i=0; i<this.size; i++){
            dataString.append(get(i)).append(",");
        }
        // Format the string to end with "]" not a comma.
        String stringFormatted;
        stringFormatted = dataString.substring(0, dataString.length()-1);
        stringFormatted += "]";
        return stringFormatted;
    }
    //***************** End of Accessors *****************
}