package week3.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private List<LineSegment> segmentList;

    public FastCollinearPoints(Point[] points) {
        validatePoints(points);
        segmentList = new ArrayList<>();
        Point[] pointsCopy = points.clone();
        Arrays.sort(pointsCopy);
        for (int i = 0; i < pointsCopy.length - 3; i++) {
            Arrays.sort(pointsCopy);
            Arrays.sort(pointsCopy, pointsCopy[i].slopeOrder());
            for (int j = 0, first = 1, last = 2; last < pointsCopy.length; last++) {
                while (last < pointsCopy.length
                        && Double.compare(pointsCopy[j].slopeTo(pointsCopy[first]),
                        pointsCopy[j].slopeTo(pointsCopy[last])) == 0) { last++; }
                if (last - first >= 3 && pointsCopy[j].compareTo(pointsCopy[first]) < 0) {
                    segmentList.add(new LineSegment(pointsCopy[j], pointsCopy[last - 1]));
                }
                first = last;
            }
        }
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
