package com.Exercise_22_08;
import java.util.ArrayList;

// Created by: Logan Kells
// Date: 10/9/2020

public class TestPrimeNumbers {
    public static void main(String[] args){
        // Note: An integer greater than 1 is prime if its only positive divisor is 1 or itself.
        // For example, 2, 3, 5, and 7 are prime numbers, but 4, 6, 8, and 9 are not.

        // Create an ArrayList of PrimeNumber objects to check if they are prime
        ArrayList<PrimeNumber> numbers = new ArrayList<>();
        for(int i=1; i<1010;i++){
            PrimeNumber currNumber = new PrimeNumber(i);
            numbers.add(currNumber);
        }
        // Test each PrimeNumber object to set the prime status true/false.
        for(PrimeNumber num : numbers){
            num.setIsPrime(testIsPrime(num.getNumber(), num.getNumber()-1));
            System.out.println(num.getNumber() + " prime status: " + num.getIsPrime());
        }
    }

    /**
     * This function will return true if n is prime or false if it is not prime.
     * @param n number to be tested for being prime
     * @param divisor initial divisor, should be set to n-1
     * @return boolean true/false if n is a prime number
     */
    public static boolean testIsPrime(int n, int divisor){
        if(divisor > 1){
            // Final state
            if(n % divisor == 0){
                return false;
            }
            else {
                divisor -= 1;
                // Recursive call to the test
                return testIsPrime(n, divisor);
            }
        }
        // Final state
        return true;
    }
}
