/**
 * <h1>Design Patterns - Observer Pattern</h1>
 *
 * <p>
 * Observer pattern is used when there is one-to-many relationship between objects such as if one
 * object is modified, its depenedent objects are to be notified automatically. Observer pattern
 * falls under behavioral pattern category.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * Observer pattern uses three actor classes. Subject, Observer and Client. Subject is an object
 * having methods to attach and detach observers to a client object. We have created an abstract
 * class <i>Observer</i> and a concrete class <i>Subject</i> that is extending class
 * <i>Observer</i>.
 * </p>
 *
 * <p>
 * <i>ObserverPatternDemo</i>, our demo class, will use <i>Subject</i> and concrete class object to
 * show observer pattern in action.
 * </p>
 *
 * <p>
 * <img src="./observer_pattern_uml_diagram.jpg" alt="Observer Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./observer_pattern_uml_diagram.gif" alt="Observer Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package observers.converts;