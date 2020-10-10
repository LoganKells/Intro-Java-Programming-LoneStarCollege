package com.Exercise_11_01;
import java.util.Scanner;

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

public class Main {
    public static void main(String[] args){
        // Use Scanner class to create an object "userInput" to read input from System.in
        Scanner userInput = new Scanner(System.in);

        // Prompt the user to enter the sides of the triangle, color, and boolean for whether the triangle is filled.
        System.out.print("Enter Side 1:");
        double s1 = userInput.nextDouble();
        System.out.print("Enter Side 2:");
        double s2 = userInput.nextDouble();
        System.out.print("Enter Side 3:");
        double s3 = userInput.nextDouble();
        System.out.print("Enter Color:");
        String color = userInput.next();
        System.out.print("Filled T/F:");
        Boolean filled = userInput.nextBoolean();


        // Create a new triangle using the user's geometric inputs
        Triangle newT = new Triangle(s1, s2, s3);
        // Update the triangle color
        newT.setColor(color);
        // Update the triangle boolean for filled T/F.
        newT.setFilled(filled);

        // Display the results
        System.out.println(newT.toString());
    }
}
