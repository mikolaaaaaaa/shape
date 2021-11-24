package com.mikola.shapes.reader;

import com.mikola.shapes.exception.RectangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class RectangleReaderTest {
    @Test
    public void testRectangleReader() throws RectangleException, IOException {
        List<String> expected = List.of(
                "1 2 1 4 4 2 4 4",
                "1a 2 1 4 4 2 4 4",
                "1 2 1 2 1 2",
                "2 1 2 4 4 1 4 4"
        );
        List<String> actual = RectangleReader.readFile("C:\\Users\\Mikola\\IdeaProjects\\EpamShapes\\src\\main\\resources\\data.txt");
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
