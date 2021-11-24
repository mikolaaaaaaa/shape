package com.mikola.shapes.validator;

import com.mikola.shapes.entity.Point;
import com.mikola.shapes.entity.Rectangle;

public class RectangleValidator {
    private static final String VALID_CHARACTERS = "[0-9.0 -]+";
    private static final String SPACE_DELIMITER_REGEX = "\\s+";
    private static final int VALID_COUNT_OF_NUMERIC = 8;
    private RectangleValidator() {

    }

    public static boolean isRectanglePossible(Rectangle rectangle) {
        Point pointA = new Point(rectangle.getPoints().get(0));
        Point pointB = new Point(rectangle.getPoints().get(1));
        Point pointC = new Point(rectangle.getPoints().get(2));
        Point pointD = new Point(rectangle.getPoints().get(3));
        return true;
    }

    public static boolean isRectanglePossible(Point pointA, Point pointB, Point pointC) {
        return ((pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY()) -
                (pointC.getY() - pointA.getY()) * (pointB.getX() - pointA.getX()) != 0);
    }

    public static boolean checkCounterOfNumeric(String inputData) {
        return inputData.split(SPACE_DELIMITER_REGEX).length == VALID_COUNT_OF_NUMERIC;
    }

    public static boolean isNumeric(String inputData) {
        return inputData.matches(VALID_CHARACTERS);
    }

    public static boolean checkInputString(String inputData) {
        return checkCounterOfNumeric(inputData) && isNumeric(inputData);
    }



}
