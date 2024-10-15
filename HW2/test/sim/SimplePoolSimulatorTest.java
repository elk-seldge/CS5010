package sim;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimplePoolSimulatorTest {
  @Test
  public void testInitialization() {
    SimplePoolSimulator simulator = new SimplePoolSimulator(400, 400, "simple");
    assertNotNull("Simulator should be initialized", simulator);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitialization() {
    new SimplePoolSimulator(-1, 400, "simple");
  }

  @Test
  public void testStartPosition() {
    SimplePoolSimulator simulator = new SimplePoolSimulator(400, 400, "simple");
    simulator.start(100, 100, 10, 5, 1.0, -1.0);
    assertEquals("Initial X position should be 100", 100, simulator.getBallPositionX(), 0.01);
    assertEquals("Initial Y position should be 100", 100, simulator.getBallPositionY(), 0.01);
  }

  @Test
  public void testAdvance() {
    SimplePoolSimulator simulator = new SimplePoolSimulator(400, 400, "simple");
    simulator.start(100, 100, 10, 5, 1.0, -1.0);
    simulator.advance();
    // Assuming the advance method updates the position based on the velocity
    // The actual assertions here will depend on the specifics of how advance is implemented
    assertEquals("X position should change after advance", 400, simulator.getBallPositionX(), 0.0);
    assertEquals("Y position should change after advance", 400, simulator.getBallPositionY(), 0.0);

    // friction
    SimplePoolSimulator simulator1 = new SimplePoolSimulator(400, 400, "friction");
    simulator1.start(100, 100, 10, 5, 1.0, -1.0);
    simulator1.advance();
    // Assuming the advance method updates the position based on the velocity
    // The actual assertions here will depend on the specifics of how advance is implemented
    assertEquals("X position should change after advance", simulator1.getBallPositionX(), 112.742
            , 0.000);
    assertEquals("Y position should change after advance", simulator1.getBallPositionY(), 112.742
            , 0.000);
  }

}