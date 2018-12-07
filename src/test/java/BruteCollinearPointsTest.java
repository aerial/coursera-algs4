import org.junit.Test;
import week3.assignment.BruteCollinearPoints;
import week3.assignment.Point;

import static org.junit.Assert.assertEquals;

public class BruteCollinearPointsTest {

    @Test
    public void test_colinear_points() {
        Point[] points = new Point[] {new Point(0, 1), new Point(0, 2), new Point(0, 3), new Point(0, 4)};
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
        assertEquals("(0, 1) -> (0, 4)", bruteCollinearPoints.segments()[0].toString());
        assertEquals(1, bruteCollinearPoints.numberOfSegments());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_null_points() {
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_null_point() {
        Point[] points = new Point[] {new Point(0, 0), null, new Point(1, 1), new Point(2, 2), new Point(3, 3)};
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_duplicates() {
        Point[] points = new Point[] {new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(3, 3)};
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
    }

}
