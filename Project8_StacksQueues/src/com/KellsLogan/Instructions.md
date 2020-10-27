# Lone Star College
## Project 8 (Week 9) Stacks, Queues, and Files
* COSC-2436 2801 1
* Created by: Logan Kells
* Date: 10/26/2020
### Instructions

You are to write a program that gives its users three basic options: 
reverse, convert, and compare.  

The program should ask the user to input the file name for the file in question (including the extension, .txt).  

If the user selects reverse:
 * The program should open the text file and read its content into a stack of characters. 
 * The program should then pop the characters from the top of the stack and save them in a second text file.  
 * The order in the second file should be the reverse of the order in the first file.  

If the user selects convert:
* The program should open a text file and read its content into a queue of characters.  
* The program should then dequeue the characters, convert it to uppercase, and store it in a second file.

If the user selects compare:
* The program asks the user for two files and should then open the two text files and 
read their contents into two separate queues.
* The program should determine if the files are identical by comparing characters in the queues.  
* When two nonidentical characters are encountered, the program should display a message indicating that the files are not the same.  Otherwise, let the user know that the files are identical.

You should use your own test files to make sure the program performs as specified, 
but you do not have to include them in your submission.  

You are at liberty to ask the user for the file name to be examined.