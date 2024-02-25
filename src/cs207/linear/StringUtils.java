package cs207.linear;

import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 *
 * @author Samuel A. Rebelsky
 * @author Keely Miyamoto
 */
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+

  /**
   * Exercise 4: Matching Parens
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) {
    Stack<Character> parens = new LinkedStack<Character>();
    PrintWriter redpen = new PrintWriter(System.err, true);
    for (char c : str.toCharArray()) {
      if ((c == '(') || (c == '[')) {
        try {
          parens.push(c);
        } catch (Exception e) {
          redpen.println("Error: Unable to push parens.");
          return false;
        }
      } else if (c == ')') {
        if (parens.isEmpty()) {
          redpen.println("Error: Mismatched parens.");
          return false;
        } // if
        try{
          if (parens.peek() == '(') {
            parens.pop();
          } else { 
            redpen.println("Error: Mismatched parens.");
            return false;
          }
        } catch (Exception e) {
          redpen.println("Error: Unable to pop parens.");
          return false;
        } 
      } else if (c == ']') {
        if (parens.isEmpty()) {
          redpen.println("Error: Mismatched parens.");
          return false;
        } // if
        try{
          if (parens.peek() == '[') {
            parens.pop();
          } else { 
            redpen.println("Error: Mismatched parens.");
            return false;
          }
        } catch (Exception e) {
          redpen.println("Error: Unable to pop parens.");
          return false;
        }    
      } // if
    } // for
    if (!parens.isEmpty()) {
      return false;
    } 
    return true;
  } // checkMatching

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+
  /**
   * A quick set of experiments with checkMatching.
   */
  static void checkMatchingExperiments(PrintWriter pen) {
    checkMatchingExperiment(pen, "");
    checkMatchingExperiment(pen, "()");
    checkMatchingExperiment(pen, "(");
    checkMatchingExperiment(pen, ")");
    checkMatchingExperiment(pen, "[]()");
    checkMatchingExperiment(pen, "[()([])]");
    checkMatchingExperiment(pen, "[a(b]c)");
    checkMatchingExperiment(pen, "Hello (there) (world (!!))");
    checkMatchingExperiment(pen, "alphabetical");
    checkMatchingExperiment(pen, "((((((((a))))))))");
    checkMatchingExperiment(pen, "((((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a)))))]))");
    checkMatchingExperiment(pen, "(([((((((a))))))])");
    checkMatchingExperiment(pen, "((((b)(((((a)(c)))(d))))))");
    // Feel free to add your own
  } // PrintWriter()

  /**
   * A single experiment with checkMatching.
   */
  static void checkMatchingExperiment(PrintWriter pen, String str) {
    pen.print("checkMatching(\"" + str + "\") = ");
    pen.flush();
    try {
      pen.println(checkMatching(str));
    } catch (Exception e) {
      pen.println("*** ERROR *** " + e.toString());
    }
  } // checkMatchingExperiment(PrintWriter, String)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run a few experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    checkMatchingExperiments(pen);
    pen.close();
  } // main(String[])
} // class StringUtils
