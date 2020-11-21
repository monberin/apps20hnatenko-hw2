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
        assertEquals((int) newArr.get(4), 3);
    }

    @Test
    public void testAddIndex() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.add(1,3);
        assertEquals((int) newArr.get(1), 3);
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
        assertEquals((int) newArr.get(6), 2);
    }

    @Test
    public void testAddAllIndex() {
        Integer[] array = {0, 10, -5, 2};
        Integer[] c = {4,0,2,7};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.addAll(1,c);
        assertEquals((int) newArr.get(2), 0);
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
        assertEquals((int) newArr.get(2), 2);
    }

    @Test
    public void testSet() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        ImmutableLinkedList newArr = arr.set(3, 200);
        assertEquals((int) newArr.get(3), 200);
    }

    @Test
    public void testIndexOf() {
        Integer[] array = {0, 10, -5, 2};
        ImmutableLinkedList arr = new ImmutableLinkedList(array);
        assertEquals(arr.indexOf(3), -1);
        assertEquals(arr.indexOf(10), 1);
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

}
