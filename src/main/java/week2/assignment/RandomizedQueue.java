package week2.assignment;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;
    private int i;

    public RandomizedQueue() {
        items = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        assert capacity >= size;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (size == items.length) resize(2*items.length);
        items[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        i = StdRandom.uniform(size);
        Item item = items[i];
        items[i] = items[size-1];
        items[size-1] = null;
        size--;
        if (size > 0 && size == items.length/4) resize(items.length/2);
        return item;
    }


    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return items[StdRandom.uniform(size)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomArrayIterator();
    }


    private class RandomArrayIterator implements Iterator<Item> {
        private int i = 0;

        public RandomArrayIterator() {
            StdRandom.shuffle(items, 0, size);
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[i++];
        }
    }

}
