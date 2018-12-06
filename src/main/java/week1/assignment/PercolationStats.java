package week1.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_96 = 1.96;

    private final double[] estimates;
    private final int n;
    private int trialsCount = 0;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        this.n = n;
        estimates = new double[trials];
        for (int i = 0; i < trials; i++) {
            estimates[i] = performTrial();
        }
    }

    public double mean() {
        return StdStats.mean(estimates);
    }

    public double stddev() {
        return StdStats.stddev(estimates);
    }

    public double confidenceLo() {
        return mean() - ((CONFIDENCE_96 * stddev()) / Math.sqrt(trialsCount));
    }

    public double confidenceHi() {
        return mean() + ((CONFIDENCE_96 * stddev()) / Math.sqrt(trialsCount));
    }

    private double performTrial() {
        Percolation percolation = new Percolation(n);
        int toOpenRow = 0;
        int toOpenColumn = 0;
        do {
            toOpenRow = StdRandom.uniform(1, n+1);
            toOpenColumn = StdRandom.uniform(1, n+1);
            if (!percolation.isOpen(toOpenRow, toOpenColumn)) {
                percolation.open(toOpenRow, toOpenColumn);
            }
        } while (!percolation.percolates());
        double estimate = (double) percolation.numberOfOpenSites() / (n*n);
        trialsCount++;
        return estimate;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);
        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}
