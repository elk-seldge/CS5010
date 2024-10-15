import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;
// Vector3DTest
/*
 FIELDS
 ..this.x: vTest
 METHODS
 ..this.testToString(): void
 ..this.setUp(): void
 ..this.testGetX(): void
 ..this.testGetY(): void
 ..this.testGetZ(): void
 ..this.testGetMagnitude(): void
 ..this.testNormalize(): void
 */
class Vector3DTest {
  private Vector3D vTest;

  /**
   * This Method set up for the vTest
   */
  @Before
  public void setUp() {
    vTest = new Vector3D(2.5, 3.6, 4.7);
  }

  @Test
  public void testToString() {;
    //assertEquals("(2.5, 3.6, 4.7)", vTest.toString());
  }

  @Test
  public void testGetX(){
    Double expected = 2.5;
    assertEquals(expected, vTest.getX());
  }

  @Test
  public void testGetY(){
    Double expected = 3.6;
    assertEquals(expected, vTest.getY());
  }

  @Test
  public void testGetZ(){
    Double expected = 4.7;
    assertEquals(expected, vTest.getZ());
  }

  @Test
  public void testGetMagnitude(){
    Double expected = 6.43;
    assertEquals(expected, vTest.getMagnitude());
  }

  @Test
  public void testNormalize(){
    Vector3D vNrmlz1 = new Vector3D(0, 0, 0);
    Vector3D vNrmlz2 = new Vector3D(0.39, 8.37, 0.73);
    Vector3D vNrmlz2Test = new Vector3D(0.001, 0.003, 0.006);

    if (vTest.normalize().equals(vNrmlz2)) {
      System.out.println();
    }
  }
}