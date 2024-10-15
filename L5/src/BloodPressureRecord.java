public interface BloodPressureRecord {
  /**
   * Get the ID
   * @return String val stands for the ID
   */
  String getID();

  /**
   * Get the Systolic Reading
   * @return double val stands for systolic reading
   */
  double getSystolicReading();

  /**
   * Get the Diastolic Reading
   * @return double val stands for Diastolic reading
   */
  double getDiastolicReading();

  /**
   * Update the systolic reading and check for invalid inputs
   * @param sys double var stands for new systolic reading
   * @throws IllegalArgumentException if sys < 0, sys < diastolic
   */
  void updateSystolicReading(double sys) throws IllegalArgumentException;


  /**
   * Update the Diastolic reading and check for invalid inputs
   * @param dias double var stands for new Diastolic reading
   * @throws IllegalArgumentException if dias < 0, dias > systolic
   */
  void updateDiastolicReading(double dias) throws IllegalArgumentException;
}
