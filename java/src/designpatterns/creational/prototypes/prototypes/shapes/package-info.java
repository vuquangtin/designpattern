/**
 * <h1>Design Patterns - Prototype Pattern</h1>
 *
 * <p>
 * Prototype pattern refers to creating duplicate object while keeping performance in mind. This
 * type of design pattern comes under creational pattern as this pattern provides one of the best
 * ways to create an object.
 * </p>
 *
 * <p>
 * This pattern involves implementing a prototype interface which tells to create a clone of the
 * current object. This pattern is used when creation of object directly is costly. For example, an
 * object is to be created after a costly database operation. We can cache the object, returns its
 * clone on next request and update the database as and when needed thus reducing database calls.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We're going to create an abstract class <i>Shape</i> and concrete classes extending the
 * <i>Shape</i> class. A class <i>ShapeCache</i> is defined as a next step which stores shape
 * objects in a <i>Hashtable</i> and returns their clone when requested.
 * </p>
 *
 * <p>
 * <i>PrototypPatternDemo</i>, our demo class will use <i>ShapeCache</i> class to get a <i>Shape</i>
 * object.
 * </p>
 *
 * <p>
 * <img src="./prototype_pattern_uml_diagram.jpg" alt="Prototype Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./prototype_pattern_uml_diagram.gif" alt="Prototype Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package prototypes.shapes;

