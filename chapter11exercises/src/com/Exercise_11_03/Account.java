package com.Exercise_11_03;

//(Subclasses of Account)
// In Programming Exercise 9.7, the Account class was defined to model a bank account. An account has the
// properties account number, balance, annual interest rate, and date created, and methods to deposit and
// with- draw funds. Create two subclasses for checking and saving accounts. A checking account has an
// overdraft limit, but a savings account cannot be overdrawn.
// Draw the UML diagram for the classes and implement them.
// Write a test program that creates objects of Account, SavingsAccount, and CheckingAccount and
// invokes their toString() methods.

// Account Class requirements:
//■■ A private double data field named annualInterestRate that stores the current interest rate (default 0).
// Assume that all accounts have the same interest rate.
//■■ A private Date data field named dateCreated that stores the date when the
//account was created.
//■■ A no-arg constructor that creates a default account.
//■■ A constructor that creates an account with the specified id and initial balance.
//■■ The accessor and mutator methods for id,balance,and annualInterestRate.
//■■ The accessor method for dateCreated.
//■■ A method named getMonthlyInterestRate() that returns the monthly
//interest rate.
//■■ A method named getMonthlyInterest() that returns the monthly interest.
//■■ A method named withdraw that withdraws a specified amount from the
//account.
//■■ A method named deposit that deposits a specified amount to the account.
//Draw the UML diagram for the class then implement the class.
// (Hint: The method getMonthlyInterest() is to return monthly interest, not the interest rate.
// Monthly interest is balance * monthlyInterestRate. monthly Interest Rate is annualInterestRate / 12.
// Note annualInterestRate is a percentage, for example 4.5%. You need to divide it by 100.
//Write a test program that creates an Account object with an account ID of 1122, a balance of $20,000,
// and an annual interest rate of 4.5%. Use the withdraw method to withdraw $2,500, use the deposit method
// to deposit $3,000, and print the balance, the monthly interest, and the date when this account was created.

public class Account {
    // Attributes
    private double accountNumber, balance, annualInterestRate;
    private String startDate;

    // Default no args constructor
    public Account(){
        this.accountNumber = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.startDate = "1/1/1900";
    }

    // Args constructor
    public Account(double accountNumber, double balance, double annualInterestRate, String startDate){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.startDate = startDate;
    }

    // Accessors
    public double getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public String getStartDate(){
        return startDate;
    }

    // Mutators
    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setStartDate(String date){
        this.startDate = date;
    }
    public void setAnnualInterestRate(double r){
        this.annualInterestRate = r;
    }

    // Deposit funds method
    public void deposit(double amt){
        if(amt > 0) {
            balance += amt;
        }
    }

    // Withdraw funds method
    //public void withdraw(double amt){
    //    if(amt > 0){
    //        balance -= amt;
    //    }
    //}

    // Get monthly interest rate
    public double getMonthlyInterest(){
        return balance * (annualInterestRate / 12);
    }

    // Print balance, the monthly interest, and the date when this account was created.
    public String printAccount(){
        String details = "Account Balance: $" + balance + "\nMonthly Interest: $" + getMonthlyInterest() + "\nAccount Created: " + startDate;
        return details;
    }
}
