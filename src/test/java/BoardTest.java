import org.junit.Test;
import week4.assignment.Board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    @Test
    public void test_tostring() {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        assertEquals("1 2 3\n4 5 6\n7 8 0\n", board.toString());
    }

    @Test
    public void test_is_goal() {
        Board goalBoard = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        assertTrue(goalBoard.isGoal());
        Board notGoalBoard = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {8, 7, 0}});
        assertFalse(notGoalBoard.isGoal());
    }

    @Test
    public void test_hamming() {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        assertEquals(0, board.hamming());
        board.moves++;
        assertEquals(1, board.hamming());

        board = new Board(new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}});
        assertEquals(5, board.hamming());
        Board notGoalBoard = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {8, 7, 0}});
        assertEquals(2, notGoalBoard.hamming());
        notGoalBoard.moves++;
        assertEquals(3, notGoalBoard.hamming());
    }

    @Test
    public void test_manhattan() {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        assertEquals(0, board.manhattan());
        Board notGoalBoard = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {8, 7, 0}});
        assertEquals(2, notGoalBoard.manhattan());
        board = new Board(new int[][]{{8, 1, 3}, {4, 0, 2}, {7, 6, 5}});
        assertEquals(10, board.manhattan());
    }

    @Test
    public void test_twin() {
        Board board = new Board(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
        assertEquals("0 2 3\n4 5 6\n7 8 1\n", board.twin().toString());
    }

    @Test
    public void test_neighbors() {
        Board board = new Board(new int[][]{{2, 0, 3}, {4, 5, 6}, {7, 8, 1}});
        board.neighbors();
    }
}
