package com.Exercise_11_03;

//(Subclasses of Account)
// In Programming Exercise 9.7, the Account class was defined to model a bank account. An account has the
// properties account number, balance, annual interest rate, and date created, and methods to deposit and
// with- draw funds. Create two subclasses for checking and saving accounts. A checking account has an
// overdraft limit, but a savings account cannot be overdrawn.
// Draw the UML diagram for the classes and implement them.
// Write a test program that creates objects of Account, SavingsAccount, and CheckingAccount and
// invokes their toString() methods.

public class CheckingAccount extends Account{
    private double balanceLimit = 0;

    // Try to withdraw, but check for overdraft limit
    public void withdraw(double amt){
        double newBalance = getBalance() - amt;
        // If withdrawal causes an overdraft, then print an error
        if(newBalance < balanceLimit){
            System.out.println("Withdrawal of $" + amt + " causes an overdraft of $" + newBalance);
        }
        else{
            setBalance(newBalance);
        }
    }
}
