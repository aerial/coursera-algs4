package week1.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private int openCount = 0;
    private boolean[] openedSites;
    private final WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        weightedQuickUnionUF = new WeightedQuickUnionUF((n*n)+2);
        this.n = n;
        this.openedSites = new boolean[n*n];
        for (int i = 0; i < openedSites.length; i++) {
            openedSites[i] = false;
        }
    }

    public void open(int row, int col) {
        if (row <= 0 || col <= 0 || col > n || row > n)
            throw new IllegalArgumentException();
        int currentIndex = translateToSingleRow(row, col);
        if (!openedSites[currentIndex]) {
            openedSites[currentIndex] = true;
            openCount++;
            // left
            if (col > 1 && openedSites[currentIndex] && openedSites[translateToSingleRow(row, col - 1)]) {
                weightedQuickUnionUF.union(currentIndex, translateToSingleRow(row, col - 1));
            }
            // right
            if (col < n && openedSites[currentIndex] && openedSites[translateToSingleRow(row, col + 1)]) {
                weightedQuickUnionUF.union(currentIndex, translateToSingleRow(row, col + 1));
            }
            // top
            if (row > 1 && openedSites[currentIndex] && openedSites[translateToSingleRow(row - 1, col)]) {
                weightedQuickUnionUF.union(currentIndex, translateToSingleRow(row - 1, col));
            }
            // bottom
            if (row < n && openedSites[currentIndex] && openedSites[translateToSingleRow(row + 1, col)]) {
                weightedQuickUnionUF.union(currentIndex, translateToSingleRow(row + 1, col));
            }
            // top virtual point
            if (row == 1) {
                weightedQuickUnionUF.union(currentIndex, (n*n));
            }
            // bottom virtual point
            if (row == n) {
                weightedQuickUnionUF.union(currentIndex, (n*n)+1);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row <= 0 || col <= 0 || col > n || row > n)
            throw new IllegalArgumentException();
        return openedSites[translateToSingleRow(row, col)];
    }

    public boolean isFull(int row, int col) {
        if (row <= 0 || col <= 0 || col > n || row > n) throw new IllegalArgumentException();
        return weightedQuickUnionUF.connected(
                translateToSingleRow(row, col), n*n);
    }

    public int numberOfOpenSites() {
        return openCount;
    }

    private int translateToSingleRow(int row, int col) {
        if (row <= 0 || col <= 0 || col > n || row > n) throw new IllegalArgumentException();
        return (n*(row-1) + col)-1;
    }

    public boolean percolates() {
        return weightedQuickUnionUF.connected(n*n, (n*n)+1);
    }
}
