import org.junit.Test;

import week3.assignment.Point;
import static org.junit.Assert.assertEquals;

public class PointTest {
    @Test
    public void test_compareTo() {
        Point p = new Point(3, 3);
        assertEquals(-1, p.compareTo(new Point(3, 5)));
        assertEquals(-1, p.compareTo(new Point(5, 3)));
        assertEquals(0, p.compareTo(new Point(3, 3)));
        assertEquals(1, p.compareTo(new Point(3, 2)));
        assertEquals(1, p.compareTo(new Point(2, 3)));
    }

    @Test
    public void test_slopeTo() {
        Point p = new Point(1, 6);
        assertEquals(-2.0D, p.slopeTo(new Point(3, 2)), 0D);
        assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(new Point(1, 2)), 0D);
        assertEquals(+0.0D, p.slopeTo(new Point(3, 6)), 0D);
        assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(new Point(1, 6)), 0D);
    }
}
