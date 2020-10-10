package com.kellsLogan.payroll;

// Created by: Logan Kells
// Date: 9/7/2020

public class Payroll {
    // private member variables
    private String name;
    private String id;
    private int hours;
    private Double rate;
    private int errorCount;

    // No argument constructor
    Payroll(){
        name = "Name not Entered";
        id = "ID Not entered.";
        hours = 0;
        rate = 0.0;
        errorCount = 0;
    }
    // Parameter constructor
    Payroll(String newName, String newID, int hours_, Double rate_){
        name = newName;
        id = newID;
        hours = hours_;
        rate = rate_;
        errorCount = 0;
    }

    // Getters for retrieving private member variables
    String getName(){
        return name;
    }
    String getID(){
        return id;
    }
    int getHours(){
        return hours;
    }
    double getRate(){
        return rate;
    }

    // Setters for defining member variable values.
    void setName(String name_){
        name = name_;
    }
    void setHours(int hours_){
        hours = hours_;
    }
    void setID(String id_){
        id = id_;
    }
    void setRate(double rate_){
        rate = rate_;
    }

    public int testUser(){
        // testUser() method will run all the tests & print exceptions to the console.
            // An employee name should not be empty, otherwise an exception should be thrown.
            // An employee id should have the form LLNNNN.  If that form is not received, an exception should be thrown.
            // An employee's hours should neither be negative nor greater than 84.  An exception should be thrown otherwise.
            // An employee's pay rate should neither be negative nor greater than 25.00. An exception should be thrown otherwise.
            // Demonstrate this class in a program (separate class or in the same class).
            // The exception messages should be appropriate to the specific exception that has occurred.
        // Check that the name is not empty
        if(name.isEmpty()){
            System.out.println("Name cannot be empty.");
            errorCount++;
        }

        // Check that the length = 5 digits.
        if(id.length() != 5){
            System.out.println("ID must be 5 items long.");
            errorCount++;
        }
        else{
            for(int i = 0; i < id.length(); i++){
                // Check that the first 2 elements in the ID are letters.
                if((i < 2) && !(java.lang.Character.isLetter(id.charAt(i)))){
                    System.out.println("Index " + i + " is not char.");
                    errorCount++;
                }
                // Check that the last three elements in the ID are digits.
                else if(i >= 2 && !(java.lang.Character.isDigit(id.charAt(i)))){
                    System.out.println("Index " + i + " is not digit.");
                    errorCount++;
                }
            }
        }
        // Hours cannot be above 84 hours or negative.
        if(hours > 84 || hours < 0){
            System.out.println("Hours must be between 0-84.");
            errorCount++;
        }
        // Rate should not be above 25.0 or negative.
        if(rate > 25.0 || rate < 0){
            System.out.println("Rate must be between 0.0-25.0.");
            errorCount++;
        }
        return errorCount;
    }

    public void printUser(){
        // printUser() method will print the user information IF there are not any errors in the format.
        if(errorCount > 0){
            System.out.println("There were " + errorCount + " Error(s)!");
            System.exit(0);
        }
        else{
            System.out.println("Payroll User Information Entered...");
            System.out.println("Name: " + name + '\n' + "ID: " + id + '\n' + "Hours: " + hours + '\n' + "Rate: "+ rate);
        }
    }
}
