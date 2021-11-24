package com.mikola.shapes.service;

import com.mikola.shapes.entity.Point;

public class PointService {

    public static double calculateDistance(Point pointOne, Point pointTwo) {
        return Math.sqrt(Math.pow(pointOne.getX() - pointTwo.getX(), 2)
                + Math.pow(pointOne.getY() - pointTwo.getY(), 2));
    }

    public static boolean isOneStraight(Point pointOne, Point pointTwo, Point pointThree) {
        double threshold = 1e-10;
        return  (Math.abs((pointThree.getX() - pointOne.getX()) / Math.abs(pointTwo.getX() - pointOne.getX())
                - Math.abs(pointThree.getY() - pointOne.getY()) / Math.abs(pointTwo.getY() - pointOne.getY())) < threshold);
    }

}
