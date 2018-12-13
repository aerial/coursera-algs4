package week4.assignment;

import edu.princeton.cs.algs4.Stack;

public class Board {

    public Board predecessor;
    private final static Board goal;
    private final int[][] blocks;
    public int moves;

    static {
        goal = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
    }

    public Board(int[][] blocks) {
        validate(blocks);
        this.blocks = blocks;
        this.moves = 0;
    }

    public int dimension() {
        return blocks[0].length;
    }

    public int hamming() {
        if (isGoal()) return 0;
        return blocksInWrongPosition() + moves;
    }

    public int manhattan() {
        if(isGoal()) return 0;
        int sum = 0;
        for (int i = 0; i < blocks[0].length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                for (int x = 0; x < blocks[0].length; x ++) {
                    for (int y = 0; y < blocks[0].length; y++) {
                        if (goal.blocks[i][j] != 0 && (goal.blocks[i][j] == blocks[x][y])) {
                            sum+=Math.abs(i - x); sum+=Math.abs(j - y);
                        }
                    }
                }
            }
        }
        return sum + moves;
    }

    public boolean isGoal() {
        return this.equals(goal);
    }

    public Board twin() {
        return swapElements(0, 0, dimension() - 1, dimension() - 1);
    }

    public Board swapElements(int i, int j, int x, int y) {
        int[][] twin = new int[dimension()][dimension()];
        for (int k = 0; k < blocks[0].length; k++) {
            for (int m = 0; m < blocks[0].length; m++) {
                twin[k][m] = blocks[k][m];
            }
        }
        int swap = twin[i][j];
        twin[i][j] = twin[x][y];
        twin[x][y] = swap;
        return new Board(twin);
    }


    public Iterable<Board> neighbors() {
        Stack<Board> stack = new Stack<>();
        int x = 0;
        int y = 0;
        //find zero
        for (int i = 0; i < blocks[0].length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                if (blocks[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
        }
        if (x > 0) {
            stack.push(this.swapElements(x - 1, y, x, y));
        }
        if (y > 0) {
            stack.push(this.swapElements(x, y - 1, x, y));
        }
        if (x < dimension() - 1) {
            stack.push(this.swapElements(x + 1, y, x, y));
        }
        if (y < dimension() - 1) {
            stack.push(this.swapElements(x, y + 1, x, y));
        }
        return stack;
    }

    private void validate(int [][] blocks) {
        if (blocks == null) throw new IllegalArgumentException("Board blocks can not be null");
    }

    private int blocksInWrongPosition() {
        int count = 0;
        for (int i = 0; i < blocks[0].length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                if ((blocks[i][j] != goal.blocks[i][j]) && goal.blocks[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return this.toString().equals(board.toString()); //hehe
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < blocks[0].length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                b.append(blocks[i][j]);
                if (j < blocks.length - 1) b.append(" ");
            }
            b.append("\n");
        }
        return b.toString();
    }
}
