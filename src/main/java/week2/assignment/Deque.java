package week2.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node<Item> {
        public Node<Item> next;
        public Node<Item> previous;
        private Item value;

        public Node(Item item) {
            this.value = item;
        }

        public void setValue(Item value) {
            this.value = value;
        }

        public Item getValue() {
            return value;
        }
    }

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    public Deque() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("addFirst argument can not be null");
        }
        if (isEmpty()) {
            addIfEmpty(item);
        } else {
            Node<Item> node = new Node<>(item);
            node.next = first;
            first = node;
            first.next.previous = first;
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("addFirst argument can not be null");
        }
        if (isEmpty()) {
            addIfEmpty(item);
        } else {
            Node<Item> node = new Node<>(item);
            last.next = node;
            node.previous = last;
            last = node;
            last.next = null;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Node<Item> result = first;
        if (size > 1) {
            first = first.next;
            first.previous = null;
        } else {
            first = null;
            last = null;
        }
        size--;
        return result.getValue();
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Node<Item> result = last;
        if (size > 1) {
            last.previous.next = null;
            last = last.previous;
        } else {
            last = null;
            first = null;
        }
        size--;
        return result.getValue();
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node<Item> current;

        public DequeIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("collection is empty");
            Item value = (Item) current.getValue();
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("removing not supported");
        }
    }

    private void addIfEmpty(Item item) {
        if (isEmpty()) {
            first = new Node<>(item);
            first.next = null;
            first.previous = null;
            last = first;
        }
    }
}
