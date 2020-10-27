package com.KellsLogan;
import java.util.LinkedList;

// NOTE: This generic Queue is based on listing 24.6 in "Introduction to Java Programming and Data Structures, Comprehensive Version, 11th Edition, Y. Daniel Liang"

public class Queue<E> {
    // A queue represents a waiting list.
    // It can be viewed as a special type of list whose elements are inserted into the end (tail)
    // of the queue and are accessed and deleted from the beginning (head), as shown in Figure 24.19.

    // In this class we'll simply use the preexisting LinkedList class.
    private LinkedList<E> myList = new LinkedList<>();

    // ********************* Accessors *********************
    public int getSize(){
        return myList.size();
    }

    public E getElement(int i){
        return myList.get(i);
    }

    // ********************* Mutators *********************
    // Enqueue mutator method. The enqueue(E element) method adds an element to the tail of the queue.
    public void enqueue(E element){
        myList.add(element);
    }

    // Dequeue mutator method. The dequeue() method removes the element from the head of the queue
    public E dequeue(){
        return myList.removeFirst();
    }
}
