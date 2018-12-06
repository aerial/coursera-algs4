package week2.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueueListInvalid<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    class Node<T> {
        public Node<T> next;
        private T value;

        public Node(T item) {
            this.value = item;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    public RandomizedQueueListInvalid() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("addFirst argument can not be null");
        }
        Node<T> oldLast = last;
        last = new Node<T>(item);
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;

        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int r = randomEntry();

        Node<T> currentNode = first;
        T value = first.getValue();
        if (r == 1) {
            if (size > 1) {
                first = first.next;
            } else {
                first = null;
            }
        } else {
            for (int i = 1; i < r - 1; i++) {
                currentNode = currentNode.next;
            }
             value = currentNode.value;
            if (currentNode.next != null) {
                currentNode.next = currentNode.next.next;
            }

        }
        size--;
        return value;

    }


    public T sample() {
        int r = randomEntry();
        Node<T> currentNode = first;
        for (int i = 1; i < r - 1; i++) {
//            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T value = (T) current.getValue();
                    current = current.next;
                    return value;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("removing  not supported");
            }
        };
    }

    public int randomEntry()
    {
        int range = size;
        return (int)(Math.random() * range) + 1;
    }


}
