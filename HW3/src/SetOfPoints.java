import java.util.*;
public interface SetOfPoints {
  public final Set <Point2D> pSet = new HashSet<>();

  /**
   * Add a Point2D object pt to pSet if pt is not in pSet
   * @param pt Point2D type object to be added in pSet
   */
  public void add(Point2D pt);

  /**
   * Return all the Point2D points in pSet as a List object
   * @return A List object contains all point2D objects in pSet
   */
  public List<Point2D> getPoints();

  /**
   * Return all point2D objects in the area of the circle with the given center/radius as a List
   * @param center A point2D object stands for the center of the circle
   * @param radius A double variable stands for the radius of the circle
   * @return A List object contains all point2D objects with their coordinates in given circle
   */
  public List<Point2D> allPointsWithinCircle(Point2D center, double radius);

  /**
   * Return the closet Point2D object to the given Point2D pt
   * @param pt A Point2D object need to find its closest point
   * @return A Point2D object for found, else null
   */
  public Point2D closestPoint(Point2D pt);
}
