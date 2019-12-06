/**
 * <h1>Design Patterns - Iterator Pattern</h1>
 *
 * <p>
 * Iterator pattern is very commonly used design pattern in Java and .Net programming environment.
 * This pattern is used to get a way to access the elements of a collection object in sequential
 * manner without any need to know its underlying representation.
 * </p>
 *
 * <p>
 * Iterator pattern falls under behavioral pattern category.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We're going to create a <i>Iterator</i> interface which narrates navigation method and a
 * <i>Container</i> interface which retruns the iterator . Concrete classes implementing the
 * <i>Container</i> interface will be responsible to implement <i>Iterator</i> interface and use it
 * </p>
 *
 * <p>
 * <i>IteratorPatternDemo</i>, our demo class will use <i>NamesRepository</i>, a concrete class
 * implementation to print a <i>Names</i> stored as a collection in <i>NamesRepository</i>.
 * </p>
 *
 * <p>
 * <img src="./iterator_pattern_uml_diagram.jpg" alt="Iterator Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./iterator_pattern_uml_diagram.gif" alt="Iterator Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package iterators.demo;