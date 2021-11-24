package com.mikola.shapes.reader;

import com.mikola.shapes.exception.RectangleException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RectangleReader {
       public static  List<String> readFile(String path) throws IOException, RectangleException {
           if (path == null || path.isEmpty()) {
               throw new RectangleException(String.format("Coordinates %s isn't valid"), String.format("File name %s if null or empty",path));
           }
           List<String> doubleStringList;
           Path dataFile = Paths.get(path);
           Stream<String> dataStream = Files.lines(dataFile);
           doubleStringList = dataStream.collect(Collectors.toList());
           return doubleStringList;
       }
}
