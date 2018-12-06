import org.junit.Test;
import week2.assignment.Deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DequeTest {

    private Deque addFirstNItems(Deque<Integer> deque, int n) {
        for (int i = 1; i <= n; i++) {
            deque.addFirst(i);
        }
        return deque;
    }

    private Deque addLastNItems(Deque<Integer> deque, int n) {
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        return deque;
    }

    @Test
    public void test_creation_add_first() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        addFirstNItems(deque, 3);
        assertEquals(deque.size(), 3);
    }

    @Test
    public void test_creation_add_last() {
        Deque<Integer> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        addLastNItems(deque, 3);
        assertEquals(deque.size(), 3);
    }

    @Test(expected = NoSuchElementException.class)
    public void test_first_nosuchelement_exception() {
        Deque<Integer> deque = new Deque<>();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void test_last_nosuchelement_exception() {
        Deque<Integer> deque = new Deque<>();
        deque.removeLast();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_add_last_nullargument_exception() {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_add_first_nullargument_exception() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_iterators_exception() {
        Deque<Integer> deque = new Deque<>();
        deque.iterator().remove();
    }



    @Test
    public void test_first_elements_addition_and_removal() {
        Deque<Integer> deque = new Deque<>();
        addFirstNItems(deque, 4);
        assertEquals(new Integer(4), deque.removeFirst());
        assertEquals(3, deque.size());
        assertEquals(new Integer(3), deque.removeFirst());
        assertEquals(2, deque.size());
        assertEquals(new Integer(2), deque.removeFirst());
        assertEquals(1, deque.size());
        assertEquals(new Integer(1), deque.removeFirst());
        assertTrue(deque.isEmpty());
    }


    @Test
    public void test_last_elements_addition_last_removal() {
        Deque<Integer> deque = new Deque<>();
        addLastNItems(deque, 4);
        assertEquals(new Integer(4), deque.removeLast());
        assertEquals(3, deque.size());
        assertEquals(new Integer(3), deque.removeLast());
        assertEquals(2, deque.size());
        assertEquals(new Integer(2), deque.removeLast());
        assertEquals(1, deque.size());
        assertEquals(new Integer(1), deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void test_first_elements_addition_last_removal() {
        Deque<Integer> deque = new Deque<>();
        addFirstNItems(deque, 4);
        assertEquals(new Integer(1), deque.removeLast());
        assertEquals(3, deque.size());
        assertEquals(new Integer(2), deque.removeLast());
        assertEquals(2, deque.size());
        assertEquals(new Integer(3), deque.removeLast());
        assertEquals(1, deque.size());
        assertEquals(new Integer(4), deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void test_last_elements_addition_first_removal() {
        Deque<Integer> deque = new Deque<>();
        addLastNItems(deque, 4);
        assertEquals(new Integer(1), deque.removeFirst());
        assertEquals(3, deque.size());
        assertEquals(new Integer(2), deque.removeFirst());
        assertEquals(2, deque.size());
        assertEquals(new Integer(3), deque.removeFirst());
        assertEquals(1, deque.size());
        assertEquals(new Integer(4), deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void test_first_elements_addition_first_removal() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        assertEquals(new Integer(2), deque.removeFirst());
        assertEquals(new Integer(1), deque.removeFirst());
        assertEquals(new Integer(3), deque.removeFirst());
        assertEquals(new Integer(4), deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void test_iterator() {
        Deque<Integer> deque = new Deque<>();
        addFirstNItems(deque, 4);
        int i = 0;
        Integer[] ar = new Integer[] {4, 3, 2, 1};
        for (Integer aDeque : deque) {
            assertEquals(ar[i++], aDeque);
        }

    }
}
