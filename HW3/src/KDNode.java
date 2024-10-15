public class KDNode<Point2D> {
  Point2D data;
  KDNode<Point2D> Left, Right;

  public KDNode(Point2D data){
    this.data = data;
    this.Left = null;
    this.Right = null;
  }

  public KDNode(Point2D data, KDNode<Point2D> Left, KDNode<Point2D> Right){
    this.data = data;
    this.Left = Left;
    this.Right = Right;
  }



}
