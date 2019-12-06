/**
 * <h1>Design Patterns - Composite Pattern</h1>
 *
 * <p>
 * Composite pattern is used where we need to treat a group of objects in similar way as a single
 * object. Composite pattern composes objects in term of a tree structure to represent part as well
 * as whole hierarchy. This type of design pattern comes under structural pattern as this pattern
 * creates a tree structure of group of objects.
 * </p>
 *
 * <p>
 * This pattern creates a class that contains group of its own objects. This class provides ways to
 * modify its group of same objects.
 * </p>
 *
 * <p>
 * We are demonstrating use of composite pattern via following example in which we will show
 * employees hierarchy of an organization.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We have a class <i>Employee</i> which acts as composite pattern actor class.
 * <i>CompositePatternDemo</i>, our demo class will use <i>Employee</i> class to add department
 * level hierarchy and print all employees.
 * </p>
 *
 * <p>
 * <img src="./composite_pattern_uml_diagram.jpg" alt="Composite Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./composite_pattern_uml_diagram.gif" alt="Composite Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package composites.employee;