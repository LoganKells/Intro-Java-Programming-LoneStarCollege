package com.kellsLogan.Rectangles;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// Rectangle.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 9/27/2020

/**
 * main() method:
 * In main, you will create an ArrayList of 10 Integer (or any numeric Type of your choice) rectangles
 * (using List as the reference type). Output the contents of the List using the foreach method.
 * Use the Collections.sort method to sort your Rectangles. Note that the RectangleComparator will be necessary.
 * Finally, output the rectangles using the foreach method. I will deduct points for use of for loops in this assignment.
 */
public class TestRectangles {
    public static void main(String[] args){
        // Create an ArrayList of 10 Integer rectangles (using List as the reference type)
        // The benefit of using List<> reference type is we can consistently access the List<> superclass methods.
        // This is because List<> is a superclass to the child ArrayList<> class.
        List<Rectangle<Double>> myRectangles = new ArrayList<>(10);

        // Add 10 rectangles to the List
        for(int i=0; i<10; i++){
            // Define a random width & length to use between [1,100]
            double min = 1.0;
            double max = 100.0;
            double currWidth = min + (Math.random() * (max - min));
            double currLength = min + (Math.random() * (max - min));

            // Add the Rectangle object to the List.
            myRectangles.add(new Rectangle(currLength, currWidth));
        }

        // Output the contents of the List using the forEach() method (Unsorted)
        System.out.println("*****************************\n\n" + "Printing UNSORTED Rectangles...\n");
        myRectangles.forEach(doubleRectangle -> System.out.println(doubleRectangle));
        System.out.print("\nAll Rectangles printed...\n\n*****************************\n");

        // Use the Collections.sort method to sort the List of Double Rectangles based on the calculated area of each Rectangle.
        System.out.print("\nSorting list of Rectangles by area...\n\n");
        Collections.sort(myRectangles, new RectangleComparator());

        // Output the contents of the List using the forEach() method (Sorted)
        System.out.println("*****************************\n\n" + "Printing SORTED Rectangles...\n");
        myRectangles.forEach(r -> System.out.println(r));
        System.out.print("\nAll Rectangles printed...\n\n*****************************\n\n" + "Ending program...");
    }
}
