package com.mikola.shapes.entity;

import java.util.Objects;


public class Point implements Comparable<Point>{

    private double x;
    private double y;

    public Point(Point point) {}

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Point{")
                .append("x=").append(x)
                .append(", y=").append(y)
                .append('}');
        return result.toString();
    }

    @Override
    public int compareTo(Point o) {
        if (Double.compare(this.x,o.getX()) != 0) {
           return Double.compare(this.x,o.getX());
        }
        else {
            return Double.compare(this.y,o.getY());
        }
    }
}
