package cs207.linear;

/**
 * A really simple experiment with LinkedStack objects.
 *
 * @author Samuel A. Rebelsky.
 * @author Keely Miyamoto
 */
public class LinkedStackExpt {
  /**
   * Do all the work. (Well, make the helpers do all the work.)
   */
  public static void main(String[] args) throws Exception {
    LinearStructureExpt.expt01(new LinkedStack<String>(), "linked.");
    /** 
     * Exercise 1: Basic Experiments
     * linked.isEmpty(): true
     * linked.isFull(): false
     * linked.values: <none>
     * 
     * linked.put(a) OK
     * linked.isEmpty(): false
     * linked.isFull(): false
     * linked.values: a 
     * 
     * [Will look virtually same as above for put(b) and put(c), 
     * just with each val added to front of stack.]
     *  > b a     [not full, not empty]
     *  > c b a   [not full, not empty]
     * 
     * linked.get() = c
     * linked.isEmpty(): false
     * linked.isFull(): false
     * linked.values: b a 
     * 
     * put(d)
     *  > d b a  [not full, not empty]
     * get()
     *  > b a    [not full, not empty]
     * get()
     *  > a      [not full, not empty]
     * put(e)
     *  > e a    [not full, not empty]
     * 
     * clear() -> get(), get()
     *  > a 
     *  <empty>
     * 
     * put(f), put(g), put(h), put(i), put(j)
     *  > j i h g f  [not full, not empty]
     * 
     * get(f), get(g), get(h), get(i), get(j)
     *  <empty>  [not full]
     */
  } // main(String[])
} // class LinkedStackExpt
