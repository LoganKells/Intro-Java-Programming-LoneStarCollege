package com.KellsLogan;

// NOTE: This generic Stack is based on listing 19.1 in "Introduction to Java Programming and Data Structures, Comprehensive Version, 11th Edition, Y. Daniel Liang"

public class Stack<E> {
    // A stack can be viewed as a special type of list whose elements are accessed, inserted, and deleted
    // only from the end (top), as shown in Figure 10.11.



    // Create a generic array using the restriction for Array generics detailed on Page 787 in the book.
    E[] arrList = (E[])new Object[2]; // from page 787
    private int cursor = 0;

    // ********************* Accessors *********************
    public int getSize(){
        return arrList.length;
    }
    public E getElement(int i){
        return arrList[i];
    }

    // ********************* Mutators *********************
    public void setCursor(int cursor){
        this.cursor = cursor;
    }

    // Push a new value
    public void push(E element){
        // Check the array length & double the size of the array if needed.
        if(cursor >= arrList.length){
            doubleSize();
        }
        // Add new element
        arrList[cursor] = element;
        cursor += 1;
    }

    // Pop the top of the stack
    public E pop(){
        cursor -= 1;
        if(cursor >= 0){
            E element = arrList[cursor];
            arrList[cursor] = null;
            return element;
        }
        else{
            return null;
        }
    }

    // Double the array size
    public void doubleSize(){
        // Create a new list that is 2x the size of the original list
        E[] newList = (E[])new Object[arrList.length * 2];
        System.arraycopy(arrList, 0, newList, 0, arrList.length);
        arrList = newList;
    }
}
