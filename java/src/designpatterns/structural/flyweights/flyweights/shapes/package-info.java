/**
 * <h1>Design Patterns - Flyweight Pattern</h1>
 *
 * <p>
 * Flyweight pattern is primarily used to reduce the number of objects created and to decrease
 * memory footprint and increase performance. This type of design pattern comes under structural
 * pattern as this pattern provides ways to decrease object count thus improving the object
 * structure of application.
 * </p>
 *
 * <p>
 * Flyweight pattern tries to reuse already existing similar kind objects by storing them and
 * creates new object when no matching object is found. We will demonstrate this pattern by drawing
 * 20 circles of different locations but we will create only 5 objects. Only 5 colors are available
 * so color property is used to check already existing Circle objects.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We are going to create a <i>Shape</i> interface and concrete class <i>Circle</i> implementing the
 * <i>Shape</i> interface. A factory class <i>ShapeFactory</i> is defined as a next step.
 * </p>
 *
 * <p>
 * <i>ShapeFactory</i> has a <i>HashMap</i> of <i>Circle</i> having key as color of the
 * <i>Circle</i> object. Whenever a request comes to create a circle of particular color to
 * <i>ShapeFactory</i>, it checks the circle object in its <i>HashMap</i>, if object of
 * <i>Circle</i> found, that object is returned otherwise a new object is created, stored in hashmap
 * for future use, and returned to client.
 * </p>
 *
 * <p>
 * <i>FlyWeightPatternDemo</i>, our demo class, will use <i>ShapeFactory</i> to get a <i>Shape</i>
 * object. It will pass information (<i>red / green / blue/ black / white</i>) to
 * <i>ShapeFactory</i> to get the circle of desired color it needs.
 * </p>
 *
 * <p>
 * <img src="./flyweight_pattern_uml_diagram.jpg" alt="Flyweight Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./flyweight_pattern_uml_diagram.gif" alt="Flyweight Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package flyweights.shapes;