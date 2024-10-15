import java.util.Objects;

// SingleBloodPressureRecord
/*
FIELDS
 ..this.ID: String
 ..this.systolic: double
 ..this.diastolic: double
 METHODS
 ..this.getID(T item): String
 ..this.getSystolicReading(): double
 ..this.getDiastolicReading(): double
 ..this.updateSystolicReading(double sys): void
 ..this.updateDiastolicReading(double dias): void
 */
public class SingleBloodPressureRecord implements BloodPressureRecord{
  private String ID;
  private double systolic, diastolic;

  /**
   * Constructor initialize SingleBloodPressureRecord, and check for the invalid outputs
   * @param ID String var stands for the ID, cannot be blank
   * @param systolic double var stands for the systolic reading, cannot be negative or smaller
   *                 than diastolic
   * @param diastolic double var stands for the diastolic reading, cannot be negative or larger
   *                  than systolic
   */

  public SingleBloodPressureRecord(String ID, double systolic, double diastolic){
    if (Objects.equals(ID, "") || systolic < 0 || diastolic < 0 || systolic < diastolic){
      throw new IllegalArgumentException("ID cannot be blank, systolic and diastolic reading " +
              "cannot be negative; And, systolic reading must geq to diastolic reading.");
    } else {
      this.ID = ID;
      this.systolic = systolic;
      this.diastolic = diastolic;
    }
  }

  /**
   * Get the ID
   * @return String val stands for ID
   */
  @Override
  public String getID() {
    return this.ID;
  }

  /**
   * Get the Systolic Reading
   * @return double val stands for systolic reading
   */
  @Override
  public double getSystolicReading() {
    return this.systolic;
  }

  /**
   * Get the Diastolic Reading
   * @return double val stands for diastolic reading
   */
  @Override
  public double getDiastolicReading() {
    return this.diastolic;
  }

  /**
   * Update the systolic reading and check for invalid inputs
   * @param sys double var stands for new systolic reading
   * @throws IllegalArgumentException if sys < 0, sys < diastolic
   */
  @Override
  public void updateSystolicReading(double sys) throws IllegalArgumentException {
    if (sys > 0 && sys >= this.diastolic) {
      this.systolic = sys;
    } else {throw new IllegalArgumentException("Systolic reading cannot be negative");}
  }

  /**
   * Update the Diastolic reading and check for invalid inputs
   * @param dias double var stands for new Diastolic reading
   * @throws IllegalArgumentException if dias < 0, dias > systolic
   */
  @Override
  public void updateDiastolicReading(double dias) throws IllegalArgumentException {
    if (dias > 0 && dias <= this.systolic) {
      this.diastolic = dias;
    } else {throw new IllegalArgumentException("Diastolic reading cannot be negative");}
  }

}
