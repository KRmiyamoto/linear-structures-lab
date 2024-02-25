package cs207.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple linked implementation of stacks.
 *
 * @author Samuel A. Rebelsky
 * @author Keely Miyamoto
 */
public class LinkedStack<T> implements Stack<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The top of the stack.
   */
  Node<T> top;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new stack.
   */
  public LinkedStack() {
    this.top = null;
  } // LinkedStack(int)

  // +-------------------------+-----------------------------------------
  // | LinearStructure Methods |
  // +-------------------------+

  /**
   * Exercise 5: Exploring linked stacks
   * 
   * I missed that 'isFull()' would uniformly return false. I now recall from 
   * the reading that this is because either the stack does not fill, or, if
   * it does, we will not have space to create even an exception object. 
   *  
   */

  @Override
  public boolean isEmpty() {
    return this.top == null;
  } // isEmpty()

  @Override
  public boolean isFull() {
    return false;
  } // isFull()

  @Override
  public T peek() {
    return this.top.value;
  } // peek()

  @Override
  public void put(T val) throws Exception {
    if (this.isFull()) {
      throw new Exception("full");
    } // if full
    this.top = new Node<T>(val, this.top);
  } // put(T)

  @Override
  public T get() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("empty");
    } // if empty
    T result = this.top.value;
    this.top = this.top.next;
    return result;
  } // get()

  @Override
  public Iterator<T> iterator() {
    return new LinkedStackIterator<T>(this);
  } // iterator()

  // +---------------+---------------------------------------------------
  // | Stack Methods |
  // +---------------+

  @Override
  public void push(T val) throws Exception {
    this.put(val);
  } // push(T)

  @Override
  public T pop() throws Exception {
    return this.get();
  } // pop

} // LinkedStack<T>


class LinkedStackIterator<T> implements Iterator<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The next node in the iteration.
   */
  Node<T> next;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public LinkedStackIterator(LinkedStack<T> ls) {
    this.next = ls.top;
  } // LinkedStackIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next() throws NoSuchElementException {
    T result = this.next.value;
    this.next = this.next.next;
    return result;
  } // next()

  @Override
  public boolean hasNext() {
    return (this.next != null);
  } // hasNext()

  @Override
  public void remove() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  } // remove()
} // LinkedStackIterator<T>
