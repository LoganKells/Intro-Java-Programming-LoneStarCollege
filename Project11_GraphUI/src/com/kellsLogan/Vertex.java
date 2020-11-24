package com.kellsLogan;
import java.lang.StringBuilder;

public class Vertex {
    private int x;
    private int y;
    int[] coordinate = new int[2];
    private String label;
    private char letter;

    // Constructor
    public Vertex(int x, int y, char letter){
        this.x = x;
        this.y = y;
        coordinate[0] = this.x;
        coordinate[1] = this.y;
        this.label = letter + "(" + x + ", " + y + ")";
    }

    // Accessor
    public int[] getCoordinate(){
        return coordinate;
    }
    public String getLabel(){
        return this.label;
    }

    // Mutator
    public void setCoordinate(int x, int y){
        this.x = x;
        this.y = y;
        this.coordinate[0] = x;
        this.coordinate[1] = y;
    }
}
