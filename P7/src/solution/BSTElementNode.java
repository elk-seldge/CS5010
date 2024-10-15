// BSTElementNode
/*
FIELDS
 .this.left: BSTNode<T>
 .this.right: BSTNode<T>
 .this.data: T
 METHODS
 ..this.insert(T data): BSTNode<T>
 ..this.minimum(): T
 ..this.maximum(): T
 ..this.contains(T data): boolean
 ..this.preorder(Consumer<T> consumer): void
 ..this.postorder(Consumer<T> consumer): void
 ..this.copy(): BSTNode<T>
 ..this.same(BSTNode<T> other): boolean
 ..this.toString(): String
 */
package solution;

import java.util.function.Consumer;


/**
 * This class represents a data-containing node of the binary search tree
 * It mutates on all relevant operations
 */
public class BSTElementNode<T extends Comparable<T>> implements BSTNode<T> {
  private BSTNode<T> left;
  private BSTNode<T> right;
  private T data;

  /**
   * Creates a new BSTElementNode with the given data, left child node, and right child node.
   *
   * @param data  The data to be stored in the node.
   * @param left  The left child node.
   * @param right The right child node.
   */
  public BSTElementNode(T data,BSTNode<T> left,BSTNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
  /**
   * Inserts new data into the tree rooted at this node, and return the resulting tree.
   *
   * @param data The data to be inserted into the tree.
   * @return The head node of the modified tree.
   */
  @Override
  public BSTNode insert(T data) {
    if (data.compareTo(this.data)<0) {
      this.left = this.left.insert(data);
    } else if (data.compareTo(this.data)>0) {
      this.right = this.right.insert(data);
    }
    return this;
  }

  /**
   * Determine and return the minimum element in the tree rooted at this node.
   * If the tree is empty, throw NothingThereException.
   *
   * @return The minimum element in the tree rooted at this node.
   * @throws NothingThereException If the tree does not have any data.
   */
  @Override
  public T minimum() {
    T minimum;

    try {
      minimum = this.left.minimum();
    }
    catch (NothingThereException e) {
      minimum = this.data;
    }
    return minimum;
  }

  /**
   * Determine and return the maximum element in the tree rooted at this node
   *
   * @return The T type object of the node contains the largest element
   * @throws NothingThereException if the tree does not have any data
   */
  @Override
  public T maximum() {
    T maximum;

    try {
      maximum = this.right.maximum();
    }
    catch (NothingThereException e) {
      maximum = this.data;
    }

    return maximum;
  }

  /**
   * Search to see if the specific data is present in the tree rooted at this node.
   * This method recursively searches the left or right subtree based on the comparison result.
   *
   * @param data the data to be searched
   * @return true if data is present in the tree, false otherwise
   */
  @Override
  public boolean contains(T data) {
    int compareResult = data.compareTo(this.data);

    if (compareResult==0)  {
      return true;
    }
    else if (compareResult<0) {
      return this.left.contains(data);
    }
    else {
      return this.right.contains(data);
    }
  }

  /**
   * Returns a string representation of the binary search tree rooted at this node.
   *
   * The string is formatted as d1 d2 ... dn, where d1, d2, ..., dn are the data elements
   * in the tree, ordered in ascending order.
   *
   * @return a string representation of the tree rooted at this node
   */
  @Override
  public String toString() {
    String left,right,middle;

    middle = this.data.toString();
    left = this.left.toString();
    right = this.right.toString();
    if (!left.isEmpty()) left = left + " ";
    if (!right.isEmpty()) right = " " + right;
    return left + middle + right;
  }

  /**
   * Traverse the tree rooted at this node in preorder and apply the consumer at each piece of data.
   *
   * @param consumer the function object to be applied at each piece of data
   */
  @Override
  public void preorder(Consumer<T> consumer) {
    consumer.accept(this.data);
    System.out.println(this.data);
    this.left.preorder(consumer);
    this.right.preorder(consumer);
  }


  /**
   * Traverse the tree rooted at this node in postorder and apply the consumer at each piece of data.
   * @param consumer the function object to be applied at each piece of data
   */
  @Override
  public void postorder(Consumer<T> consumer) {
    this.left.postorder(consumer);
    this.right.postorder(consumer);
    consumer.accept(this.data);
  }

  /**
   * Creates a deep copy of the BSTNode, including the data and its children.
   *
   * @return a new BSTNode that is a copy of the current node
   */
  @Override
  public BSTNode<T> copy() {
    return new BSTElementNode<>(this.data, this.left.copy(), this.right.copy());
  }

  /**
   * Checks if the current node is the same as the given node.
   *
   * @param other The node to compare against.
   * @return true if the nodes are the same, false otherwise.
   */
  @Override
  public boolean same(BSTNode<T> other) {
    if (!(other instanceof BSTElementNode)) {
      // if it's not a element node return false
      return false;
    }
    BSTElementNode<T> otherNode = (BSTElementNode<T>) other;
    // Compare data of current node and other node, and recursively check left and right subtrees.
    return this.data.equals(otherNode.data) && this.left.same(otherNode.left) && this.right.same(otherNode.right);
  }

}
