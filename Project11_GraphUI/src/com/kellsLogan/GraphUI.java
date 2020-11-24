package com.kellsLogan;

import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.ArrayList;

/** This class will display the graph in a UI. See the readme.md for more details of what this does.
 * Based on and inspired by Introduction to Java_11th Edition_Liang, Y. Daniel Listing 28.6 GraphView.java*/
public class GraphUI extends BorderPane {
    //private Graph myGraph;
    private ArrayList<Vertex> myGraph;
    private Group group = new Group();

    // Constructor
    public GraphUI(ArrayList<Vertex> myGraph){
        this.setCenter(group); // Used to center the javaFX.scene.layout.BorderPane around the group.
        this.myGraph = myGraph;
        repaintGraph();
    }

    // Mutators
    private void repaintGraph(){
        // Clear the group for a new display
        group.getChildren().clear();

        // Draw the vertices
        for (Vertex vertex : myGraph) {
            // Get the current vertex's (x,y) coordinate
            int[] currCoordinate = vertex.getCoordinate();
            int x = currCoordinate[0];
            int y = currCoordinate[1];
            String currLabel = vertex.getLabel();

            // Draw the current vertex in the javafx.scene.group
            group.getChildren().add(new Circle(x, y, 2));
            group.getChildren().add(new Text(x-8, y+18, currLabel));

            // Draw lines in the UI which represent edges.
            for (Vertex value : myGraph) {
                // This graph has rays from 0,0 coordinate.
                int xStart = 0;
                int yStart = 0;
                // Determine end points
                int[] currEndCoordinate = value.getCoordinate();
                int xEnd = currEndCoordinate[0];
                int yEnd = currEndCoordinate[1];
                // Draw the line from (xStart, yStart) to (xEnd, yEnd)
                group.getChildren().add(new Line(xStart, yStart, xEnd, yEnd));
            }
        }
    }
}
