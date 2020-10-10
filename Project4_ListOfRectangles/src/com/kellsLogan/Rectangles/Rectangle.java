package com.kellsLogan.Rectangles;
import java.lang.Number;

// Rectangle.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 9/27/2020

/**
 * Rectangle Class specifications:
 * the class must be constrained to numeric types.
 * the class will have two private members, length and width of the generic type.
 * the class will have a parameterized constructor that receives both length and width as arguments.
 * within the parameterized constructor call the setter methods for each of the private member.
 * create a method calcArea() to calculate the Rectangle area.
 * create a method calcPerimeter() to calculate the perimeter of the Rectangle.
 * create a toString() method to output the dimensions, area, and perimeter of the Rectangle.
 */
public class Rectangle <E extends Number>{
    // In the class definition we've included <E extends Number> which is a bounded type parameter.
    // This restricts the types that can be instantiated from generic E to Numbers.
    // From the super class documentation for Number class:
    /**
     * The abstract class {@code Number} is the superclass of platform
     * classes representing numeric values that are convertible to the
     * primitive types {@code byte}, {@code double}, {@code float}, {@code
     * int}, {@code long}, and {@code short}.
     */

    // Member variables
    private E length, width;

    // Parameterized constructor receiving length, width
    public Rectangle(E length, E width){
        // Instructions requested we use the setter methods.
        setLength(length);
        setWidth(width);
    }

    // Setter Methods
    public void setLength(E length){
        this.length = length;
    }
    public void setWidth(E width){
        this.width = width;
    }

    // Accessor Methods
    public E getLength(){
        return this.length;
    }
    public E getWidth(){
        return this.width;
    }

    /**
     * Method to calculate the rectangular area.
     * NOTE: We're using the java.lang.Number method doubleValue() which returns the value of the specified
     * number as a double, which may involve rounding.
     */
    public double calcArea(){

        return (this.length.doubleValue() * this.width.doubleValue());
    }

    // Method to calculate the rectangular perimeter
    public double calcPerimeter(){
        return ((2 * this.length.doubleValue()) + (2 * this.width.doubleValue()));
    }

    // Method to toString() method to output the dimensions, area, and perimeter of the Rectangle.
    @Override
    public String toString(){
        return String.format("...\n" + "Rectangle Length: " + this.length.doubleValue() +"\nRectangle Width: " + this.width.doubleValue() +
                "\nRectangle Area: " + calcArea() + "\nRectangle Perimeter: " + calcPerimeter());
    }
}
