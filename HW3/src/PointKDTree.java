import java.util.ArrayList;
import java.util.List;

/*
A KD point contains
Characteristic X-Coordinate: Point2D.X
Characteristic Y-Coordinate: Point2D.Y
Splitting axis: r
Left pointer: Left
Right pointer: Right
 */
// r = (r+1) mod n, where n stands for the number of dimensions
// Recursion solution
public class PointKDTree implements SetOfPoints{

  private KDNode<Point2D> root = null;
  private int axis = -1;
  private int count = 0;

  public PointKDTree(List<Point2D> points){
    if (points.isEmpty()){
      throw new IllegalArgumentException("The points list cannot be empty.");
    } else {
      this.root = this.buildKDTree(points, 0); // Start from depth 0 build the tree.
      this.count = points.size();
      // System.out.println(this.root.Left.data.get(0) + " " + this.root.Left.data.get(1));
    }
  }

  /**
   * Wrap the given Point2D pt as KD-Node and add it to the KD-Tree
   * @param pt Point2D type object to be added in pSet
   */

  /*
    depth || axis
    _____________
    |  0  ||  X  |
    |  1  ||  Y  |
    |  2  ||  X  |
    |  3  ||  Y  |
    |  4  ||  X  |
    |  5  ||  Y  |
     */
  @Override
  public void add(Point2D pt) {
    // ZERO and even depth compare x-axis value, odd depth compare y-axis value
    KDNode<Point2D> ptr = this.root; // create a pointer points to the root
    int depth = 0;
    boolean flag = true;
    while (flag){
      if (depth % 2 == 0){ // even depth
        if (ptr.data.get(0) < pt.get(0)){ // pt's x value >= the node ptr points to
          if (ptr.Right == null){
            // if node ptr points to does not have a right child, then add pt as its right child
            System.out.println("X, Right, add");
            System.out.println("X: " + ptr.data.get(0) + " Y: "+ ptr.data.get(1));
            ptr.Right = new KDNode<>(pt);
            this.count += 1;
            flag = false;
          } else {
            System.out.println("X, Right");
            System.out.println("X: " + ptr.data.get(0) + " Y: "+ ptr.data.get(1));
            ptr = ptr.Right;
            depth += 1;
          }
        } else {
          if (ptr.Left == null){
            // if node ptr points to does not have a right child, then add pt as its right child
            System.out.println("X, Left, add");
            System.out.println("X: " + ptr.data.get(0) + " Y: "+ ptr.data.get(1));
            ptr.Left = new KDNode<>(pt);
            this.count += 1;
            flag = false;
          } else {
            System.out.println("X, Left");
            System.out.println("X: " + ptr.data.get(0) + " Y: "+ ptr.data.get(1));
            ptr = ptr.Left;
            depth += 1;
          }
        }
      } else { // odd depth
        if (ptr.data.get(1) < pt.get(1)){ // pt's x value >= the node ptr points to
          if (ptr.Right == null){
            // if node ptr points to does not have a right child, then add pt as its right child
            System.out.println("Y, Right, add");
            System.out.println("X: " + ptr.data.get(0) + " Y: "+ ptr.data.get(1));
            ptr.Right = new KDNode<>(pt);
            this.count += 1;
            flag = false;
          } else {
            System.out.println("Y, Right");
            System.out.println("X: " + ptr.data.get(0) + " Y: "+ ptr.data.get(1));
            ptr = ptr.Right;
            depth += 1;
          }
        } else {
          if (ptr.Left == null){
            // if node ptr points to does not have a right child, then add pt as its right child
            System.out.println("Y, Left, add");
            System.out.println("X: " + ptr.data.get(0) + " Y: "+ ptr.data.get(1));
            ptr.Left = new KDNode<>(pt);
            this.count += 1;
            flag = false;
          } else {
            System.out.println("Y, Left");
            System.out.println("X: " + ptr.data.get(0) + " Y: "+ ptr.data.get(1));
            ptr = ptr.Left;
            depth += 1;
          }
        }
      }
    }
  }

  /**
   * Pre-order traverse the KD-Tree and get the Point2D objects inside
   * @return a Point2D List object contains all the points
   */
  @Override
  public List<Point2D> getPoints() {
    List<Point2D> points = new ArrayList<>();
    this.getPointsPreOrder(this.root, points);
    return points;
  }

  /**
   *  Pre-order traverse the KD-Tree and get the Point2D objects within the circle derived from
   *  the given center and radius
   * @param center A point2D object stands for the center of the circle
   * @param radius A double variable stands for the radius of the circle
   * @return List object within the circle
   */
  @Override
  public List<Point2D> allPointsWithinCircle(Point2D center, double radius) {
    List<Point2D> points = new ArrayList<>();
    this.getPointsCircle(this.root, points, center, radius);
    return points;
  }

