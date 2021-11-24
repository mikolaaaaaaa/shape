package com.mikola.shapes.service;

import com.mikola.shapes.entity.Point;
import com.mikola.shapes.entity.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleService {
    private Rectangle rectangle;
    private final List<Point> points;

    public RectangleService() {
        points = new ArrayList<>();
    }

    public RectangleService(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.points = new ArrayList<>(rectangle.getPoints());
        Collections.sort(points);
    }

    private void setPoint() {

    }

    public boolean isParallelism(Point point1, Point point2, Point point3, Point point4) {
        double threshold = 1e-10;
        Point ab = new Point(point2.getX() - point1.getX(),point2.getY()-point1.getY());
        Point cd = new Point(point3.getX() - point4.getX(),point3.getY()-point4.getY());
        return (Math.abs(ab.getX()*cd.getY() - ab.getY()*cd.getX()) < threshold);
    }

    public double calculateSqare() {
        return (PointService.calculateDistance(points.get(0), points.get(1))
                * PointService.calculateDistance(points.get(0), points.get(2)));
    }

    public double calculatePerimeter() {
        return (2 * PointService.calculateDistance(points.get(0), points.get(1))
                + 2 * PointService.calculateDistance(points.get(0), points.get(2)));
    }

    public boolean isRectangle() {
        boolean ac = (isParallelism(points.get(0),points.get(1),points.get(2),points.get(3))
                && (PointService.calculateDistance(points.get(0),points.get(1))
                == PointService.calculateDistance(points.get(2),points.get(3))));
        boolean bd = (isParallelism(points.get(1),points.get(3),points.get(0),points.get(2))
                && (PointService.calculateDistance(points.get(1),points.get(3))
                == PointService.calculateDistance(points.get(0),points.get(2))));
        return (ac && bd);
    }

    private double getD(Point pount1, Point point2, Point point3) {
        return ((point3.getX() - pount1.getX()) * (point2.getY() - pount1.getY())
                - (point3.getY() - pount1.getY()) * (point2.getX() - pount1.getX()));
    }

    private boolean checkPointLocation(Point point1, Point point2, Point point3, Point point4) {
        double d1, d2;
        d1 = getD(point1, point2, point3);
        d2 = getD(point1, point2, point4);
        return ((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0));
    }

    public boolean isConvexQuadrilateral() {
        return (!(checkPointLocation(points.get(0), points.get(1), points.get(2), points.get(3))
                || checkPointLocation(points.get(1), points.get(3), points.get(2), points.get(0))
                || checkPointLocation(points.get(2), points.get(3), points.get(0), points.get(1))
                || checkPointLocation(points.get(0), points.get(2), points.get(1), points.get(3))));
    }

    public boolean isRhombus() {
        return ((PointService.calculateDistance(points.get(2), points.get(0))
                == PointService.calculateDistance(points.get(3), points.get(2)))
                && (PointService.calculateDistance(points.get(2), points.get(0))
                == PointService.calculateDistance(points.get(3), points.get(1)))
                && (PointService.calculateDistance(points.get(2), points.get(0))
                == PointService.calculateDistance(points.get(1), points.get(0))));
    }

    public boolean isQuad() {

        boolean ac = (isParallelism(points.get(0),points.get(1),points.get(2),points.get(3))
                && (PointService.calculateDistance(points.get(0),points.get(1))
                == PointService.calculateDistance(points.get(2),points.get(3))));

        boolean bd = (isParallelism(points.get(1),points.get(3),points.get(0),points.get(2))
                && (PointService.calculateDistance(points.get(1),points.get(3))
                == PointService.calculateDistance(points.get(0),points.get(2))));

        boolean equalSides = (PointService.calculateDistance(points.get(0),points.get(1))
                == PointService.calculateDistance(points.get(2),points.get(3))
                && PointService.calculateDistance(points.get(0),points.get(1))
                == PointService.calculateDistance(points.get(1),points.get(3))
                && PointService.calculateDistance(points.get(0),points.get(1))
                == PointService.calculateDistance(points.get(0),points.get(2)));

        return (ac && bd && equalSides);
    }

    public boolean isTrapeze() {
        double threshold = 1e-10;
        // a - 1, б - 2, с - 4, д - 3
        Point ab = new Point(points.get(1).getX() - points.get(0).getX(),
                points.get(1).getY()-points.get(0).getY());
        Point cd = new Point(points.get(2).getX() - points.get(3).getX(),
                points.get(2).getY()-points.get(3).getY());
        boolean abcd = (ab.getX()*cd.getY() - ab.getY()*cd.getX() < threshold);
        Point bc = new Point(points.get(3).getX() - points.get(1).getX(),
                points.get(3).getY()-points.get(1).getY());
        Point ad = new Point(points.get(2).getX() - points.get(0).getX(),
                points.get(2).getY()-points.get(0).getY());
        boolean bcad = (bc.getX()*ad.getY() - bc.getY()*ad.getX() < threshold);
        return ((abcd && !bcad) || (!abcd && !bcad));
    }

}
