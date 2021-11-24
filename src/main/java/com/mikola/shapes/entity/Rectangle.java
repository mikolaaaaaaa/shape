package com.mikola.shapes.entity;

import com.mikola.shapes.util.IdGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Rectangle {
    List<Point> points;
    public final int id;

    public Rectangle() {
        this.id = IdGenerator.generateId();
    }

    public Rectangle(List<Point> points) {
        this.points = points;
        this.id = IdGenerator.generateId();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, id);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Rectangle{")
                .append("points=").append(points)
                .append(", id=").append(id)
                .append('}');
        return result.toString();
    }
}
