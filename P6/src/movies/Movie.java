// Movie
/*
FIELDS
 .this.title: String
 .this.director: Person
 .this.year: int
 METHODS
 ..this.getTitle(): String
 ..this.getDirector(): Person
 ..this.getYear(): String
 ..this.toString(): String
 ..this.compareTo(): int
 METHODS OF FIELDS
 ..this.center.equals(Object another): boolean
 */
package movies;

/**
 * This class represents a movie. The movie has a title, director, and year of release.
 */
public class Movie implements Comparable<Movie> {
  private String title;
  private Person director;
  private int year;

  /**
   * Constructs a Movie object and initializes it to the movie's title, director and year.
   *
   * @param title     the title of this movie
   * @param director  the name of the movie's director
   * @param year      the year the movie was released
   */
  public Movie(String title, Person director, int year) {
    this.title = title;
    this.director = director;
    this.year = year;
  }

  /**
   * Get the title of the movie.
   *
   * @return the title of the movie
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Get the name of the director of the movie.
   *
   * @return the name of the director of the movie
   */
  public Person getDirector() {
    return this.director;
  }

  /**
   * Get the year of the movie.
   *
   * @return the year of the movie
   */
  public int getYear() {
    return this.year;
  }

  /**
   * Returns a string representation of the Movie object. The string consists of the movie's title, director, and year of release.
   *
   * @return a string representation of the Movie object
   */
  @Override
  public String toString() {
    // Example: The Apartment (Billy Wilder, 1960)
    return String.format("%s (%s, %d)", this.getTitle(), this.getDirector().toString(), this.getYear());

  }

  /**
   * Compares this Movie object with the specified Movie object for order.
   *
   * @param o the Movie object to be compared
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object
   */
  @Override
  public int compareTo(Movie o) {
    int t, d, y;
    t = this.getTitle().compareTo(o.getTitle());
    d = this.getDirector().toString().compareTo(o.getDirector().toString());
    y = (this.getYear() == o.getYear()) ? 0 : 1;

    if (t !=0 || d != 0 || y != 0) {
      return -1;
    } else {return  0;}
  }

  @Override
  public boolean equals(Object another){
    if (this == another) {
      return true;
    }
    if (another == null || getClass() != another.getClass()) {
      return false;
    }
    Movie movie = (Movie) another;
    return this.title.equalsIgnoreCase(movie.title);
  }

}
