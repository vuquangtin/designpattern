/**
 * <h1>Design Patterns - Memento Pattern</h1>
 *
 * <p>
 * Memento pattern is used to restore state of an object to a previous state. Memento pattern falls
 * under behavioral pattern category.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * Memento pattern uses three actor classes. Memento contains state of an object to be restored.
 * Originator creates and stores states in Memento objects and Caretaker object is responsible to
 * restore object state from Memento. We have created classes <i>Memento</i>, <i>Originator</i> and
 * <i>CareTaker</i>.
 * </p>
 *
 * <p>
 * <i>MementoPatternDemo</i>, our demo class, will use <i>CareTaker</i> and <i>Originator</i>
 * objects to show restoration of object states.
 * </p>
 *
 * <p>
 * <img src="./memento_pattern_uml_diagram.jpg" alt="Memento Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./memento_pattern_uml_diagram.gif" alt="Memento Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package memento;