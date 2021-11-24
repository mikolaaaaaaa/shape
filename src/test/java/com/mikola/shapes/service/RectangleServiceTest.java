package com.mikola.shapes.service;

import com.mikola.shapes.entity.Point;
import com.mikola.shapes.entity.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

public class RectangleServiceTest {
    Point firstPoint;
    Point secondPoint;
    Point thirdPoint;
    Point fourthPoint;
    RectangleService rectangleService;

    @BeforeEach
    public void setUp() {
        firstPoint = new Point(1,1);
        secondPoint = new Point(1,4);
        thirdPoint = new Point(4,1);
        fourthPoint = new Point(4,4);
        List<Point> points = List.of(
                firstPoint,
                secondPoint,
                thirdPoint,
                fourthPoint
        );
        rectangleService = new RectangleService(new Rectangle(points));
    }

    @Test
    public void testIsParallelism() {
        Assertions.assertTrue(rectangleService.isParallelism(
                firstPoint,
                secondPoint,
                thirdPoint,
                fourthPoint
        ));
    }

    @Test
    public void testIsRectangle() {
        Assertions.assertTrue(rectangleService.isRectangle());
    }

    @Test
    public void testIsConvexQuadrilateral() {
        Assertions.assertTrue(rectangleService.isConvexQuadrilateral());
    }

    @Test
    public void testCalculateSqare() {
        double expected = 9;
        Assertions.assertEquals(expected,rectangleService.calculateSqare());
    }

    @Test
    public void testcalculatePerimetr() {
        double expected = 12;
        Assertions.assertEquals(expected,rectangleService.calculatePerimeter());
    }

    @Test
    public void testIsRhombus() {
        Assertions.assertTrue(rectangleService.isRhombus());
    }

    @Test
    public void testIsQuad() {
        Assertions.assertTrue(rectangleService.isQuad());
    }

    @Test
    public void testIsTrapeze() {
        secondPoint.setX(2);
        secondPoint.setY(3);
        thirdPoint.setX(3);
        thirdPoint.setY(3);
        List<Point> points = List.of(
                firstPoint,
                secondPoint,
                thirdPoint,
                fourthPoint
        );
        rectangleService = new RectangleService(new Rectangle(points));
        Assertions.assertTrue(rectangleService.isTrapeze());
    }
}
