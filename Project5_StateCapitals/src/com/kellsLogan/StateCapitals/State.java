package com.kellsLogan.StateCapitals;

// State.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 10/4/2020


/**
 * For this assignment you are to create a class definition for State. State should have the following attributes:
 * - abbr (String)
 * - name (String)
 * - capital (String)
 *
 * Create an appropriate set of constructors for the class as well as getters and setters for the class.
 * Note: Class creation is worth 20 points.
 */
public class State {
    // Private member variables for a State
    private String abbr, name, capital;

    // Default no-argument constructor
    public State(){
        abbr = "TBD";
        name = "TBD";
        capital = "TBD";
    }

    // Argument constructor
    public State(String abbr, String name, String capital){
        this.abbr = abbr;
        this.name = name;
        this.capital = capital;
    }

    // Getters or Accessors
    public String getAbbr(){
        return abbr;
    }
    public String getName(){
        return name;
    }
    public String getCapital(){
        return capital;
    }

    // Setters or Mutators
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCapital(String capital){
        this.capital = capital;
    }
}
