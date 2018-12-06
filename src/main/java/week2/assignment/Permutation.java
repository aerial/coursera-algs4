package week2.assignment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Permutation {
    public static void main(String[] args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Supply a command line argument");
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> strings = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            strings.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(strings.dequeue());
        }
    }
}
