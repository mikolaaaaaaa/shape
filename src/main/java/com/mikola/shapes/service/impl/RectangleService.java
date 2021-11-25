package com.mikola.shapes.service;

import com.mikola.shapes.entity.Point;
import com.mikola.shapes.entity.Rectangle;
import com.mikola.shapes.exception.RectangleException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleService implements ShapeService {
    private static final Logger logger = LogManager.getLogger(RectangleService.class);
    private Rectangle rectangle;
    private final List<Point> points;

    public RectangleService() {
        points = new ArrayList<>();
    }

    public RectangleService(Rectangle rectangle) throws RectangleException {
        if (rectangle == null) {
            logger.log(Level.WARN, "Given rectangle is null");
            throw new RectangleException("Given rectangle is null");
        }

        this.rectangle = rectangle;
        this.points = new ArrayList<>(rectangle.getPoints());
        Collections.sort(points);
    }
    private boolean isParallelism(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) throws RectangleException {
        if (firstPoint == null || secondPoint == null || thirdPoint == null || fourthPoint == null) {
            logger.log(Level.WARN, "Given point's is null");
            throw new RectangleException("Point's isn't valid");
        }

        double threshold = 1e-10;
        Point ab = new Point(secondPoint.getX() - firstPoint.getX(), secondPoint.getY() - firstPoint.getY());
        Point cd = new Point(thirdPoint.getX() - fourthPoint.getX(), thirdPoint.getY() - fourthPoint.getY());
        return (Math.abs(ab.getX() * cd.getY() - ab.getY() * cd.getX()) < threshold);
    }
    @Override
    public double calculateSqare() throws RectangleException {
        double sqare = PointService.calculateDistance(points.get(0), points.get(1))
                * PointService.calculateDistance(points.get(0), points.get(2));

        logger.log(Level.DEBUG,"Sqare of rectangle #{} is {}",rectangle.getId(),sqare);

        return sqare;
    }
    @Override
    public double calculatePerimeter() throws RectangleException {
        double perimetr = 2 * (PointService.calculateDistance(points.get(0), points.get(1))
                + PointService.calculateDistance(points.get(0), points.get(2)));

        logger.log(Level.DEBUG,"Perimetn of rectangle #{} is {}",rectangle.getId(),perimetr);

        return perimetr;
    }

    @Override
    public boolean isRectangle() throws RectangleException {
        boolean ac = (isParallelism(points.get(0), points.get(1), points.get(2), points.get(3))
                && (PointService.calculateDistance(points.get(0), points.get(1))
                == PointService.calculateDistance(points.get(2), points.get(3))));
        boolean bd = (isParallelism(points.get(1), points.get(3), points.get(0), points.get(2))
                && (PointService.calculateDistance(points.get(1), points.get(3))
                == PointService.calculateDistance(points.get(0), points.get(2))));
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

    @Override
    public boolean isConvexQuadrilateral() {
        return (!(checkPointLocation(points.get(0), points.get(1), points.get(2), points.get(3))
                || checkPointLocation(points.get(1), points.get(3), points.get(2), points.get(0))
                || checkPointLocation(points.get(2), points.get(3), points.get(0), points.get(1))
                || checkPointLocation(points.get(0), points.get(2), points.get(1), points.get(3))));
    }

    @Override
    public boolean isRhombus() throws RectangleException {
        return ((PointService.calculateDistance(points.get(2), points.get(0))
                == PointService.calculateDistance(points.get(3), points.get(2)))
                && (PointService.calculateDistance(points.get(2), points.get(0))
                == PointService.calculateDistance(points.get(3), points.get(1)))
                && (PointService.calculateDistance(points.get(2), points.get(0))
                == PointService.calculateDistance(points.get(1), points.get(0))));
    }

    @Override
    public boolean isQuad() throws RectangleException {

        boolean ac = (isParallelism(points.get(0), points.get(1), points.get(2), points.get(3))
                && (PointService.calculateDistance(points.get(0), points.get(1))
                == PointService.calculateDistance(points.get(2), points.get(3))));

        boolean bd = (isParallelism(points.get(1), points.get(3), points.get(0), points.get(2))
                && (PointService.calculateDistance(points.get(1), points.get(3))
                == PointService.calculateDistance(points.get(0), points.get(2))));

        boolean equalSides = (PointService.calculateDistance(points.get(0), points.get(1))
                == PointService.calculateDistance(points.get(2), points.get(3))
                && PointService.calculateDistance(points.get(0), points.get(1))
                == PointService.calculateDistance(points.get(1), points.get(3))
                && PointService.calculateDistance(points.get(0), points.get(1))
                == PointService.calculateDistance(points.get(0), points.get(2)));

        return (ac && bd && equalSides);
    }

    @Override
    public boolean isTrapeze() {
        double threshold = 1e-10;
        // a - 1, б - 2, с - 4, д - 3
        Point ab = new Point(points.get(1).getX() - points.get(0).getX(),
                points.get(1).getY() - points.get(0).getY());
        Point cd = new Point(points.get(2).getX() - points.get(3).getX(),
                points.get(2).getY() - points.get(3).getY());
        boolean abcd = (ab.getX() * cd.getY() - ab.getY() * cd.getX() < threshold);
        Point bc = new Point(points.get(3).getX() - points.get(1).getX(),
                points.get(3).getY() - points.get(1).getY());
        Point ad = new Point(points.get(2).getX() - points.get(0).getX(),
                points.get(2).getY() - points.get(0).getY());
        boolean bcad = (bc.getX() * ad.getY() - bc.getY() * ad.getX() < threshold);
        return ((abcd && !bcad) || (!abcd && !bcad));
    }

}
