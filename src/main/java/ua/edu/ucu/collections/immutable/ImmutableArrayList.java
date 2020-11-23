package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private Object[] array = {};
    private int size = 0;

    public ImmutableArrayList(){

    }

    public ImmutableArrayList(Object[] list) {
        this.array = list;
        this.size = list.length;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return addAll(size, new Object[]{e});
    }

    void checkIndexException(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndexException(index);
        Object[] arr = new Object[c.length + size];
        System.arraycopy(c, 0, arr, index, c.length);
        System.arraycopy(this.array, index, arr, index+c.length, size - index);
        System.arraycopy(this.array, 0, arr, 0, index);
        return new ImmutableArrayList(arr);
    }

    @Override
    public Object get(int index) {
        checkIndexException(index);
        return this.array[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndexException(index);
        Object[] arr = new Object[size-1];
        System.arraycopy(this.array, index+1, arr, index, size - (index+1));
        System.arraycopy(this.array, 0, arr, 0, index);
        return new ImmutableArrayList(arr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkIndexException(index);
        Object[] arr = new Object[size];
        System.arraycopy(this.array, index+1, arr, index+1, size - index-1);
        System.arraycopy(this.array, 0, arr, 0, index);
        arr[index] = e;
        return new ImmutableArrayList(arr);
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
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }

    @Override
    public String toString() {
        StringBuilder strng = new StringBuilder();
        strng.append(this.array[0]);
        for (int i = 1; i < this.size; i++) {
            strng.append(", ").append(this.array[i]);
        }
        return strng.toString();
    } //повертає рядок, де через кому відображаютсься елементи колекції
}
