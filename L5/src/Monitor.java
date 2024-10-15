public interface Monitor {
  /**
   * Add a new blood pressure to the bpRecordList
   * @param t BloodPressureRecord type item stands for blood pressure record
   */
  void add(BloodPressureRecord t);

  /**
   * Remove a certain blood pressure to the bpRecordList
   * @param t BloodPressureRecord type item stands for blood pressure record
   */
  void remove(BloodPressureRecord t);

  /**
   * Get the number of the records in the bpRecordList
   * @return int val stands for the size of the records
   */
  int getNumberOfRecords();

  /**
   * Check if there is any emergency in the bpRecordList
   * @return if there is, return true; else, return false
   */
  boolean emergency();

}
