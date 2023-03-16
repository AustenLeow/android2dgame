package com.example.android2dgame;

public class Utils {

    // return distance between 2d points p1 and p2
    public static double getDistanceBetweenPoints(double p1x, double p1y, double p2x, double p2y) {
        return Math.sqrt(
                Math.pow(p1x - p2x, 2) + Math.pow(p1y - p2y, 2)
        );
    }
}
