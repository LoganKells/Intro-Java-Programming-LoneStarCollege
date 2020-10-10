// Created by Logan Kells 8/30/2020
// 4.1 (Geometry: area of a pentagon) Write a program that prompts the user
// to enter the length from the center of a pentagon to a vertex and
// computes the area of the pentagon, as shown in the following figure.

package com.Exercise_04_01;
import java.util.Scanner;

public class Pentagon {
    public static double getAreaPentagon(double radius){
        // This public method returns the area of a pentagon.
        double lengthS = 2 * radius * Math.sin(Math.PI / 5);
        return (5 * Math.pow(lengthS, 2)) / (4 * Math.tan(Math.PI / 5));
    }

    public static void main(String[] args){
        // Gather radius input from user.
        // Use Scanner class to create an object to read input from System.in
        System.out.print("Please enter the radius of the pentagon: ");
        Scanner userInput = new Scanner(System.in);
        double radius = userInput.nextDouble();

        // Calculate the area of the pentagon. NOTE here the radius is passed by value.
        double area = getAreaPentagon(radius);

        // Print the results
        System.out.print("The area of a pentagon with the radius " + radius + " is: " + area);
    }
}
