import org.junit.Test;
import week3.assignment.FastCollinearPoints;
import week3.assignment.Point;

import static org.junit.Assert.assertEquals;

public class FastCollinearPointsTest {

    @Test
    public void test_colinear_points() {
        Point[] points = new Point[] {new Point(0, 1), new Point(0, 2),
                                      new Point(0, 3), new Point(0, 4),
                                      new Point(0, 5), new Point(0, 6),
                                      new Point(0, 7), new Point(0, 8)};
        FastCollinearPoints bruteCollinearPoints = new FastCollinearPoints(points);
        assertEquals("(0, 1) -> (0, 8)", bruteCollinearPoints.segments()[0].toString());
        assertEquals(1, bruteCollinearPoints.numberOfSegments());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_null_points() {
        FastCollinearPoints bruteCollinearPoints = new FastCollinearPoints(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_null_point() {
        Point[] points = new Point[] {new Point(0, 0), null, new Point(1, 1),
                                      new Point(2, 2), new Point(3, 3)};
        FastCollinearPoints bruteCollinearPoints = new FastCollinearPoints(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_duplicates() {
        Point[] points = new Point[] {new Point(1, 1), new Point(1, 1),
                                      new Point(2, 2), new Point(3, 3)};
        FastCollinearPoints bruteCollinearPoints = new FastCollinearPoints(points);
    }

}
