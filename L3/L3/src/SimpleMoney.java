// In SimpleMoney
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
import java.math.BigDecimal;
public class SimpleMoney implements Money{
  private int dollars;
  private int cents;


  /**
   * The constructor initialize the SimpleMoney class also check for invalid values
   * @param dollars Amount of dollars the person holds (dollars >= 0)
   * @param cents Amount of cents the person holds (cents >= 0)
   */
  public SimpleMoney(int dollars, int cents) {
    if (dollars >=0 && cents >= 0 && cents < 100) {
      this.dollars = dollars;
      this.cents = cents;
    } else {
      throw new IllegalArgumentException("The amount of dollars and cents should be positive");
    }
  }

  /**
   * This method add the values of Money object other to this object.
   * @param other Another Money object that is going to be added with this one
   * @return A new money object with the new value
   */
  @Override
  public Money add(Money other) {
    double sm = this.getDecimalValue() + other.getDecimalValue();

    int smInt = (int) sm;
    double smDec = (sm % 1) * 100;
    System.out.println("sm: " + sm );
    System.out.println("Integer part: " + smInt);
    System.out.println("Decimal part: " + smDec);
    return new SimpleMoney(smInt, (int) Math.round(smDec));
  }

  /**
   * This method add the passed dollars and cents values to this object, and return a new Money obj
   * @param dollars Amount of dollars that is going to be added up
   * @param cents Amount of cents that is going to be added up
   * @return A new Money object with the new value
   */
  @Override
  public Money add(int dollars, int cents) {
    if (cents + this.cents < 100){
      System.out.println("Cents not overflow.");
      this.dollars += dollars;
      this.cents += cents;
    } else {
      System.out.println("Cents overflow.");
      cents -= (100 - this.cents);
      this.dollars += (1+dollars);
      //System.out.println("this.cents: " + this.cents + "cents: " + cents);
      this.cents = cents;
    }
    return new SimpleMoney(this.dollars, this.cents);
  }

  /**
   * This method converts the value of dollars and cents to a double value
   * @return A double value of dollars and cents
   */
  @Override
  public double getDecimalValue() {
    return this.dollars + (double) this.cents / 100;
  }

  /**
   * This method converts the value of dollars and cents to $dd.cc string format
   * @return A string of dollars and cents
   */
  @Override
  public String toString() {
    return String.format("$%d.%02d", this.dollars, this.cents);
  }
}
