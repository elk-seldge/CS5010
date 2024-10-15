import org.junit.Before;
import org.junit.Test;

import movies.Movie;
import movies.MovieLinkedList;
import movies.MovieList;
import movies.Person;
import movies.TimeIndicator;

import static org.junit.Assert.*;

public class MovieLinkedListTest {
  private Person director1, director2, director3, director4;
  private Movie movie1, movie2, movie3, movie4;
  private MovieLinkedList lst, lst2;

  /**
   * Set up movies to use for our tests.
   */
  @Before
  public void setUp() {
    this.director1 = new Person("Frank", "Darabont");
    this.director2 = new Person("Christopher", "Nolan");
    this.director3 = new Person("Steven", "Spielberg");
    this.director4 = new Person("Quentin", "Tarantino");
    this.movie1 = new Movie("the shawshank redemption", this.director1, 1994);
    this.movie2 = new Movie("the dark knight", this.director2, 2008);
    this.movie3 = new Movie("schindler's list", this.director3, 1993);
    this.movie4 = new Movie("pulp fiction", this.director4, 1994);
    this.lst = new MovieLinkedList();
    this.lst2 = new MovieLinkedList();
  }

  @Test
  public void testAdd(){
    int size1, size2;
    size1 = this.lst.getSize();
    this.lst.add(0, this.movie1);
    size2 = this.lst.getSize();
    System.out.println(size1 + " " + size2);
    assertEquals(size1 + 1, size2);
  }

  @Test
  public void testRemove(){
    System.out.println(this.lst.getSize());
    this.lst.add(0, movie1);
    System.out.println(this.lst.getSize());
    this.lst.add(-1, movie2);
    System.out.println(this.lst.getSize());
    boolean test = this.lst.remove(this.movie2);
    System.out.println(this.lst.getSize());
    assertTrue(test);
  }

  @Test
  public void testMoviesMade(){
    this.lst.add(0, movie1);
    this.lst.add(-1, movie2);
    MovieList test = this.lst.moviesMade(TimeIndicator.DURING, 1994);

    assertTrue(test.remove(movie1));
  }

  @Test
  public void testMoviesDirectedBy(){
    this.lst.add(0, movie1);
    this.lst.add(-1, movie2);
    MovieList test = this.lst.moviesDirectedBy(this.director1);

    assertTrue(test.remove(movie1));
  }

}