  /**
   * Pre-order traverse the KD-Tree and get the Point2D object with the smallest distance to
   * given Point2D object pt
   * @param pt A Point2D object need to find its closest point
   * @return Point2D object contains the closest point
   */
  @Override
  public Point2D closestPoint(Point2D pt) {
    //System.out.println("result: " + nearestPoint.get(0) + " " + nearestPoint.get(1));
    return this.getClosestPoint(this.root, pt, 0, this.root.data);
  }

  /**
   *
   * @param points Given Point2D List object contains points to build the KD-Tree
   * @param depth int val stands for the current depth
   * @return KDNode object stands for the root node of the newly built KD-Tree
   */
  private KDNode<Point2D> buildKDTree(List<Point2D> points, int depth) {
    if (points.isEmpty()) {
      return null;
    }

    if (this.axis == -1){
      double varX, varY; // vars for x/y-axis variance
      double[] temp;
      temp = new double[points.size()];
      // calculate the variance of X and Y axis, start from the axis with a larger variance
      for (int i = 0; i < points.size(); i++) { temp[i] = points.get(i).get(0); }
      varX = Util.POP_Variance(temp);
      temp = new double[points.size()];
      for (int i = 0; i < points.size(); i++) { temp[i] = points.get(i).get(1); }
      varY = Util.POP_Variance(temp);
      if (varX > varY){ // start form an axis with larger variance at the first time
        this.axis = 0; // start from x-axis first (1 is y-axis)
      } else {
        this.axis = 1; // start from y-axis first (0 is x-axis)
      }
    }
    if (this.axis >= 0){
      int THRESHOLD = 2;
      this.axis = depth % THRESHOLD; }

    // Sort points based on current axis
    if (this.axis == 0) {
      Util.sortByX(points);
    } else {
      Util.sortByY(points);
    }

    // Find median and create node
    int medianIndex = points.size() / 2;
    KDNode<Point2D> node = new KDNode<>(Util.Median(points));
    //System.out.println("Med" + node.data.get(0) + " " + node.data.get(1));
    List<Point2D> leftPoints = points.subList(0, medianIndex); // Left Branch: subList does not
    //for (Point2D pt: leftPoints) {System.out.println(pt.get(0) + " " + pt.get(1));}
    //System.out.println("=========================");
    // contain the mid-point
    List<Point2D> rightPoints = points.subList(medianIndex + 1, points.size()); // Right branch
    //for (Point2D pt: rightPoints) {System.out.println(pt.get(0) + " " + pt.get(1));}
    // Recursive calls for left and right subtrees
    node.Left = buildKDTree(leftPoints, depth + 1);
    node.Right = buildKDTree(rightPoints, depth + 1);

    return node;
  }

  /**
   * Helper function for getPoints()
   * @param node KDNode object stands for start node of pre-order traversal
   * @param points List object to receive the traversed points
   */
  private void getPointsPreOrder(KDNode<Point2D> node, List<Point2D> points){
    if (node != null) {
      points.add(node.data);
      getPointsPreOrder(node.Left, points);
      getPointsPreOrder(node.Right, points);
    }
  }

  /**
   * Add Point2D object from a KDNode to Point2D list if it is in the circle derived from center
   * with given radius
   * @param node KDNode object stands for start node of pre-order traversal
   * @param points List object within the circle
   * @param center center of the given circle
   * @param radius radius of the given circle
   */
  private void getPointsCircle(KDNode<Point2D> node, List<Point2D> points, Point2D center,
                               double radius){
    if (node != null) {
      if (node.data.distance(center) <= radius){
        points.add(node.data);
      }
      getPointsCircle(node.Left, points, center, radius);
      getPointsCircle(node.Right, points, center, radius);
    }
  }

  /**
   * Recursive method to find the closest point to a given point in a KD-Tree.
   *
   * @param node the root node of the KD-Tree
   * @param pt the point for which the closest point is to be found
   * @param depth the current depth of the KD-Tree
   * @param currentNode the current closest point to the given point
   * @return the closest point to the given point
   */

  private Point2D getClosestPoint(KDNode<Point2D> node, Point2D pt, int depth, Point2D currentNode){
    if (node == null) {return currentNode;}
    if (node.data.distance(pt) < currentNode.distance(pt)){
      currentNode = node.data;
      System.out.println("renew current node");
      System.out.println("renewed" + currentNode.get(0) + " " + currentNode.get(1));
    }

    int axis = depth % 2;
    // decides the direction of search
    boolean direction = (axis == 0) ? node.data.get(0) > pt.get(0) : node.data.get(1) > pt.get(1);
    // distance between p and split axis
    double axisDistance = axis == 0 ? Math.abs(pt.get(0) - node.data.get(0)) : Math.abs(pt.get(1) - node.data.get(1));

    currentNode = getClosestPoint((direction) ? node.Left : node.Right, pt, depth+1, currentNode);

    if (axisDistance < currentNode.distance(pt)) {
      currentNode = getClosestPoint(direction ? node.Right : node.Left, pt, depth + 1, currentNode);
      System.out.println("axis distance");
    }

    System.out.println(currentNode.get(0) + " " + currentNode.get(1));
    return currentNode;
  }

}
