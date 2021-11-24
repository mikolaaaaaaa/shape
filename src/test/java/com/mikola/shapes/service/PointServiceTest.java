package com.mikola.shapes.service;

import com.mikola.shapes.entity.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointServiceTest {
    @Test
    public void testCalculateDistance() {
        double expected = 2;
        double actual = PointService.calculateDistance(new Point(1,1), new Point(3,1));
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testIsOneStraight() {
        boolean actual = PointService.isOneStraight(new Point(1,1), new Point(2,2),new Point(3,3));
        Assertions.assertTrue(actual);
    }

}
