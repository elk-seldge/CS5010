import movies.Movie;
import movies.MovieLinkedList;
import movies.Person;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    System.out.print("Hello and welcome!");
    Person director1, director2, director3, director4;
    Movie movie1, movie2, movie3, movie4;
    MovieLinkedList lst;

    director1 = new Person("Frank", "Darabont");
    director2 = new Person("Christopher", "Nolan");
    director3 = new Person("Steven", "Spielberg");
    director4 = new Person("Quentin", "Tarantino");
    movie1 = new Movie("the shawshank redemption", director1, 1994);
    movie2 = new Movie("the dark knight", director2, 2008);
    movie3 = new Movie("schindler's list", director3, 1993);
    movie4 = new Movie("pulp fiction", director4, 1994);
    lst = new MovieLinkedList();

    lst.add(0, movie1);
    lst.add(-1, movie2);
    lst.add(-1, movie3);
    lst.add(-1, movie4);

    lst.mergeSort(lst.getHead(), 0);
    lst.mergeSort(lst.getHead(), 1);
    lst.mergeSort(lst.getHead(), 2);
  }
}