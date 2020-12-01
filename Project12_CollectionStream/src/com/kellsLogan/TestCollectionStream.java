package com.kellsLogan;

import java.util.ArrayList;

public class TestCollectionStream {
    public static void main(String[] args){
        // Load the data in ./resources/newStates.txt into an ArrayList<String> object
        LoadData myloader = new LoadData();
        ArrayList<String> data = new ArrayList<>();
        data = myloader.loadText();
    }
}
