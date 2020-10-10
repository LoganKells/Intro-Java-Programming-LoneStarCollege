// The following is needed:
    // Two double data fields named width and height that specify the width and height of the rectangle. The default values are 1 for both width and height.
    // A no-arg constructor that creates a default rectangle.
    // A constructor that creates a rectangle with the specified width and height.
    // A method named getArea() that returns the area of this rectangle.
    // A method named getPerimeter() that returns the perimeter.

        package com.Exercise_09_01;

public class Rectangle {
    // Private member variables
    private double width;
    private double height;

    // Default Constructor; no args
    public Rectangle(){
        width = 1;
        height = 1;
    }
    // Constructor accepting width & height
    public Rectangle(double w, double h){
        this.width = h;
        this.height = w;
    }

    // Calculate the area of the rectangle
    double getArea(){
        return width * height;
    }

    // Calculate the Perimeter
    double getPerimeter(){
        return (2 * width) + (2 * height);
    }

    // Setter: Sets height and width
    public void setWidth(double w){
        this.width = w;
    }
    public void setHeight(double h){
        this.height = h;
    }

    // Getters
    public double getWidth(){
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }
}
