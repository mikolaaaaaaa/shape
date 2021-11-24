package com.mikola.shapes.creator;

import com.mikola.shapes.entity.Point;
import com.mikola.shapes.entity.Rectangle;
import com.mikola.shapes.exception.RectangleException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RectangleFactory {
    private static final int RIGHT_AMOUNT_OF_NUMERIC = 8;

    public static List<Rectangle> createRectangleList(List<double[]> doubleList) throws RectangleException {
        if (doubleList == null || doubleList.isEmpty()) {
            throw new RectangleException(String.format("Coordinates %s isn't valid"), "List is null or empty");
        }
        List<Rectangle> rectangles = new ArrayList<>();
        for (double[] coordinates : doubleList) {
            Rectangle rectangle = createRectangle(coordinates);
            rectangles.add(rectangle);
        }
        return rectangles;
    }

    public static Rectangle createRectangle(double[] coordinates) throws RectangleException {
        if (coordinates == null || coordinates.length != RIGHT_AMOUNT_OF_NUMERIC) {
            throw new RectangleException(String.format("Coordinates %s isn't valid", Arrays.toString(coordinates)));
        }
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < RIGHT_AMOUNT_OF_NUMERIC; i += 2) {
            Point point = new Point(coordinates[i], coordinates[i + 1]);
            points.add(point);
        }
        return new Rectangle(points);
    }

}
