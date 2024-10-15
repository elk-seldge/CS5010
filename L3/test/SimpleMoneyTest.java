import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Random;

import static org.junit.Assert.*;

public class SimpleMoneyTest {
  public SimpleMoney testMoney, testError, testAdd, testRec;

  /**
   * This method tests for three error cases: negative dollar/cent or both
   */
  @Test
  public void testSimpleMoneyError(){
    /* negative dollars, negative cents, negative dollars/cents, regular dollars with cents
    greater than 100, regular dollars with cents overflow, and regular dollars/cents.
     */
    Random rand = new Random();
    for (int i = 0; i < 1000; i++){
      int testDollarN = -rand.nextInt(10000);
      int testDollarP = rand.nextInt(10000);
      int testCentP = rand.nextInt(99);
      int testCentN = -rand.nextInt(99);
      int testCentO = rand.nextInt(100) + 100;
      assertThrows(IllegalArgumentException.class, () -> {testError = new SimpleMoney(testDollarP
              , testCentN);});
      assertThrows(IllegalArgumentException.class, () -> {testError = new SimpleMoney(testDollarN
              , testCentP);});
      assertThrows(IllegalArgumentException.class, () -> {testError = new SimpleMoney(testDollarN
              , testCentN);});
      assertThrows(IllegalArgumentException.class, () -> {testError = new SimpleMoney(testDollarN
              , testCentO);});
    }

  }

  /**
   * This method test for addOther() output with cents overflow/not overflow cases
   */
  @Test
  public void testAddOther(){
    Random rand = new Random();
    for (int i = 0; i < 1000; i++){
      int testDollarP = rand.nextInt(10000);
      int testCentP = rand.nextInt(99);
      int testDollarAdd = rand.nextInt(10000);
      int testCentAdd = rand.nextInt(99);
      testMoney = new SimpleMoney(testDollarP, testCentP);
      testAdd = new SimpleMoney(testDollarAdd,testCentAdd);
      DecimalFormat df = new DecimalFormat("0.00");
      double expected = Double.parseDouble(df.format(testMoney.getDecimalValue() + testAdd.getDecimalValue()));
      testRec = (SimpleMoney) testMoney.add(testAdd);
      assertEquals(testRec.getDecimalValue() , expected, 0.00);
    }
  }

  /**
   * This method test for addDC() output with cents overflow/not overflow cases
   */
  @Test
  public void testAddDC(){
    Random rand = new Random();
    for (int i = 0; i < 1000; i++){
      int testDollarP = rand.nextInt(10000);
      int testCentP = rand.nextInt(99);
      int testDollarAdd = rand.nextInt(10000);
      int testCentAdd = rand.nextInt(99);
      testMoney = new SimpleMoney(testDollarP, testCentP);
      DecimalFormat df = new DecimalFormat("0.00");
      double expected =
              Double.parseDouble(df.format(testMoney.getDecimalValue() + (testDollarAdd + (double) testCentAdd / 100)));
      testRec = (SimpleMoney) testMoney.add(testDollarAdd, testCentAdd);
      assertEquals(testRec.getDecimalValue() , expected, 0.00);
    }
  }

  /**
   * This method test for getDecimal() output
   */
  @Test
  public void testGetDecimalValue(){
    Random rand = new Random();
    for (int i = 0; i < 1000; i++){
      int testDollarP = rand.nextInt(10000);
      int testCentP = rand.nextInt(99);
      testMoney = new SimpleMoney(testDollarP, testCentP);
      double expected = testDollarP + (double) testCentP / 100;
      assertEquals(testMoney.getDecimalValue() , expected, 0.00);
    }
  }

  /**
   * This method test for toString() output
   */
  @Test
  public void testToString(){
    Random rand = new Random();
    for (int i = 0; i < 1000; i++){
      int testDollarP = rand.nextInt(10000);
      int testCentP = rand.nextInt(99);
      testMoney = new SimpleMoney(testDollarP, testCentP);
      String expected = String.format("$%d.%02d", testDollarP, testCentP);
      assertEquals(expected, testMoney.toString());

    }
  }

}