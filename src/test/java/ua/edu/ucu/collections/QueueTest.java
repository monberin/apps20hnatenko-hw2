package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class QueueTest {


    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);

        assertEquals(3, (int) queue.peek());
        queue.enqueue(0);
        assertEquals(3,  (int) queue.peek());
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue();
        queue.enqueue("came first");
        queue.enqueue("came second");
        queue.enqueue("came third");
        assertEquals("came first",  queue.dequeue());
        assertEquals("came second", queue.dequeue());
    }

}