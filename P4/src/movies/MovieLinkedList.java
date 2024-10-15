package movies;

public class MovieLinkedList implements MovieList{
  movieNode<Movie> head;
  private int size;

  class movieNode<Movie>{
    private Movie data;
    private movieNode<Movie> next;
    public movieNode(Movie data){
      this.data = data;
      this.next = null;
    }

    public movieNode(Movie data, movieNode<Movie> nodeRef){
      this.data = data;
      this.next = nodeRef;
    }
  }

  public MovieLinkedList(){
    this.head = null;
    this.size = 0;
  }
  @Override
  public void add(int index, Movie movie) throws IndexOutOfBoundsException {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("invalid index");
    } else {
      movieNode<Movie> temp = new movieNode<Movie>(movie);
      movieNode<Movie> ptr = this.head;
      if (this.head == null) {
        head = temp;
        this.size++;
      } else if (index == -1) {
        for (int i=0; i<this.size && ptr != null; i++) {
          ptr = ptr.next;
        }
        ptr.next = temp;
        this.size++;
      } else {
        for (int i=0; i<index && ptr != null; i++) {
          ptr = ptr.next;
        }
        //assert ptr != null;
        ptr.next = temp;
      }
    }
  }

  @Override
  public boolean remove(Movie movie) {
    movieNode<Movie> ptr = this.head;
    for (int i=0; i<this.size && ptr != null; i++) {
      if (ptr.next.data == movie){
        ptr.next = ptr.next.next;
        this.size--;
        return true;
      }
      ptr = ptr.next;
    }
    return false;
  }

  @Override
  public MovieList moviesMade(TimeIndicator timeIndicator, int year) {
    MovieLinkedList list = new MovieLinkedList();
    movieNode<Movie> ptr = this.head;
    for (int i = 0; i < this.size && ptr != null; i++) {
      if (timeIndicator == TimeIndicator.BEFORE) {
        if (ptr.data.getYear() < year) {
          list.add(-1, ptr.data);
        }
      } else if (timeIndicator == TimeIndicator.DURING) {
        if (ptr.data.getYear() == year) {
          list.add(-1, ptr.data);
        }
      } else {
            if (ptr.data.getYear() > year) {
              list.add(-1, ptr.data);
            }
          }
      ptr = ptr.next;
    }
      return list;
  }


  @Override
  public MovieList moviesDirectedBy(Person director) {
    MovieLinkedList list = new MovieLinkedList();
    movieNode<Movie> ptr = this.head;
    for (int i=0; i<this.size && ptr != null; i++) {
      if (ptr.data.getDirector() == director){
        list.add(-1, ptr.data);
      }
      ptr = ptr.next;
    }
    return list;
  }
}
