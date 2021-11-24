package com.mikola.shapes.parser;

import com.mikola.shapes.exception.RectangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

public class RectangleParserTest {
    @Test
    public void testRectangleParser() throws RectangleException {
        List<String> stringDoubleList = List.of(
                "1 1 1 4 4 1 4 4",
                "2 1 2 4 4 1 4 4"
        );
        List<double[]> expected = List.of(
                new double[]{1,1,1,4,4,1,4,4},
                new double[]{2,1,2,4,4,1,4,4}
        );
        List<double[]> actual = RectangleParser.parseListStringToArrayPoint(stringDoubleList);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());

    }
}
