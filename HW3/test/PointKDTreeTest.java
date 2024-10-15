import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PointKDTreeTest {
  private PointKDTree kdTree;
  private List<Point2D> initialPoints;

  @Before
  public void setUp(){
    // Create a list of points
    this.initialPoints = Arrays.asList(
            new Point2D(1, 2),
            new Point2D(3, 4),
            new Point2D(5, 6),
            new Point2D(7, 8)
    );
    // Create the KDTree with initial points
    this.kdTree = new PointKDTree(new ArrayList<>(initialPoints));
  }

  @Test
  public void testAddAndGetPoints() {
    List<Point2D> pointsFromTree = this.kdTree.getPoints();
    //for (Point2D pts: pointsFromTree){System.out.println(pts.get(0) + " " + pts.get(1));}
    assertTrue(pointsFromTree.containsAll(initialPoints));
    // Add a new point
    Point2D newPoint = new Point2D(9, 10);
    this.kdTree.add(newPoint);
    pointsFromTree = this.kdTree.getPoints();
    assertTrue(pointsFromTree.contains(newPoint));
  }

  @Test
  public void testAllPointsWithinCircle() {
    Point2D center = new Point2D(4, 5);
    double radius = 3.0;
    List<Point2D> pointsWithinCircle = this.kdTree.allPointsWithinCircle(center, radius);
    List<Point2D> expectedPoints = Arrays.asList(
            new Point2D(3, 4),
            new Point2D(5, 6)
    );
    assertTrue(pointsWithinCircle.contains(expectedPoints.get(0)) && pointsWithinCircle.contains(expectedPoints.get(1)));
  }

  @Test
  public void testClosestPoint() {
    Point2D pt = new Point2D(2, 3);
    Point2D closest = this.kdTree.closestPoint(pt);
    Point2D expected = new Point2D(1, 2);
    assertEquals(expected, closest);
  }



}