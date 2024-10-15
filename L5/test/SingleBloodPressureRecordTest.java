import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleBloodPressureRecordTest {
  private SingleBloodPressureRecord testRecord1;
  @Before
  public void setUp(){
    testRecord1 = new SingleBloodPressureRecord("001", 99.3, 88.2);
  }

  @Test
  public void getIDValid() {

    assertEquals("ID should be the same", "001", testRecord1.getID());
    assertEquals("Systolic Should be the same", 99.3, testRecord1.getSystolicReading(), 0.0);
    assertEquals("Diastolic Should be the same", 88.2, testRecord1.getDiastolicReading(), 0.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidInputs() {
    new SingleBloodPressureRecord("", 120.0, 80.0);
    new SingleBloodPressureRecord("ID123", -120.0, 80.0);
    new SingleBloodPressureRecord("ID123", 120.0, -80.0);
    new SingleBloodPressureRecord("ID123", 77.3, 80.0);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testUpdateSystolicReadingInvalid() {
    SingleBloodPressureRecord record = new SingleBloodPressureRecord("ID123", 120.0, 80.0);
    record.updateSystolicReading(70.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testUpdateDiastolicReadingInvalid() {
    SingleBloodPressureRecord record = new SingleBloodPressureRecord("ID123", 120.0, 80.0);
    record.updateDiastolicReading(130.0);
  }

  @Test
  public void testUpdateReadingValid() {
    SingleBloodPressureRecord record = new SingleBloodPressureRecord("ID123", 120.0, 80.0);
    record.updateSystolicReading(130.0);
    assertEquals(130.0, record.getSystolicReading(), 0.001);
    record.updateDiastolicReading(90.0);
    assertEquals(90.0, record.getDiastolicReading(), 0.001);
  }

}