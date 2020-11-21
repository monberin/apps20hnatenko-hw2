package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Object[] array = {};
    private int size = 0;
    private Node head;
    private Node tail;

    public ImmutableLinkedList(){

    }

    public ImmutableLinkedList(Object[] list){
        this.array = list;
        for (Object o : list) {
            Node node = new Node(o, null, null);
            if (size == 0) {
                this.head = node;
            }
            else{
                this.tail.setNext(node);
                node.setPrev(this.tail);
            }
            this.tail = node;
            size += 1;
        }
    }

    void CheckIndexException(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return addAll(size, new Object[]{e});
    }
    
    @Override
    public ImmutableLinkedList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        CheckIndexException(index-1);
        Object[] arr = new Object[c.length + size];
        System.arraycopy(c, 0, arr, index, c.length);
        System.arraycopy(this.array, index, arr, index+c.length, size - index);
        System.arraycopy(this.array, 0, arr, 0, index);
        return new ImmutableLinkedList(arr);
    }

    @Override
    public Object get(int index) {
        CheckIndexException(index);
        Node node = this.head;
        while (index > 0){
            node = node.getNext();
            index -= 1;
        }
        return node.getVal();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        CheckIndexException(index);
        Object[] arr = new Object[size-1];
        System.arraycopy(this.array, index+1, arr, index, size - (index+1));
        System.arraycopy(this.array, 0, arr, 0, index);
        return new ImmutableLinkedList(arr);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        CheckIndexException(index);
        Object[] arr = new Object[size];
        System.arraycopy(this.array, index+1, arr, index+1, size - index-1);
        System.arraycopy(this.array, 0, arr, 0, index);
        arr[index] = e;
        return new ImmutableLinkedList(arr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++){
            if (this.array[i] == e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }
}
