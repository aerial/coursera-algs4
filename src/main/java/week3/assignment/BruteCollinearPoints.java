package week3.assignment;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private List<LineSegment> segmentList;

    public BruteCollinearPoints(Point[] points) {
        validatePoints(points);
        segmentList = new ArrayList<>();
        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        Arrays.sort(pointsCopy);

        for (int i = 0; i < pointsCopy.length - 3; i++) {
            for (int j = i + 1; j < pointsCopy.length - 2; j++) {
                for (int k = j + 1; k < pointsCopy.length - 1; k++) {
                    for (int l = k + 1; l < pointsCopy.length; l++) {
                        if (pointsCopy[i].slopeTo(pointsCopy[j]) == pointsCopy[i].slopeTo(pointsCopy[k]) &&
                            pointsCopy[i].slopeTo(pointsCopy[k]) == pointsCopy[i].slopeTo(pointsCopy[l])) {
                            segmentList.add(new LineSegment(pointsCopy[i], pointsCopy[l]));
                        }
                    }
                }
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
