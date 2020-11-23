package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList lst = new ImmutableLinkedList();

    public Stack(){

    }
    public Object peek(){
        if (this.lst.isEmpty()){
            return null;
        }
        return this.lst.getLast();
    }
    public Object pop(){
        if (this.lst.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        Object popped = this.lst.getLast();
        this.lst = this.lst.removeLast();
        return popped;
    }
    public void push(Object e){
        this.lst = this.lst.addLast(e);
    }
    
}
