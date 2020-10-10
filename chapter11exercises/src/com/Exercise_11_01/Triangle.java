package com.Exercise_11_01;

// 11.1 (page 469)
// (The Triangle class) Design a class named Triangle that extends GeometricObject. The class contains:
    //■■ Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of a triangle.
    //■■ A no-arg constructor that creates a default triangle.
    //■■ A constructor that creates a triangle with the specified side1, side2, and side3.
    //■■ The accessor methods for all three data fields.
    //■■ A method named getArea() that returns the area of this triangle.
    //■■ A method named getPerimeter() that returns the perimeter of this triangle.
    //■■ A method named toString() that returns a string description for the triangle.
//
//For the formula to compute the area of a triangle, see Programming Exercise 2.19. The toString() method is implemented as follows:
//return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
//Draw the UML diagrams for the classes Triangle and GeometricObject and implement the classes.
// Write a test program that prompts the user to enter three sides of the triangle, a color,
// and a Boolean value to indicate whether the triangle is filled. The program should create a
// Triangle object with these sides and set the color and filled properties using the input.
// The program should display the area, perimeter, color, and true or false to indicate
// whether it is filled or not.

public class Triangle extends GeometricObject {
    private double side1, side2, side3;

    // Default no-argument Constructor
    public Triangle(){
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }
    // Constructor w/ arguments
    public Triangle(double s1, double s2, double s3){
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }
    // This accessor will return an array [side1, side2, side3]
    public double[] getSides(){
        double[] array = new double[3];
        return array;
    }
    // Calculate area
    public double getArea(){
        // NOTE: I'm using Heron's Formula for the area of a triangle from: https://www.mathopenref.com/heronsformula.html
        double p = getPerimeter();
        double halfPerimeter = p / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));
    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    // This method will return the string description for the triangle
    public String toString(){
        return "Side1: " + side1 + "; Side2: " + side2 + "; Side3: " + side3 + '\n'
                + "Perimeter: " + getPerimeter() + "; Area: " + getArea() + '\n'
                + "FilledColor: " + isFilled() + "; Color: " + getColor();
    }

}
