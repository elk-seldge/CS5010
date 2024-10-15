import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PatientMonitorTest {

  private PatientMonitor monitor;
  private BloodPressureRecord normalRecord;
  private BloodPressureRecord crisisRecord1;
  private BloodPressureRecord crisisRecord2;

  @Before
  public void setUp() {
    monitor = new PatientMonitor();

    // Assuming BloodPressureRecord has a constructor for this example
    normalRecord = new SingleBloodPressureRecord("ID1", 120, 80);
    crisisRecord1 = new SingleBloodPressureRecord("ID2", 180, 100);
    crisisRecord2 = new SingleBloodPressureRecord("ID3", 190, 121);
  }

  @Test
  public void testAddAndRemoveRecord() {
    assertEquals(0, monitor.getNumberOfRecords());
    monitor.add(normalRecord);
    assertEquals(1, monitor.getNumberOfRecords());
    monitor.remove(normalRecord);
    assertEquals(0, monitor.getNumberOfRecords());
  }

  @Test
  public void testEmergencyNoCrisis() {
    monitor.add(normalRecord);
    assertFalse(monitor.emergency());
  }

  @Test
  public void testEmergencyWithCrisis() {
    monitor.add(crisisRecord1);
    monitor.add(normalRecord);
    assertFalse(monitor.emergency()); // Only one record in crisis

    monitor.add(crisisRecord2);
    assertTrue(monitor.emergency()); // Now there are two, indicating an emergency
  }
}
