package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
public class Queue {
    private ImmutableLinkedList lst = new ImmutableLinkedList();
    public Queue(){
    }

    public Object peek(){
        if (this.lst.isEmpty()){
            return null;
        }
        return this.lst.getFirst();

    } //- Returns the object at the beginning of the Queue without removing it
    public Object dequeue(){
        if (this.lst.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        Object dequeued = this.lst.getFirst();
        this.lst = this.lst.removeFirst();
        return dequeued;
    } //- Removes and returns the object at the beginning of the Queue.
    void enqueue(Object e){
        this.lst = this.lst.addLast(e);
    } //- Adds an object to the end of the Queue.


}
