package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StackTest {

    @Test
    public void testPopPeek() {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        assertEquals(1, stack.pop());
        assertEquals(2,stack.peek());
        stack.push(0);
        assertEquals(0,  stack.pop());
    }
    

}