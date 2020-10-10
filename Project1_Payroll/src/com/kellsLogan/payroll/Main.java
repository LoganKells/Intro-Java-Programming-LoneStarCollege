package com.kellsLogan.payroll;
import java.util.Scanner;

// Created by: Logan Kells
// Date: 9/7/2020

/*In this assignment, you are to create a class named Payroll.

In the class, you are to have the following data members:
name: String
id: String
hours: int
rate: double
private members

You are to create no-arg and parameterized constructors and the appropriate setters(accessors) and getters (mutators).

The class definition should also handle the following exceptions:

An employee name should not be empty, otherwise an exception should be thrown.
An employee id should have the form LLNNNN.  If that form is not received, an exception should be thrown.
An employee's hours should neither be negative nor greater than 84.  An exception should be thrown otherwise.
An employee's pay rate should neither be negative nor greater than 25.00. An exception should be thrown otherwise.
Demonstrate this class in a program (separate class or in the same class).

The exception messages should be appropriate to the specific exception that has occurred.

Create package com.lastnameFirstname.payroll for the project.
*/

public class Main {
    public static void main(String[] args){
        // Prompt the user to enter values.
        System.out.println("Enter Name: ");
        // Use Scanner class to create an object "userInput" to read input from System.in
        Scanner userInput = new Scanner(System.in);
        String name = userInput.nextLine();
        System.out.println("Enter ID:");
        String id = userInput.nextLine();
        System.out.println("Enter Hours:");
        int hours = userInput.nextInt();
        System.out.println("Enter Rate:");
        double rate = userInput.nextDouble();
        // Create a new Payroll object for the user to store data
        Payroll newUser = new Payroll(name, id, hours, rate);
        // Test the inputs and send the exception to the console. Count the number of errors.
        int countErrors = newUser.testUser();
        // Print the results.
        newUser.printUser();
    }
}
