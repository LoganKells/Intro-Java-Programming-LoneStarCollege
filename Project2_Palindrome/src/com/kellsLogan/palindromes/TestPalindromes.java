package com.kellsLogan.palindromes;

// TestPalindromes.java
// Created by: Logan Kells
// Date: 9/13/2020

// Instructions:
// A palindrome is a group of characters that read the same forward or backwards.
// The goal of this assignment is to write a recursive method that detects whether
// the String parameter is receives is a palindrome or not.
// The method should be a boolean-returning method called isPalindrome.
// This method should be demonstrated in a main method. The program package should be called palindromes.

// ------- Tested results -----
// test cases: String[] testStrings = { "mom", "Palindromes go here", "racecar", "repaper", "rotator", "holiday", "I", ""};
// "mom" is a palindrome.
//"Palindromes go here" is a palindrome.
//"racecar" is a palindrome.
//"repaper" is a palindrome.
//"rotator" is a palindrome.
//"holiday" is a palindrome.
//"I" is not a palindrome.
//"" is not a palindrome.

public class TestPalindromes {
    public static void main(String[] args){
        // Create an array of strings to test.

        String[] testStrings = { "mom", "Palindromes go here", "racecar", "repaper", "rotator", "holiday", "I", ""};

        // Test the strings using a foreach loop to print the test string one at a time
        for(String str: testStrings){
            Palindromes currPal = new Palindromes(str);
            // Use the isPalindrome() method to print the results of the test.
            if(currPal.isPalindrome()){
                System.out.print("\"" + currPal.getString() + "\" is a palindrome.\n");
            }
            else{
                System.out.print("\"" + currPal.getString() + "\" is not a palindrome.\n");
            }
        }
    }
}
