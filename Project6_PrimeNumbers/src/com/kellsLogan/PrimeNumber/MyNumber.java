package com.kellsLogan.PrimeNumber;
import java.lang.IllegalArgumentException;
import java.util.ArrayList;

// MyNumber.java
// COSC-2436 2801 1
// Created by: Logan Kells
// Date: 10/12/2020

public class MyNumber {
    ArrayList<Boolean> boolList = new ArrayList<>();
    private int number;
    private int countPrimes;

    // Constructor that defines an integer parameter to set the private integer attribute.
    public MyNumber(int number){
        if(number < 2){
            throw new IllegalArgumentException("Error. You entered " + number + ". Number entered must be 2 or greater.");
        }
        else{
            this.number = number;
            this.countPrimes = 0;
        }
    }

    // Mutators...
    // Create a setter that validates the attribute does not accept a value lower than 2 or the method will throw a IllegalArgumetException.
    // See documentation: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/IllegalArgumentException.html
    public void setNumber(int number){
        if(number < 2){
            throw new IllegalArgumentException("Error. You entered " + number + ". Number entered must be 2 or greater.");
        }
        else{
            this.number = number;
        }
    }

    // Accessors
    public int getNumber(){
        return this.number;
    }

    // Define a public method that is called isPrime() that returns a boolean and implements the Sieve of Eratosthenes method.
    // NOTE
    // Theorem 1 - Every integer which is greater than 1 can be expressed as product of primes.
    // Theorem 2 = If any integer "n" is composite, then "n" has a prime divisor less than or equal to sqrt(n)
    public boolean isPrime(){
        // Step 1: Generate a list of boolean from initialized as True of length 2 to this.number+1.
        //ArrayList<Boolean> boolList = new ArrayList<>();
        for(int i=0; i<this.number+1; i++){
            this.boolList.add(Boolean.TRUE);
        }

        // Step 2: Set the values of 0 and 1 to false. The integers 0 and 1 are not considered prime numbers.
        this.boolList.set(0, Boolean.FALSE);
        this.boolList.set(1, Boolean.FALSE);

        // Determine the integer floor value of square root of this.number (aka this.number^(1/2)).
        for(int value=2; value<=this.number; value++){
            int currLimit = value * value;
            // If the value in the sieve list is still marked as true and we're still in the bounds of this.number
            if(this.boolList.get(value) & currLimit <= this.number){
                for(int index = currLimit; index<=this.number; index+=value){
                    this.boolList.set(index, Boolean.FALSE);
                }
            }
        }
        
        // Determine if this.number is prime using the boolean list of primes.
        return this.boolList.get(this.number);
    }

    //Define a public method that is called numberOfPrimes() that returns the number of prime numbers between 2 and the private attribute value.
    public int numberOfPrimes(){
        // Reset the count to 0 each time this method is called.
        this.countPrimes = 0;

        for(boolean primeStatus : this.boolList){
            // If the index is marked as prime=True, then add 1 to the count of primes.
            if(primeStatus){
                this.countPrimes += 1;
            }
        }
        return this.countPrimes;
    }
}
