package com.mikola.shapes.creator;

import com.mikola.shapes.creator.RectangleFactory;
import com.mikola.shapes.entity.Point;
import com.mikola.shapes.entity.Rectangle;
import com.mikola.shapes.exception.RectangleException;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleFactoryTest {


    @Test
    public void testCreateRectangleList() throws RectangleException {
         List<double[]> doubleList = List.of(
                 new double[]{1,1,1,4,4,1,4,4},
                 new double[]{2,1,2,4,4,1,4,4}
         );
        List<Point> firstPoints = List.of(
                new Point(1, 1),
                new Point(1, 4),
                new Point(4, 1),
                new Point(4, 4)
        );
        List<Point> secondPoints = List.of(
                new Point(2, 1),
                new Point(2, 4),
                new Point(4, 1),
                new Point(4, 4)
        );
        List<Rectangle> expected = List.of(
                new Rectangle(firstPoints),
                new Rectangle(secondPoints)
        );
        List<Rectangle> actualy = RectangleFactory.createRectangleList(doubleList);
        assertEquals(expected,actualy);

    }

    @Test
    public void testCreateReatangle() throws RectangleException {
        List<Point> points = List.of(
                new Point(1, 1),
                new Point(1, 4),
                new Point(4, 1),
                new Point(4, 4)
        );
        double[] doubleArray = {1, 1, 1, 4, 4, 1, 4, 4};

        Rectangle actual = RectangleFactory.createRectangle(doubleArray);
        Rectangle expected = new Rectangle(points);
        assertEquals(actual, expected);
    }

}
