// SimpleBoxSet
/*
FIELDS
 ..this.dollars    : int
 ..this.cents    : int
 METHODS
 ..this.toString(): String
 ..this.add(Money other): Money
 ..this.add(int dollars, int cents): Money
 ..this.getDecimalValue(): double
 METHODS OF FIELDS
 ..this.center.distToOrigin(): double
 ..this.center.getX() : double
 ..this.center.getY() : double
 */
package box;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleBoxSet implements BoxSet{
  private ArrayList<ArrayList<Integer>> boxSet;

  /**
   * Constructor initialize the boxSet arrayList
   */
  public SimpleBoxSet() {
    this.boxSet = new ArrayList<ArrayList<Integer>>();
  }

  /**
   * Add the passed rectangle to existing rectangles
   * @param x the x-coordinate of the rectangle to be added
   * @param y the y-coordinate of the rectangle to be added
   * @param width the width of the rectangle to be added
   * @param height the height of the rectangle to be added
   * @throws IllegalArgumentException throw exception if width or height is negative
   */
  @Override
  public void add(int x, int y, int width, int height) throws IllegalArgumentException {
    //
    if (this.boxSet.isEmpty()) {
      if (width > 0 && height >0){
        ArrayList<Integer> result=new ArrayList<Integer>();
        result.add(x);
        result.add(y);
        result.add(width);
        result.add(height);
        this.boxSet.add(result);
      }
      else {
        throw new IllegalArgumentException("Invalid width or height");
      }
    } else {
      this.subtract(x, y, width, height); // Subtract to remove the overlap
      ArrayList<Integer> result=new ArrayList<Integer>();
      result.add(x);
      result.add(y);
      result.add(width);
      result.add(height);
      this.boxSet.add(result);
    }

  }

  /**
   * Subtract given rectangle from the rectangles in the boxSet
   * @param x the x-coordinate of the rectangle to be subtracted
   * @param y the y-coordinate of the rectangle to be subtracted
   * @param width the width of the rectangle to be subtracted
   * @param height the height of the rectangle to be subtracted
   */
  @Override
  public void subtract(int x, int y, int width, int height) {
    ArrayList<ArrayList<Integer>> newBoxes = new ArrayList<>();

    for (ArrayList<Integer> box : new ArrayList<>(this.boxSet)) {
      int boxX = box.get(0);
      int boxY = box.get(1);
      int boxWidth = box.get(2);
      int boxHeight = box.get(3);

      // Check if there is an overlap
      if (!(x >= boxX + boxWidth || x + width <= boxX || y >= boxY + boxHeight || y + height <= boxY)) {
        // Remove the original rectangle
        this.boxSet.remove(box);
        if (x > boxX && x + width < boxX + boxWidth && y > boxY && y + height < boxY + boxHeight){
          // if the subtracted part is in the middle, inside the current checking rectangles
          // left: (bx, by, x-bx, bh), midTop: (x, y+h, w, bh-h-y), mid_bttm: (x, by, w, y),
          // right: (x+w, by, bw-x-w, bh)
          newBoxes.add(new ArrayList<>(Arrays.asList(boxX, boxY, x-boxWidth, boxHeight))); // left
          newBoxes.add(new ArrayList<>(Arrays.asList(x+width, boxY, boxWidth-x-width, boxHeight))); // right
          newBoxes.add(new ArrayList<>(Arrays.asList(boxX, y+height, width, boxHeight-height-y))); // mid-top
          newBoxes.add(new ArrayList<>(Arrays.asList(boxX, boxY, x-boxWidth, boxHeight))); // mid-bottom
          continue; // if finish a subtraction of the middle part means there is no more top,
          // bottom, left, or right part to subtract, so continue to the next loop.
        }
        // Top part
        if (y > boxY) {
          newBoxes.add(new ArrayList<>(Arrays.asList(boxX, boxY, boxWidth, y - boxY)));
        }
        // Bottom part
        if (y + height < boxY + boxHeight) {
          newBoxes.add(new ArrayList<>(Arrays.asList(boxX, y + height, boxWidth, boxY + boxHeight - (y + height))));
        }
        // Left part
        if (x > boxX) {
          newBoxes.add(new ArrayList<>(Arrays.asList(boxX, y, x - boxX, height)));
        }
        // Right part
        if (x + width < boxX + boxWidth) {
          newBoxes.add(new ArrayList<>(Arrays.asList(x + width, y, boxX + boxWidth - (x + width), height)));
        }
      }
    }

    // Add rest of rectangles back
    this.boxSet.addAll(newBoxes);
  }

  /**
   * get the rectangles in the boxSet
   * @return an int[n][4] array contains all the rectangles
   */
  @Override
  public int[][] getBoxes() {
    int[][] boxes = new int[this.boxSet.size()][4];
    for (int i = 0; i < this.boxSet.size(); i++) {
      ArrayList<Integer> rectangle = this.boxSet.get(i);
      for (int j = 0; j < 4; j++) {
        boxes[i][j] = rectangle.get(j);
      }
    }
    return boxes;
  }

  /**
   * get the size of the current boxSet
   * @return int val stands for the size of the boxSet
   */

  @Override
  public int size() {
    return this.boxSet.size();
  }


}
