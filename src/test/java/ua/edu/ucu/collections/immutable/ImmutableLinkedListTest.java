package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testArrayListFromList() {
        Integer[] arr = {0, 10, -5, 2};
        ImmutableLinkedList ImmutableLinkedList = new ImmutableLinkedList(arr);
        assertEquals(ImmutableLinkedList.get(0),0);
        assertEquals(ImmutableLinkedList.get(1), 10);
        assertEquals(ImmutableLinkedList.get(2),-5);
        assertEquals(ImmutableLinkedList.get(3), 2);

    }

    @Test
    public void testAdd() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.add(3);
        assertEquals(3, (int) newArr.get(4));
    }

    @Test
    public void testAddIndex() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.add(1,3);
        assertEquals(3, (int) newArr.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexException() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.add(10,3);
    }

    @Test
    public void testAddAll() {
        Integer[] array = {0, 10, -5, 2};
        Integer[] c = {4,0,2,7};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.addAll(c);
        assertEquals(2, (int) newArr.get(6));
    }

    @Test
    public void testAddAllIndex() {
        Integer[] array = {0, 10, -5, 2};
        Integer[] c = {4,0,2,7};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.addAll(1,c);
        assertEquals(0, (int) newArr.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexException() {
        Integer[] array = {0, 10, -5, 2};
        Integer[] c = {4,0,2,7};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.add(10,3);
    }

    @Test
    public void testRemove() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.remove(2);
        assertEquals(2, (int) newArr.get(2));
    }

    @Test
    public void testSet() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.set(3, 200);
        assertEquals(200, (int) newArr.get(3));
    }

    @Test
    public void testIndexOf() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        assertEquals(-1, arr.indexOf(3));
        assertEquals(1, arr.indexOf(10));
    }

    @Test
    public void testIsEmpty() {
        ImmutableLinkedList list = new ImmutableLinkedList();

        boolean actualResult = list.isEmpty();
        assertTrue(actualResult);
    }

    @Test
    public void testToArray() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList list = new ImmutableLinkedList(array);
        Object[] newArray = list.toArray();
        assertArrayEquals(array, newArray);
    }

    @Test
    public void testGetFirst() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        Object first = arr.getFirst();
        assertEquals(0, first);
    }


    @Test
    public void testGetLast() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        Object last = arr.getLast();
        assertEquals(2, last);
    }

    @Test
    public void testAddFirst() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.addFirst(3);
        assertEquals((int) newArr.getFirst(), 3);
    }

    @Test
    public void testAddLast() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.addLast(3);
        assertEquals(3, (int) newArr.getLast());
    }

    @Test
    public void testRemoveLast() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.removeLast();
        assertEquals(-5, (int) newArr.getLast());
    }

    @Test
    public void testRemoveFirst() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.removeFirst();
        assertEquals(10, (int) newArr.get(0) );
    }

    @Test
    public void testToString() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList list = new ImmutableLinkedList(array);
        String lst = list.toString();
        assertEquals("[0, 10, -5, 2]", lst);
    }


}
