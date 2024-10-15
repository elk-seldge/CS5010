/*
 METHODS
 ..this.push(T item): void
 ..this.pop(): T
 ..this.peek(): T
 ..this.isEmpty(): boolean
 ..this.getSize(): int
 */
import java.util.ArrayList;
public class MyStackInheritance<T> extends ArrayList<T>{
  //private ArrayList<T> list;

  /**
   * Constructor to initialize the stack
   */
  public MyStackInheritance(){
    super();
    //this.list = new ArrayList<T>();
  }

  /**
   * Push a type T item into the stack
   * @param item T type var to be pushed into the stack
   */
  public void push(T item){
    super.add(item);
  }

  /**
   * Get the last element of the stack and then delete it
   * @return T type var stands for the last element
   */
  public T pop(){
    T item = this.peek();
    super.remove(item);
    return item;
  }

  /**
   * Get the last element of the stack
   * @return T type var stands for the last element
   */
  public T peek(){
    return super.get(this.getSize()-1);
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
    return super.size();
  }
}
