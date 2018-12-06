import org.junit.Test;
import week2.assignment.RandomizedQueue;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/*
how do we even test this?
 */

public class RandomizedQueueTest {

    @Test
    public void test_creation() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.size());
    }

    @Test
    public void test_dequeue() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        int size = queue.size();
        Integer value = queue.dequeue();
        assertEquals(--size, queue.size());
    }

    @Test
    public void test_iterator() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        Iterator<Integer> iterator = queue.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            i++;
            System.out.println(iterator.next());
        }
        assertEquals(10, i);

    }

    @Test
    public void test_sample() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 11; i++) {
            queue.sample();
        }

    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_iterator_remove() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.iterator().remove();

    }
}
