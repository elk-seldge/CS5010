/**
 * This interface realize the US currencies and their basic actions
 */
interface Money {
  /**
   * Add up the money in two Money objects
   * @param other Another Money object that is going to be added with this one
   * @return A Money object contains the sum of this and other
   */
  public Money add(Money other);
    /**
   * Add a certain amount of dollars and cents to current Money object
   * @param dollars Amount of dollars that is going to be added up
   * @param cents Amount of cents that is going to be added up
   * @return A Money object contains the sum
   */
  public Money add(int dollars, int cents);

  /**
   * Convert the current balance to double type
   * @return A double variable of this Money object
   */
  public double getDecimalValue();
}

