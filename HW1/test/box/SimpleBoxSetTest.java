package box;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SimpleBoxSetTest {
  private SimpleBoxSet boxSet;

  @Before
  public void setUp() {
    boxSet = new SimpleBoxSet();
  }

  @Test
  public void testAddRectangle() {
    boxSet.add(0, 0, 2, 2);
    assertEquals("Box set should have 1 rectangle after adding.", 1, boxSet.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddRectangleWithInvalidDimensions() {
    boxSet.add(1, 1, -1, -1);
  }

  @Test
  public void testSubtractRectangleNoOverlap() {
    boxSet.add(0, 0, 2, 2);
    boxSet.subtract(3, 3, 1, 1); // Subtracting rectangle that doesn't overlap
    assertEquals("Box set should still contain 1 rectangle after subtracting non-overlapping rectangle.", 1, boxSet.size());
  }

  @Test
  public void testSubtractRectangleWithOverlap() {
    boxSet.add(0, 0, 3, 3);
    boxSet.subtract(1, 1, 1, 1); // Subtracting rectangle that overlaps
    assertTrue("Box set should be adjusted correctly after subtraction.", boxSet.size() > 1);
  }

  @Test
  public void testGetBoxes() {
    boxSet.add(0, 0, 2, 2);
    int[][] expectedBoxes = {{0, 0, 2, 2}};
    assertArrayEquals("getBoxes should return the correct rectangles.", expectedBoxes, boxSet.getBoxes());
  }
}