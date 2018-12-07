package week3.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private List<LineSegment> segmentList;

    public FastCollinearPoints(Point[] points) {
        validatePoints(points);
        segmentList = new ArrayList<>();
        Point[] pointsCopy = Arrays.copyOf(points, points.length);
    }

    public int numberOfSegments() {
        return segmentList.size();
    }

    public LineSegment[] segments() {
        return segmentList.toArray(new LineSegment[segmentList.size()]);
    }

    private void validatePoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Supply points array");
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException("Point " + i + " is null");
        }
        for (int i = 0; i < points.length; i++) {
            //check points duplicates
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicate items " + i + " " + j);
                }
            }
        }
    }
}
