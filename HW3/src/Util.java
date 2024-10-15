import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Util {
  public static double Sum(double[] data) {
    double sum = 0;
    for (double datum : data) sum = sum + datum;
    return sum;
  }

  public static double Mean(double[] data) {
    double mean = 0;
    mean = Sum(data) / data.length;
    return mean;
  }

  // population variance 总体方差
  public static double POP_Variance(double[] data) {
    double variance = 0;
    for (double datum : data) {
      variance = variance + (Math.pow((datum - Mean(data)), 2));
    }
    variance = variance / data.length;
    return variance;
  }

  public static double SAMPLE_Variance(double[] data) {
    double variance = 0;
    for (double datum : data) {
      variance = variance + (Math.pow((datum - Mean(data)), 2));
    }
    variance = variance / (data.length - 1);
    return variance;
  }

  public static double StandardDeviation(double[] data) {
    double variance = SAMPLE_Variance(data);
    return Math.sqrt(variance);
  }
  public static Point2D Median(List<Point2D> data) {
    int middle = data.size() / 2;
    return data.get(middle);
  }

  public static void sortByX(List<Point2D> temp) {
    temp.sort(new Comparator<Point2D>() {
      @Override
      public int compare(Point2D p1, Point2D p2) {
        return Integer.compare(p1.x, p2.x);
      }
    });
  }

  public static void sortByY(List<Point2D> temp) {
    temp.sort(new Comparator<Point2D>() {
      @Override
      public int compare(Point2D p1, Point2D p2) {
        return Integer.compare(p1.y, p2.y);
      }
    });
  }

  public static void split(){

  }

}
