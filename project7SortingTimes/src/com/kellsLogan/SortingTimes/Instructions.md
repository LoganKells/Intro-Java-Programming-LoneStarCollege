# Lone Star College
## Project 7 (Week 8) Sorting Times
* COSC-2436 2801 1
* Created by: Logan Kells
* Date: 10/19/2020
### Instructions
Note: This is from Introduction to Java Programming and Data Structures, 
Comprehensive Version, 11th Edition, Y. Daniel Liang, Exercise 23.13 (Execution time for sorting).

Write a program that obtains the execution time of:
* selection sort
* bubble sort
* merge sort
* quick sort
* heap sort
* radix sort

for large input sizes 60,000, 120,000, 180,000, 240,000, 300,000, and 360,000. 
Your program should create data randomly and print a table like this:

###(Hint: You can use the following code template to obtain the execution time.)

long startTime = System.currentTimeMillis();

perform the task;

long endTime = System.currentTimeMillis();

long executionTime = endTime − startTime;

The text gives a recursive quick sort. Write a nonrecursive version in this exercise.