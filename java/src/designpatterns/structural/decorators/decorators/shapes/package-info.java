/**
 * <h1>Design Patterns - Decorator Pattern</h1>
 *
 * <p>
 * Decorator pattern allows a user to add new functionality to an existing object without altering
 * its structure. This type of design pattern comes under structural pattern as this pattern acts as
 * a wrapper to existing class.
 * </p>
 *
 * <p>
 * This pattern creates a decorator class which wraps the original class and provides additional
 * functionality keeping class methods signature intact.
 * </p>
 *
 * <p>
 * We are demonstrating the use of decorator pattern via following example in which we will decorate
 * a shape with some color without alter shape class.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We're going to create a <i>Shape</i> interface and concrete classes implementing the <i>Shape</i>
 * interface. We will then create an abstract decorator class <i>ShapeDecorator</i> implementing the
 * <i>Shape</i> interface and having <i>Shape</i> object as its instance variable.
 * </p>
 *
 * <p>
 * <i>RedShapeDecorator</i> is concrete class implementing <i>ShapeDecorator</i>.
 * </p>
 *
 * <p>
 * <i>DecoratorPatternDemo</i>, our demo class will use <i>RedShapeDecorator</i> to decorate
 * <i>Shape</i> objects.
 * </p>
 *
 * <p>
 * <img src="./decorator_pattern_uml_diagram.jpg" alt="Decorator Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./decorator_pattern_uml_diagram.gif" alt="Decorator Pattern UML Actual Diagram"
 * width="100%">
 * </p>
 *
 */
package decorators.shapes;