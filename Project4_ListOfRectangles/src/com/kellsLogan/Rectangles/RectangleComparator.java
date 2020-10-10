package com.kellsLogan.Rectangles;
import java.util.Comparator;

// RectangleComparator.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 9/27/2020

/**
 * Comparator implementation
 * RectangleComparator implements the Comparator<Rectangle<E>> and overrides compare() method
 * based on the area of Rectangles r1, r2.
 */
public class RectangleComparator implements Comparator<Rectangle> {
    /**
     * We override the compare() method which is a method from the Comparator interface.
     *
     * @param r1 Rectangle 1, with calculated area
     * @param r2 Rectangle 2, with calculated area
     * @return Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Rectangle r1, Rectangle r2){
        // r1 > r2 area -> Return +1
        if(r1.calcArea() > r2.calcArea()){
            return 1;
        }
        // r1 < r2 area -> Return -1
        else if (r1.calcArea() < r2.calcArea()){
            return -1;
        }
        // r1.area = r2.area -> Return 0
        else{
            return 0;
        }
    }
}
