package com.kellsLogan.palindromes;

// Palindromes.java
// Created by: Logan Kells
// Date: 9/13/2020

// Instructions:
// A palindrome is a group of characters that read the same forward or backwards.
// The goal of this assignment is to write a recursive method that detects whether
// the String parameter is receives is a palindrome or not.
// The method should be a boolean-returning method called isPalindrome.
// This method should be demonstrated in a main method. The program package should be called palindromes.

public class Palindromes {
    private String text;
    private String originText; // used for saving original text.
    private Boolean palFlag; // flag for whether this is a palindrome or not. Initialized as false.

    // Default no argument constructor
    public Palindromes() {
        this.text = "";
        this.originText = "";
        this.palFlag = false;
    }

    // Argument constructor
    public Palindromes(String text_) {
        this.text = text_;
        this.originText = text_;
        this.palFlag = false;
    }

    // Accessors
    public String getString(){
        return originText;
    }

    // Recursive method to determine if the string is a palindrome
    public boolean isPalindrome(){
        // ----NOTE------
        // This recursive function will determine the string is a palindrome if the length is 1 char or if the string is empty
        // if we only use the base case: if (text.length() < 2)
        // Therefore I've introduced additional checks for empty strings and strings whose original length is 1 character.
        // These two cases are not considered palindromes in my book!
        if(originText.isEmpty()){
            palFlag = false;
            return false;
        }
        else if(originText.length() == 1){
            palFlag = false;
            return false;
        }
        else {
            // Base Case: if the string length < 2 then boolean is set to true.
            if (text.length() < 2) {
                palFlag = true;
            }
            // Recursively call the isPalindome() method with the string reduced by 1 on left and right.
            // Eventually a true palindrome will set palFlag = true using the base case if the len<2.
            else if (text.charAt(0) == text.charAt(text.length() - 1)) {
                text = text.substring(1, (text.length() - 1));
                palFlag = isPalindrome();
            }
            return true;
        }
    }
}
// Sample provided by professor
    /*
    public boolean isPalindrome(){
        The isPalindrome method determines whether a string is a palindrome.
        @param str The string to test.
        @return This method returns true if str contains a
        palindrome. It returns false otherwise.

        // This recursive method takes a string and returns boolean
        isPalindrome(String){
            // set boolean variable to false
            // if the string length <= 1 then boolean is set to true
            // else if the charAt(0) is equal to the last character
            // set boolean variable equal to isPalindrome(the new substring (1, str.length()-1)
            // return boolean variable
            return true;
        }
    }
    */
