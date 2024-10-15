package movies;

public class MovieLinkedList implements MovieList{
  movieNode<Movie> head;
  private int size;

  public static class movieNode<Movie>{
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

  /**
   * This class represents a singly linked list of movies.
   */
  public MovieLinkedList(){
    this.head = null;
    this.size = 0;
  }
  /**
   * Adds a movie at the specified index in the linked list.
   *
   * @param index the index at which the movie is to be added
   * @param movie the movie to be added
   * @throws IndexOutOfBoundsException if the index is invalid
   */
  @Override
  public void add(int index, Movie movie) throws IndexOutOfBoundsException {
    // 1 -> 2 -> 3 -> 4 -> 5
    if (index > size || index < -1) {
      throw new IndexOutOfBoundsException("invalid index");
    } else {
      movieNode<Movie> temp = new movieNode<Movie>(movie);
      movieNode<Movie> ptr = this.head;
      //System.out.println("do something");
      if (this.head == null) {
        System.out.println("add from head");
        this.head = temp;
        this.size++;
        System.out.println("added");
      }else if (index == -1) {
        System.out.println("add from tail");
        for (int i=0; i<this.size && ptr.next != null; i++) {
          ptr = ptr.next;
        }
        ptr.next = temp;
        this.size++;
        System.out.println("added");
      } else {
        for (int i=0; i<index && ptr.next != null; i++) {
          ptr = ptr.next;
        }
        //assert ptr != null;
        ptr.next = temp;
      }
    }
  }

  public int getSize(){
    return this.size;
  }

  public movieNode<Movie> getHead(){
    return this.head;
  }

  /**
   * Removes the first occurrence of the specified movie from this list, if it is present.
   * If this list does not contain the movie, it is unchanged.
   *
   * @param movie the movie to be removed from this list, if present
   * @return true if the movie was found and removed; false otherwise
   */
  @Override
  public boolean remove(Movie movie) {
    movieNode<Movie> ptr = this.head;
    if (this.head.data == movie){this.head = null; return true;}

    // 1 -> 2 -> 3 -> 4 -> 5
    for (int i=0; i<this.size && ptr != null; i++) {
      movieNode<Movie> fasterPtr = ptr.next;
      System.out.println(" in loop");
      if (fasterPtr != null && fasterPtr.data == movie){
        ptr.next = fasterPtr.next;
        this.size--;
        System.out.println("removed");
        return true;
      }
      ptr = ptr.next;
    }
    return false;
  }

  /**
   * Create a list of movies made in a certain period (before, during or after a certain year).
   *
   * @param timeIndicator indicates if the movies we want were made before, during or after a year
   * @param year the year
   * @return the list of movies made during that period
   */
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


  /**
   * Create a list of movies made by a particular director.
   *
   * @param director the director
   * @return the list of movies made by that director
   */
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

  /**
   * This method performs the merge sort algorithm on a singly linked list of movies.
   * It recursively splits the list into two halves, sorts the halves, and merges them back together in sorted order.
   *
   * @param head the head of the list to be sorted
   * @param mode 0 for title, 1 for director, and 2 for year
   * @return the head of the sorted list
   */
  public movieNode<Movie> mergeSort(movieNode<Movie> head, int mode){
    if (head == null || head.next == null) {return head;}
    movieNode<Movie> mid, left, right;
    mid = getMid(head);
    left = head;
    right = mid.next;
    mid.next = null;
    movieNode<Movie> leftSorted = mergeSort(left, mode);
    movieNode<Movie> rightSorted = mergeSort(right, mode);
    movieNode<Movie> sorted = merge(leftSorted, rightSorted, mode);
    System.out.println(sorted.data.toString());
    return sorted;
  }

  /**
   * This method merges two sorted singly linked lists of movies into one sorted list.
   *
   * @param Left the head of the first sorted list
   * @param Right the head of the second sorted list
   * @param mode 0 for title, 1 for director, and 2 for year
   * @return the head of the merged sorted list
   */
  private movieNode<Movie> merge(movieNode<Movie> Left, movieNode<Movie> Right, int mode){
    if (Left == null) { return Right; }
    else if (Right == null) { return Left; }
    movieNode<Movie> head = null, ptr = null;

    while (Left != null && Right != null) {
      if (head == null){ // when the result list is empty
        if (mode == 0){
          if (Left.data.getTitle().compareTo(Right.data.getTitle()) <= 0){ // left is smaller
            head = Left;
            Left = Left.next;
          } else { // right is smaller
            head = Right;
            Right = Right.next;
          }
        } else if (mode == 1) {
          if (Left.data.getDirector().toString().compareTo(Right.data.getDirector().toString()) <= 0){ // left is
            // smaller
            head = Left;
            Left = Left.next;
          } else { // right is smaller
            head = Right;
            Right = Right.next;
          }
        } else {
          if (Left.data.getYear() < Right.data.getYear()){ // left is smaller
            head = Left;
            Left = Left.next;
          } else { // right is smaller
            head = Right;
            Right = Right.next;
          }
        }

        ptr = head;
      } else { // the result list is not empty
        if (mode == 0){
          if (Left.data.getTitle().compareTo(Right.data.getTitle()) <= 0){ // left is smaller
            head = Left;
            Left = Left.next;
          } else { // right is smaller
            head = Right;
            Right = Right.next;
          }
        } else if (mode == 1) {
          if (Left.data.getDirector().toString().compareTo(Right.data.getDirector().toString()) <= 0){ // left is
            // smaller
            head = Left;
            Left = Left.next;
          } else { // right is smaller
            head = Right;
            Right = Right.next;
          }
        } else {
          if (Left.data.getYear() < Right.data.getYear()){ // left is smaller
            head = Left;
            Left = Left.next;
          } else { // right is smaller
            head = Right;
            Right = Right.next;
          }
        }
        ptr = ptr.next;
      }
      ptr.next = (Left != null) ? Left : Right;
    }
    return head;
  }
  /**
   * This method returns the middle node of a singly linked list.
   *
   * @param node the head of the linked list
   * @return the middle node of the linked list
   */
  private movieNode<Movie> getMid(movieNode<Movie> node){
    movieNode<Movie> slow = node;
    movieNode<Movie> fast = node;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
