package com.Exercise_11_03;

public class TestAccounts{
    public static void main(String[] args){

        // Create a checking account
        CheckingAccount currCheckAcc = new CheckingAccount();
        // Set the account number
        currCheckAcc.setAccountNumber(123450009);
        // Set the balance
        currCheckAcc.setBalance(1305);
        // Set the rate
        currCheckAcc.setAnnualInterestRate(0.001);
        // Set the start date
        currCheckAcc.setStartDate("1/1/2012");

        // Withdraw money
        currCheckAcc.withdraw(1306);

        // Print the account
        System.out.print(currCheckAcc.printAccount());
    }
}
