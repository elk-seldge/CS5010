import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

//MyDateTest

/*
 METHODS
 ..this.setUp(): void
 ..this.testCreateFail(): void
 ..this.testToString(): void
 ..this.testAdvance(): void
 */
public class MyDateTest {
  private MyDate testDateN,
  testDateL, testErrorNegativeDay, testErrorNegativeMonth,
  testErrorNegativeYear, testErrorTooBigDay, testErrorTooBigMonth;

  /**
   * Initialize the test object
   */
  @Before
  public void setUp(){
    testDateN = new MyDate(18, 9, 1931);
    testDateL = new MyDate(9, 4, 1940);

  }

  /**
   * Test for two types of invalid inputs:
   * Date with: negative day, month, and year.
   * Date with: Too big day or Month
   */
  @Test
  public void testCreateFail() {
    assertThrows(IllegalArgumentException.class, () -> {testErrorNegativeDay =
            new MyDate(-1, 1, 2024);});
    assertThrows(IllegalArgumentException.class, () -> {testErrorNegativeMonth =
            new MyDate(1, -1, 2024);});
    assertThrows(IllegalArgumentException.class, () -> {testErrorNegativeYear =
            new MyDate(1, 1, -2024);});
    assertThrows(IllegalArgumentException.class, () -> {testErrorTooBigDay =
            new MyDate(32, 1, 2024);});
    assertThrows(IllegalArgumentException.class, () -> {testErrorTooBigMonth =
            new MyDate(1, 13, 2024);});
  }

  /**
   * This method tests for the toString method
   */
  @Test
  public void testToString() {
    String expected = "1931-9-18";
    System.out.println(testDateN.toString());
    if (expected.equals(testDateN.toString())){
      System.out.println("Success");
    } else {
      fail("Wrong result");
    }
  }

  /**
   * This method tests for various case in advance method
   * Leap year: advancing/retreating
   * Normal year: advancing/retreating
   * in 1 day, 10 days, 30 days, 45 days, 365 days, 2191 days
   *  one day, ten days, a month, 1.5 months, 1 year, 6 year and 1 day
   *  advancing/retreating across two months or years
   *  1931-9-18 1945-9-2
   */
  @Test
  public void testAdvance() {
    // test for +/- 1 day
    System.out.println(testDateN.toString());
    String plus1 = "1931-9-19";
    String minus1 = "1931-9-18";
    testDateN.advance(1);
    assertEquals(plus1, testDateN.toString());
    testDateN.advance(-1);
    //System.out.println("after: "+testDateN.toString());
    assertEquals(minus1, testDateN.toString());

    // test for +/- 10 days
    testDateN.advance(10);
    assertEquals("1931-9-28", testDateN.toString());

    testDateN.advance(-10);
    assertEquals("1931-9-18", testDateN.toString());
    // test for +/- 30 days
    testDateN.advance(30);
    assertEquals("1931-10-18", testDateN.toString());

    testDateN.advance(-30);
    assertEquals("1931-9-18", testDateN.toString());
    // test for +/- 45 days

    // test for +/- 365 days

    // test for +/- 2191 days

    // test for across two months

    // test for across two years

    // test for retreating an extremely huge amount of days
  }
}