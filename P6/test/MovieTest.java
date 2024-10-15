import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import movies.Movie;
import movies.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Movie class.
 */
public class MovieTest {
  private Person director1, director2, director3, director4;
  private Movie movie1, movie2, movie3, movie4;

  /**
   * Set up movies to use for our tests.
   */
  /* Test movie list
  the shawshank redemption Frank Darabont 1994
  the godfather	francis ford coppola	1972
  the dark knight	Christopher Nolan	2008
  schindler's list	steven spielberg	1993
  pulp fiction	quentin tarantino	1994
  the good the bad and the ugly	Sergio Leone	1966
  fight club	david fincher	1999
  forrest gump	robert Zemeckis	1994
  inception	Christopher Nolan	2010
  the silence of the lambs	Jonathan Demme	1991
  batman begins	christopher nolan	2005
  Pulp Fiction	Quentin Tarantino	1994

   */
  @Before
  public void setUp() {
    // set up the test directors and movies list
    this.director1 = new Person("Frank", "Darabont");
    this.director2 = new Person("Christopher", "Nolan");
    this.director3 = new Person("Steven", "Spielberg");
    this.director4 = new Person("Quentin", "Tarantino");
    this.movie1 = new Movie("the shawshank redemption", this.director1, 1994);
    this.movie2 = new Movie("the dark knight", this.director2, 2008);
    this.movie3 = new Movie("schindler's list", this.director3, 1993);
    this.movie4 = new Movie("pulp fiction", this.director4, 1994);
  }

  @Test
  public void testGetYear(){
    int year1 = 1994, year2 = 2008, year3 = 1993, year4 = 1994;
    assertEquals(year1, movie1.getYear());
    assertEquals(year2, movie2.getYear());
    assertEquals(year3, movie3.getYear());
    assertEquals(year4, movie4.getYear());
  }

  @Test
  public void testGetTitle(){
    String title1 = "the shawshank redemption", title2 = "the dark knight", title3 = "schindler's" +
            " list", title4 = "pulp fiction";
    assertEquals(title1, this.movie1.getTitle());
    assertEquals(title2, this.movie2.getTitle());
    assertEquals(title3, this.movie3.getTitle());
    assertEquals(title4, this.movie4.getTitle());
  }

  @Test
  public void testGetDirector(){
    Person dir1, dir2, dir3, dir4;
    dir1 = new Person("Frank", "Darabont");
    dir2 = new Person("Christopher", "Nolan");
    dir3 = new Person("Steven", "Spielberg");
    dir4 = new Person("Quentin", "Tarantino");
    assertEquals(dir1.toString(), this.movie1.getDirector().toString());
    assertEquals(dir2.toString(), this.movie2.getDirector().toString());
    assertEquals(dir3.toString(), this.movie3.getDirector().toString());
    assertEquals(dir4.toString(), this.movie4.getDirector().toString());
  }

  @Test
  public void testToString(){
    String mov1, mov2, mov3, mov4;
    mov1 = "the shawshank redemption (Frank Darabont, 1994)";
    mov2 = "the dark knight (Christopher Nolan, 2008)";
    mov3 = "schindler's list (Steven Spielberg, 1993)";
    mov4 = "pulp fiction (Quentin Tarantino, 1994)";
    assertEquals(mov1, this.movie1.toString());
    assertEquals(mov2, this.movie2.toString());
    assertEquals(mov3, this.movie3.toString());
    assertEquals(mov4, this.movie4.toString());
  }

  @Test
  public void testCompareTo(){
    assertEquals(0, movie1.compareTo(movie1));
    assertEquals(-1, movie1.compareTo(movie2));
    assertEquals(-1, movie2.compareTo(movie1));
    assertEquals(-1, movie1.compareTo(movie3));
    assertEquals(-1, movie3.compareTo(movie1));
    assertEquals(0, movie4.compareTo(movie4));
  }

  @Test
  public void testEquals() {
    assertTrue(movie1.equals(movie1));
    assertFalse(movie1.equals(movie2));
    assertFalse(movie2.equals(movie1));
    assertFalse(movie1.equals(movie3));
    assertFalse(movie3.equals(movie1));
    assertTrue(movie4.equals(movie4));
  }

}

  