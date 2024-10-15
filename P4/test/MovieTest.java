import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import movies.Movie;
import movies.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Movie class.
 */
public class MovieTest {
  private Person billyWilder;
  private Movie theApartment, Apt, test;

  /**
   * Set up movies to use for our tests.
   */
  @Before
  public void setUp() {
    this.billyWilder = new Person("Billy", "Wilder");
    this.theApartment = new Movie("The Apartment", this.billyWilder, 1960);
    this.Apt = new Movie("The Apartment", this.billyWilder, 1960);
    this.test = new Movie("Apartment", this.billyWilder, 1960);
  }

  /**
   * Test the title of the movie.
   */
  @Test
  public void testTitle() {
    assertEquals("The Apartment", theApartment.getTitle());
  }

  /**
   * Test the director of the movie.
   */
  @Test
  public void testDirector() {
    assertEquals("Billy Wilder", theApartment.getDirector().toString());
  }

  /**
   * Test the year of the movie.
   */
  @Test
  public void testYear() {
    assertEquals(1960, theApartment.getYear());
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    assertEquals("The Apartment (Billy Wilder, 1960)", theApartment.toString());
  }


  @Test
  public void testCompareTo() {

    assertTrue(theApartment.compareTo(Apt) == 0);
    assertTrue(theApartment.compareTo(test) == -1);
  }

}

  