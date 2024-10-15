import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {

  private MyStack<Integer> stack;
  @Before
  public void setUp() {
    this.stack = new MyStack<>();
  }

  @Test
  public void testIsEmptyOnNewStack() {
    assertTrue("New stack should be empty", this.stack.isEmpty());
  }

  @Test
  public void testPush() {
    this.stack.push(1);
    assertFalse("Stack should not be empty after push", this.stack.isEmpty());
  }

  @Test
  public void testPeek() {
    this.stack.push(2);
    assertEquals("Peek should return the last pushed item", Integer.valueOf(2), this.stack.peek());
  }

  @Test
  public void testPop() {
    this.stack.push(3);
    assertEquals("Pop should return the last pushed item", Integer.valueOf(3), this.stack.pop());
    assertTrue("Stack should be empty after pop", this.stack.isEmpty());
  }

  @Test
  public void testGetSize() {
    this.stack.push(4);
    this.stack.push(5);
    assertEquals("Size should reflect the number of items in the stack", 2, this.stack.getSize());
  }

  @Test(expected = Exception.class)
  public void testPopOnEmptyStack() {
    this.stack.pop(); // Adjust this based on the expected behavior (exception or return null)
  }
}