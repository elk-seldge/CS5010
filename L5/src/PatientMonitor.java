// PatientMonitor
/*
FIELDS
 ..this.bpRecordList: List<BloodPressureRecord>
 METHODS
 ..this.add(BloodPressureRecord t): void
 ..this.remove(BloodPressureRecord t): void
 ..this.getNumberOfRecords(): int
 ..this.emergency(): boolean
 */


import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a patient monitor. It monitors some blood pressure records,
 * specifically to see how many of them are going into hypertensive crisis.
 */

public class PatientMonitor implements Monitor {
  private List<BloodPressureRecord> bpRecordList;

  /**
   * Constructor initialize the PatientMonitor with an empty ArrayList contains
   * BloodPressureRecord objects
   */
  public PatientMonitor() {
    this.bpRecordList = new ArrayList<BloodPressureRecord>();
  }

  /**
   * Add a new record to the monitor ArrayList bpRecordList
   * @param t BloodPressureRecord type item stands for blood pressure record
   */
  @Override
  public void add(BloodPressureRecord t) {
    bpRecordList.add(t);
  }

  /**
   * Remove a record from the monitor ArrayList bpRecordList
   * @param t BloodPressureRecord type item stands for blood pressure record
   */
  @Override
  public void remove(BloodPressureRecord t) {
    bpRecordList.remove(t);
  }

  /**
   * Get the number of the records in the monitor list bpRecordList
   * @return int val stands for the number of the records
   */
  @Override
  public int getNumberOfRecords() {
    return bpRecordList.size();
  }

  /**
   * Check if there is an emergency in the monitor list bpRecordList
   * @return If there is, return true; else, return false
   */
  @Override
  public boolean emergency() {
    int count = 0;
    for (BloodPressureRecord t: bpRecordList) {
      if ((t.getSystolicReading()>=180) || (t.getDiastolicReading()>=120)) {
        count +=1;
      }

    }
    return count>1;
  }

}
