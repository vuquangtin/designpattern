/**
 * <h1>Design Patterns - Visitor Pattern</h1>
 *
 * <p>
 * In Visitor pattern, we use a visitor class which changes the executing algorithm of an element
 * class. By this way, execution algorithm of element can vary as and when visitor varies. This
 * pattern comes under behavior pattern category. As per the pattern, element object has to accept
 * the visitor object so that visitor object handles the operation on the element object.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We are going to create a <i>ComputerPart</i> interface defining accept
 * opearation.<i>Keyboard</i>, <i>Mouse</i>, <i>Monitor</i> and <i>Computer</i> are concrete classes
 * implementing <i>ComputerPart</i> interface. We will define another interface
 * <i>ComputerPartVisitor</i> which will define a visitor class operations. <i>Computer</i> uses
 * concrete visitor to do corresponding action.
 * </p>
 *
 * <p>
 * <i>VisitorPatternDemo</i>, our demo class, will use <i>Computer</i> and
 * <i>ComputerPartVisitor</i> classes to demonstrate use of visitor pattern.
 * </p>
 *
 * <p>
 * <img src="./visitor_pattern_uml_diagram.jpg" alt="Visitor Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./visitor_pattern_uml_diagram.gif" alt="Visitor Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package visitors.computers;