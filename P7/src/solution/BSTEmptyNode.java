// BSTEmptyNode
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
 * This node represents an empty node in the binary search tree (i.e. the
 * leaves)
 */
public class BSTEmptyNode<T extends Comparable<T>> implements BSTNode<T> {
  @Override
  public BSTNode<T> insert(T data) {
    return new BSTElementNode(data,new BSTEmptyNode(),new BSTEmptyNode());
  }

  /**
   * Determine and return the minimum element in the tree rooted at this node.
   *
   * @return The minimum element in the tree
   * @throws NothingThereException if the tree does not have any data
   */
  @Override
  public T minimum() throws NothingThereException {
    throw new NothingThereException("Tree does not have any data");
  }

  /**
   * Determine and return the maximum element in the tree rooted at this node.
   *
   * @return The T type object of the node contains the largest element
   *
   * @throws NothingThereException If the tree does not have any data
   *
   * @since 1.0
   */
  @Override
  public T maximum() throws NothingThereException {
    throw new NothingThereException("Tree does not have any data");
  }

  /**
   * Search to see if the specific data is present in the tree rooted at this
   * node.
   *
   * @param data the data to be searched
   * @return true if the data is present in the tree, false otherwise
   */
  @Override
  public boolean contains(T data) {
    return false;
  }

  /**
   * Returns a string representation of the binary search tree rooted at this node.
   * The string is formatted as d1 d2 ... dn, where d1, d2, ..., dn are the data elements in the tree.
   *
   * @return a string representation of the binary search tree
   */
  @Override
  public String toString() {
    return "";
  }

  /**
   * Traverse the tree rooted at this node in preorder and apply the consumer at each piece of data.
   *
   * @param consumer The function object to be applied at each piece of data.
   */
  @Override
  public void preorder(Consumer<T> consumer) {
    System.out.println("Reach the leaves");
  }


  /**
   * Traverse the tree rooted at this node in postorder and apply the consumer at each piece of data.
   *
   * @param consumer the function object to be applied at each piece of data
   */
  @Override
  public void postorder(Consumer<T> consumer) {
    System.out.println("Reach the leaves");
  }

  /**
   * Creates a copy of the binary search tree rooted at this node.
   * The copy contains the same data and structure as the original tree.
   *
   * @return A new BSTNode object representing the copied tree
   */
  @Override
  public BSTNode<T> copy() {
    return new BSTEmptyNode<>();
  }

  /**
   * Determine whether the tree rooted at this node is the same (content and structure wise) as the tree rooted
   * at the given node.
   *
   * @param other the root of the other tree
   * @return true if the two trees are the same, false otherwise
   */
  @Override
  public boolean same(BSTNode<T> other) {
    return other instanceof BSTEmptyNode;
  }
}
