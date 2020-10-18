package com.Exercise_23_13;

public class TestMyArray {
    public static String convertDuration(long d){
        String durationString = String.valueOf(d) + " ms";
        return durationString;
    }

    public static void main(String[] args){
        // Create a new array of sizes 50k, 100k, 150k, 200k, 250k, 300k
        MyArray a50k = new MyArray(50000);
        MyArray a100k = new MyArray(100000);
        //MyArray a150k_SelectionSort = new MyArray(150000);
        //MyArray a200k_SelectionSort = new MyArray(200000);
        //MyArray a250k_SelectionSort = new MyArray(250000);
        //MyArray a300k_SelectionSort = new MyArray(300000);

        System.out.println("Running sorting algorithms...");

        // Run the Selection Sort. Pre-populate the arrays with random int values.
        a50k.populateRand();
        a100k.populateRand();
        a50k.selectionSort();
        a100k.selectionSort();

        // Run the Bubble Sort. Pre-populate the arrays with random int values.
        a50k.populateRand();
        a100k.populateRand();
        a50k.bubbleSort();
        a100k.bubbleSort();

        // Run the Merge Sorts

        // Run the Quick Sorts

        // Run the Heap Sorts

        // Run the Radix Sort

        // ******************** Print Results ********************
        System.out.println("Sorting done! Printing results...");
        // Build a new table with 7 rows of String objects
        String[][] table = new String[7][];
        String[] titleRow = {"Array Size", "Selection Sort", "Bubble Sort", "Merge Sort", "Quick Sort", "Heap Sort", "Radix Sort"};
        String[] row50k = {"50,000", convertDuration(a50k.getSelectionSortDuration()), convertDuration(a50k.getBubbleSortDuration()), "TBD", "TBD", "TBD", "TBD"};
        String[] row100k = {"100,000", convertDuration(a100k.getSelectionSortDuration()), convertDuration(a100k.getBubbleSortDuration()), "TBD", "TBD", "TBD", "TBD"};
        String[] row150k = {"150,000", "TBD", "TBD", "TBD", "TBD", "TBD", "TBD"};
        String[] row200k = {"200,000", "TBD", "TBD", "TBD", "TBD", "TBD", "TBD"};
        String[] row250k = {"250,000", "TBD", "TBD", "TBD", "TBD", "TBD", "TBD"};
        String[] row300k = {"300,000", "TBD", "TBD", "TBD", "TBD", "TBD", "TBD"};
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
