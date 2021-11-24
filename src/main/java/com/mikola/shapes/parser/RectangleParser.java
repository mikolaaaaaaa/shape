package com.mikola.shapes.parser;

import com.mikola.shapes.exception.RectangleException;
import com.mikola.shapes.validator.RectangleValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RectangleParser {
    public static List<double[]> parseListStringToArrayPoint(List<String> doubleStringList) throws RectangleException {
        if (doubleStringList == null || doubleStringList.size() == 0) {
            throw new RectangleException(String.format("Coordinates %s isn't valid"), "List is null or empty");
        }
        List<double[]> doubleList;
        try {
            doubleList = doubleStringList.stream()
                    .map(String::trim)
                    .filter(RectangleValidator::checkInputString)
                    .map(line -> ((String) line).split(" "))
                    .map(array -> Stream.of(array)
                            .mapToDouble(Double::parseDouble)
                            .toArray())
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RectangleException("Parsing isn't successful", e);
        }
        return doubleList;
    }
}