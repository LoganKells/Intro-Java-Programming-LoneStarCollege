package com.kellsLogan.SortingTimes;

// TestMyArray.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 10/19/2020
// NOTE -
// All of the sorting algorithms within the class MyArray.java were based on listings from this book:
// Introduction to Java Programming and Data Structures, Comprehensive Version, 11th Edition, Y. Daniel Liang
// Pearson also provides the example code online that can be downloaded and examined as this website:
// https://media.pearsoncmg.com/ph/esm/ecs_liang_ijp_11/cw/

public class TestMyArray {
    public static String convertDuration(long d){
        // This method will convert a long value to a String object like "567 ms".
        return String.valueOf(d) + " ms";
    }

    public static void main(String[] args){
        // Create a new array of sizes 50k, 100k, 150k, 200k, 250k, 300k
        MyArray a50k = new MyArray(50000);
        MyArray a100k = new MyArray(100000);
        MyArray a150k = new MyArray(150000);
        MyArray a200k = new MyArray(200000);
        MyArray a250k = new MyArray(250000);
        MyArray a300k = new MyArray(300000);

        System.out.println("Running sorting algorithms...");

        // Run the Selection Sort. Pre-populate the arrays with random int values.
        a50k.populateRand();
        a100k.populateRand();
        a150k.populateRand();
        a200k.populateRand();
        a250k.populateRand();
        a300k.populateRand();
        // Run the selection sort.
        a50k.selectionSort();
        a100k.selectionSort();
        a150k.selectionSort();
        a200k.selectionSort();
        a250k.selectionSort();
        a300k.selectionSort();

        // Run the Bubble Sort. Pre-populate the arrays with random int values.
        a50k.populateRand();
        a100k.populateRand();
        a150k.populateRand();
        a200k.populateRand();
        a250k.populateRand();
        a300k.populateRand();
        // Run the bubble sort.
        a50k.bubbleSort();
        a100k.bubbleSort();
        a150k.bubbleSort();
        a200k.bubbleSort();
        a250k.bubbleSort();
        a300k.bubbleSort();

        // Run the Merge Sorts. Pre-populate the arrays with random int values.
        a50k.populateRand();
        a100k.populateRand();
        a150k.populateRand();
        a200k.populateRand();
        a250k.populateRand();
        a300k.populateRand();
        // Merge sort is recursive so we need to count time outside of the recursion.
        // 50k merge sort
        long startTime = System.currentTimeMillis();
        a50k.mergeSort(a50k.getData());
        a50k.setMergeSortDuration(System.currentTimeMillis() - startTime);
        // 100k merge sort
        startTime = System.currentTimeMillis();
        a100k.mergeSort(a100k.getData());
        a100k.setMergeSortDuration(System.currentTimeMillis() - startTime);
        // 150k merge sort
        startTime = System.currentTimeMillis();
        a150k.mergeSort(a150k.getData());
        a150k.setMergeSortDuration(System.currentTimeMillis() - startTime);
        // 200k merge sort
        startTime = System.currentTimeMillis();
        a200k.mergeSort(a200k.getData());
        a200k.setMergeSortDuration(System.currentTimeMillis() - startTime);
        // 250k merge sort
        startTime = System.currentTimeMillis();
        a250k.mergeSort(a250k.getData());
        a250k.setMergeSortDuration(System.currentTimeMillis() - startTime);
        // 300k merge sort
        startTime = System.currentTimeMillis();
        a300k.mergeSort(a300k.getData());
        a300k.setMergeSortDuration(System.currentTimeMillis() - startTime);


        // Run the Quick Sorts. Pre-populate the arrays with random int values.
        // Quick sort is recursive so we need to count time outside of the recursion.
        // 50k quick sort
        a50k.populateRand();
        startTime = System.currentTimeMillis();
        a50k.quickSort(a50k.getData());
        a50k.setQuickSortDuration(System.currentTimeMillis() - startTime);
        // 100k quick sort
        a100k.populateRand();
        startTime = System.currentTimeMillis();
        a100k.quickSort(a100k.getData());
        a100k.setQuickSortDuration(System.currentTimeMillis() - startTime);
        // 150k quick sort
        a150k.populateRand();
        startTime = System.currentTimeMillis();
        a150k.quickSort(a150k.getData());
        a150k.setQuickSortDuration(System.currentTimeMillis() - startTime);
        // 200k quick sort
        a200k.populateRand();
        startTime = System.currentTimeMillis();
        a200k.quickSort(a200k.getData());
        a200k.setQuickSortDuration(System.currentTimeMillis() - startTime);
        // 250k quick sort
        a250k.populateRand();
        startTime = System.currentTimeMillis();
        a250k.quickSort(a250k.getData());
        a250k.setQuickSortDuration(System.currentTimeMillis() - startTime);
        // 300k quick sort
        a300k.populateRand();
        startTime = System.currentTimeMillis();
        a300k.quickSort(a300k.getData());
        a300k.setQuickSortDuration(System.currentTimeMillis() - startTime);

        // Run the Heap Sorts. Pre-populate the arrays with random int values.
        // 50k heap sort
        a50k.populateRand();
        startTime = System.currentTimeMillis();
        a50k.heapSort(a50k.getData());
        a50k.setHeapSortDuration(System.currentTimeMillis() - startTime);
        // 100k heap sort
        a100k.populateRand();
        startTime = System.currentTimeMillis();
        a100k.heapSort(a100k.getData());
        a100k.setHeapSortDuration(System.currentTimeMillis() - startTime);
        // 150k heap sort
        a150k.populateRand();
        startTime = System.currentTimeMillis();
        a150k.heapSort(a150k.getData());
        a150k.setHeapSortDuration(System.currentTimeMillis() - startTime);
        // 200k heap sort
        a200k.populateRand();
        startTime = System.currentTimeMillis();
        a200k.heapSort(a200k.getData());
        a200k.setHeapSortDuration(System.currentTimeMillis() - startTime);
        // 250k heap sort
        a250k.populateRand();
        startTime = System.currentTimeMillis();
        a250k.heapSort(a250k.getData());
        a250k.setHeapSortDuration(System.currentTimeMillis() - startTime);
        // 300k heap sort
        a300k.populateRand();
        startTime = System.currentTimeMillis();
        a300k.heapSort(a300k.getData());
        a300k.setHeapSortDuration(System.currentTimeMillis() - startTime);

        // Run the Radix Sort. Pre-populate the arrays with random int values.
        a50k.populateRand();
        a100k.populateRand();
        a150k.populateRand();
        a200k.populateRand();
        a250k.populateRand();
        a300k.populateRand();
        // Run the radix sorts. Digits is set to 3 because the random integers are set to be between 1-101.
        a50k.radixSort(a50k.getData(), 3);
        a100k.radixSort(a100k.getData(), 3);
        a150k.radixSort(a150k.getData(), 3);
        a200k.radixSort(a200k.getData(), 3);
        a250k.radixSort(a250k.getData(), 3);
        a300k.radixSort(a300k.getData(), 3);


        // ******************** Print Results ********************
        System.out.println("Sorting done! Printing results...");
        // Build a new table with 7 rows of String objects
        String[][] table = new String[7][];
        String[] titleRow = {"Array Size", "Selection Sort", "Bubble Sort", "Merge Sort", "Quick Sort", "Heap Sort", "Radix Sort"};
        String[] row50k = {"50,000", convertDuration(a50k.getSelectionSortDuration()), convertDuration(a50k.getBubbleSortDuration()), convertDuration(a50k.getMergeSortDuration()), convertDuration(a50k.getQuickSortDuration()), convertDuration(a50k.getHeapSortDuration()), convertDuration(a50k.getRadixSortDuration())};
        String[] row100k = {"100,000", convertDuration(a100k.getSelectionSortDuration()), convertDuration(a100k.getBubbleSortDuration()), convertDuration(a100k.getMergeSortDuration()), convertDuration(a100k.getQuickSortDuration()), convertDuration(a100k.getHeapSortDuration()), convertDuration(a100k.getRadixSortDuration())};
        String[] row150k = {"150,000", convertDuration(a150k.getSelectionSortDuration()), convertDuration(a150k.getBubbleSortDuration()), convertDuration(a150k.getMergeSortDuration()), convertDuration(a150k.getQuickSortDuration()), convertDuration(a150k.getHeapSortDuration()), convertDuration(a150k.getRadixSortDuration())};
        String[] row200k = {"200,000", convertDuration(a200k.getSelectionSortDuration()), convertDuration(a200k.getBubbleSortDuration()), convertDuration(a200k.getMergeSortDuration()), convertDuration(a200k.getQuickSortDuration()), convertDuration(a200k.getHeapSortDuration()), convertDuration(a200k.getRadixSortDuration())};
        String[] row250k = {"250,000", convertDuration(a250k.getSelectionSortDuration()), convertDuration(a250k.getBubbleSortDuration()), convertDuration(a250k.getMergeSortDuration()), convertDuration(a250k.getQuickSortDuration()), convertDuration(a250k.getHeapSortDuration()), convertDuration(a250k.getRadixSortDuration())};
        String[] row300k = {"300,000", convertDuration(a300k.getSelectionSortDuration()), convertDuration(a300k.getBubbleSortDuration()), convertDuration(a300k.getMergeSortDuration()), convertDuration(a300k.getQuickSortDuration()), convertDuration(a300k.getHeapSortDuration()), convertDuration(a300k.getRadixSortDuration())};
        table[0] = titleRow;
        table[1] = row50k;
        table[2] = row100k;
        table[3] = row150k;
        table[4] = row200k;
        table[5] = row250k;
        table[6] = row300k;

        // Print the table
        System.out.println("The following durations were observed for randomly populated int arrays of this following sizes. Duration is in milliseconds.");
        System.out.println("_____________________________________________________________________________________________________________");
        for(String[] row : table){
            String spacing = "%-16s%-16s%-16s%-16s%-16s%-16s%-16s\n";
            System.out.format(spacing,row);
        }
        System.out.println("_____________________________________________________________________________________________________________");
    }
}