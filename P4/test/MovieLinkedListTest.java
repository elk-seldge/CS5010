import org.junit.Before;
import org.junit.Test;

import movies.Movie;
import movies.MovieLinkedList;
import movies.Person;
import movies.TimeIndicator;

import static org.junit.Assert.*;

public class MovieLinkedListTest {
  private Person billyWilder, testP;
  private Movie theApartment, Apt, test, test1;
  private MovieLinkedList lst, lst2, lst3, lst4;

  /**
   * Set up movies to use for our tests.
   */
  @Before
  public void setUp() {
    this.billyWilder = new Person("Billy", "Wilder");
    this.testP = new Person("Bill", "doe");
    this.theApartment = new Movie("The Apartment", this.billyWilder, 1960);
    this.Apt = new Movie("The Apartment", this.billyWilder, 1960);
    this.test = new Movie("Apartment", this.billyWilder, 1960);
    this.test1 = new Movie("Apartment", this.billyWilder, 1963);
  }

  @Test
  public void testAdd(){
    lst.add(0, this.theApartment);
    assertEquals(this.lst, lst.moviesDirectedBy(this.billyWilder));
  }

  @Test
  public void testRemove(){
    lst.add(-1, test);
    assertTrue(lst.remove(this.test));
  }

  @Test
  public void testMoviesMade(){
    lst.add(-1, this.test1);
    lst2.add(0, test1);
    assertEquals(lst.moviesMade(TimeIndicator.AFTER, 1960), lst2.moviesMade(TimeIndicator.AFTER, 1960));
  }

  @Test
  public void testMoviesDirectedBy(){
    lst3.add(-1, this.test);
    lst4.add(-1, this.theApartment);
    assertEquals(lst.moviesDirectedBy(this.billyWilder), lst2.moviesDirectedBy(this.billyWilder));
  }

}