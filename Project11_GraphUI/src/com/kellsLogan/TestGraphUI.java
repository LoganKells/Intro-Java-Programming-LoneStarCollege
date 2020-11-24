package com.kellsLogan;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** This class will display the graph in a UI. See the readme.md for more details of what this does.
 * Based on and inspired by Introduction to Java_11th Edition_Liang, Y. Daniel Listing 28.6 GraphView.java*/
public class TestGraphUI extends Application {

    @Override
    public void start(Stage primaryStage){
        // Create an arraylist graph
        ArrayList<Vertex> testGraph = new ArrayList<Vertex>();

        // Add vertices to the graph
        testGraph.add(new Vertex(0,0, 'A'));
        testGraph.add(new Vertex(90, 60, 'B'));
        testGraph.add(new Vertex(30, 50, 'C'));
        testGraph.add(new Vertex(-100, 200, 'D'));
        testGraph.add(new Vertex(-50, -150, 'E'));
        testGraph.add(new Vertex(-130, -100, 'F'));

        primaryStage.setTitle("Display of Graph Vertices");
        primaryStage.setScene(new Scene(new GraphUI(testGraph), 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args){
        System.out.println("Generating Graph UI in JavaFX Borderpane");
        launch(args);
        System.out.println("Closing program...");
    }
}
