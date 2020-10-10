/*********************************************************************************
 * (The Rectangle class) Following the example of the Circle class in Section 9.2,*
 * design a class named Rectangle to represent a rectangle. The class contains:   *
 *                                                                                *
 * ■ Two double data fields named width and height that specify the width and     *
 * height of the rectangle. The default values are 1 for both width and height.   *
 * ■ A no-arg constructor that creates a default rectangle.                       *
 * ■ A constructor that creates a rectangle with the specified width and height.  *
 * ■ A method named getArea() that returns the area of this rectangle.            *
 * ■ A method named getPerimeter() that returns the perimeter.                    *
 *                                                                                *
 * Draw the UML diagram for the class and then implement the class. Write a test  *
 * program that creates two Rectangle objects—one with width 4 and height 40      *
 * and the other with width 3.5 and height 35.9. Display the width, height, area, *
 * and perimeter of each rectangle in this order.                                 *
 *********************************************************************************/

package com.Exercise_09_01;

public class Main {
    public static void main(String[] args){
        // Create two rectangle objects
        Rectangle r1 = new Rectangle(4,40);
        Rectangle r2 = new Rectangle(3.5, 35.9);

        // Display the width, height, area, and perimeter of each rectange in this order
        System.out.println("Rectangle R1:\n" + "Width: " + r1.getWidth() + '\n' + "Height: " + r1.getHeight() + '\n' + "Area: " + r1.getArea() + '\n' + "Perimeter: " + r1.getPerimeter());
        System.out.println("Rectangle R2:\n" + "Width: " + r2.getWidth() + '\n' + "Height: " + r2.getHeight() + '\n' + "Area: " + r2.getArea() + '\n' + "Perimeter: " + r2.getPerimeter());
    }
}
