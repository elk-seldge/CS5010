// MyStack
/*
FIELDS
 ..this.list: int
 METHODS
 ..this.push(T item): void
 ..this.pop(): T
 ..this.peek(): T
 ..this.isEmpty(): boolean
 ..this.getSize(): int
 */
import java.util.ArrayList;

public class MyStack<T> {
  private ArrayList<T> list;

  /**
   * Constructor to initialize the stack list
   */
  public MyStack(){
    this.list = new ArrayList<T>();
  }

  /**
   * Push a type T item into the stack
   * @param item T type var to be pushed into the stack
   */
  public void push(T item){
    this.list.add(item);
  }

  /**
   * Get the last element of the stack and then delete it
   * @return T type var stands for the last element
   */
  public T pop(){
    T item = this.peek();
    this.list.remove(item);
    return item;
  }

  /**
   * Get the last element of the stack
   * @return T type var stands for the last element
   */
  public T peek(){
    return this.list.get(this.getSize()-1);
  }

  /**
   * Check if this stack list is empty
   * @return true for empty; else, false
   */
  public boolean isEmpty(){
    return this.getSize() == 0;
  }

  /**
   * Get the size of this stack list
   * @return int var stands for the size of stack list
   */
  public int getSize(){
    return this.list.size();
  }
}
