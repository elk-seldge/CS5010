

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cs5010.lab00.Book;
import cs5010.lab00.Person;

public class BookTest {
	private Book DBTextbook;
	private Person david;
	
	@Before
	  public void setUp() {
		david = new Person("David", "Kroenke", 1946);
	    DBTextbook = new Book("Database Processing_Fundamentals, Design, and Implementation", david, (float) 19.99);
	  }

	@Test
	public void test1() {
		int expected = 3;
		assertEquals(expected, 3);
	}
	
	@Test
	public void test2() {
		String expected = "northeastern";
		assertEquals("Message", expected, "northeastern");
	}
	
	@Test
	  public void testTitle() {
	    assertEquals("Database Processing_Fundamentals, Design, and Implementation", DBTextbook.getTitle());

	  }
	
	@Test
	  public void testAuthor() {
	    assertEquals(david, DBTextbook.getAuthor());

	  }
	
	@Test
	  public void testPrice() {
	    assertEquals(19.99, DBTextbook.getPrice(), 1e-6);

	  }
}
