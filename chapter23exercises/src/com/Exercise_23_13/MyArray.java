package com.Exercise_23_13;

public class MyArray {
    private int size;
    private int[] data;
    private long selectionSortDuration;
    private long bubbleSortDuration;

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
    // Method to populate random integers in the array
    public void populateRand(){
        for(int i=0; i<this.size; i++){
            // Get random integer from [1,100]
            int min = 1;
            int max = 100;
            double currValuedouble = min + (Math.random() * (max - min));
            // Cast the double to int type.
            int currVal = ((int) currValuedouble);
            // Populate the random value in the array
            set(i, currVal);
        }
    }

    public void selectionSort(){
        /**
         * Selection sort algorithm
         * NOTE - See the book section for selection sort "Introduction to Java Programming and Data Structures, Comprehensive Version,
         * 11th Edition, Y. Daniel Liang 7.11 Sorting Arrays"
         *
         * returns time of this algorithm, long.
         */
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

        // Calculate the duration
        this.selectionSortDuration = System.currentTimeMillis() - startTime;
    }

    public void bubbleSort(){
        // WARNING not bubble sort yet!!!!
        /**
         * Selection sort algorithm
         * NOTE - See the book section for selection sort "Introduction to Java Programming and Data Structures, Comprehensive Version,
         * 11th Edition, Y. Daniel Liang 7.11 Sorting Arrays"
         *
         * returns time of this algorithm, long.
         */
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


        // Calculate the duration
        this.bubbleSortDuration = System.currentTimeMillis() - startTime;
    }
    //***************** End of Mutators *****************


    //***************** Accessors *****************
    public int getSize(){
        return this.size;
    }
    public int get(int i){
        return this.data[i];
    }
    public long getSelectionSortDuration(){
        return this.selectionSortDuration;
    }
    public long getBubbleSortDuration(){
        return this.bubbleSortDuration;
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
