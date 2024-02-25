package cs207.linear;

import java.io.PrintWriter;
import java.util.Iterator;

/**
 * LinearStructures that report on the operations they perform.
 *
 * @author Samuel A. Rebelsky
 * @author Keely Miyamoto
 * 
 * Exercise 2: A wrapper class
 * The ReportingLinearStructure class is constituted by a linear structure 'ls',
 * a PrintWriter 'pen', and String that represents the "name" of the LinearStructure
 * that the ReportingLinearStructure is documenting. Essentially, this class 
 * Overwrites the methods of the LinearStructure interfaces so as to not only
 * perform the given methods on 'ls', but to write the resulting output of each 
 * step to the terminal using 'pen'.
 *  1. We can Override the methods of an interface to add features, such as printing.
 *  2. A wrapper class allows us to print output that summarizes the processes in a 
 *     multi-step procedure. (e.g., 'clear' will call get() repeatedly...)
 *  3. We can also add methods (e.g., 'info') to have more ways to output the current
 *     state of some object.
 */
public class ReportingLinearStructure<T> implements LinearStructure<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The underlying structure we're using for an experiment.
   */
  LinearStructure<T> ls;

  /**
   * The PrintWriter we use to generate output.
   */
  PrintWriter pen;

  /**
   * The prefix used for output.
   */
  String prefix;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new experiment that uses `ls` to do the work and prints comments 
   * using `pen`, with each comment prefixed by `prefix`.
   */
  public ReportingLinearStructure(LinearStructure<T> ls, PrintWriter pen, String prefix) {
    this.ls = ls;
    this.pen = pen;
    this.prefix = prefix;
  } // ReportingLinearStructure(LinearStructure<T>, PrintWriter)

  /**
   * Build a new experiment that uses ls to do the real work and prints 
   * comments to stdout using the specified prefix.
   */
  public ReportingLinearStructure(LinearStructure<T> ls, String prefix) {
    this(ls, new PrintWriter(System.out, true), prefix);
  } // ReportingLinearStructure(LinearStructure<T>)

  /**
   * Build a new experiment that uses ls to do the real work and prints 
   * comments to stdout using no prefix.
   */
  public ReportingLinearStructure(LinearStructure<T> ls) {
    this(ls, new PrintWriter(System.out, true), "");
  } // ReportingLinearStructure(LinearStructure<T>)

  // +-------------------------+-----------------------------------------
  // | LinearStructure Methods |
  // +-------------------------+

  @Override
  public void put(T val) throws Exception {
    pen.print(prefix + "put(" + val + ") ");
    pen.flush();
    try {
      ls.put(val);
    } catch (Exception e) {
      pen.println("[FAILED: " + e + "]");
    } // try/catch
    pen.println("OK");
  } // put(T)

  @Override
  public T get() throws Exception {
    pen.print(prefix + "get() = ");
    pen.flush();
    try {
      T result = ls.get();
      pen.println(result);
      return result;
    } catch (Exception e) {
      pen.println("[FAILED: " + e + "]");
      return null;
    } // try/catch
  } // get()

  @Override
  public T peek() throws Exception {
    pen.print(prefix + "peek() = ");
    pen.flush();
    try {
      T result = ls.peek();
      pen.println(result);
      return result;
    } catch (Exception e) {
      pen.println("[FAILED: " + e + "]");
      return null;
    } // try/catch
  } // peek()

  @Override
  public boolean isEmpty() {
    boolean result = ls.isEmpty();
    pen.println(prefix + "isEmpty(): " + result);
    return result;
  } // isEmpty()

  @Override
  public boolean isFull() {
    boolean result = ls.isFull();
    pen.println(prefix + "isFull(): " + result);
    return result;
  } // isFull()

  /**
   * Build an iterator for the structure.
   */
  public Iterator<T> iterator() {
    return ls.iterator();
  } // iterator()

  // +--------------------+----------------------------------------------
  // | Additional Methods |
  // +--------------------+

  /**
   * Print info on the structure.
   */
  public void info() {
    this.isEmpty();
    this.isFull();
    pen.print(prefix + "values: ");
    for (T val : ls) {
      try {
        pen.print(val + " ");
      } catch (Exception e) {
        pen.print("[" + e + "] ");
      } // try/catch
    } // for
    pen.println();
  } // dump

  /**
   * Remove all of the elements in the structure, printing them out as we go.
   */
  public void clear() {
    pen.println(prefix + "<clearing>");
    while (!ls.isEmpty()) {
      try {
        this.get();
      } catch (Exception e) {
      } // try/catch
    } // while
    pen.println(prefix + "</clearing>");
  } // clear

} // class ReportingLinearStructure<T>
