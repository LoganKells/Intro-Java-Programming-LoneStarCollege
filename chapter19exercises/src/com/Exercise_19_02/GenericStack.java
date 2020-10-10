package com.Exercise_19_02;
import java.util.ArrayList;

public class GenericStack<E> {
    // NOTE: This is based on Listing 19.1 in the book.

    // Create a generic ArrayList
    ArrayList<E> list = new ArrayList<>();

    public int getSize(){
        return list.size();
    }

    public E peek(){
        // Peek the last item in the list.
        return list.get(getSize()-1);
    }

    public void push(E item){
        // Push an item to the end of the list.
        list.add(item);
    }

    public E pop(){
        E lastItem = list.get(getSize() - 1); // save the last element temporarily.
        list.remove(getSize() - 1); // delete the last element in the list.
        return lastItem;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return "stack: " + list.toString();
    }

}
