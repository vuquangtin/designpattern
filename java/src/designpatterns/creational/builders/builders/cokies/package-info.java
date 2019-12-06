/**
 * <h1>Design Patterns - Builder Pattern</h1>
 *
 * <p>
 * Builder pattern builds a complex object using simple objects and using a step by step approach.
 * This type of design pattern comes under creational pattern as this pattern provides one of the
 * best ways to create an object.
 * </p>
 *
 * <p>
 * A Builder class builds the final object step by step. This builder is independent of other
 * objects.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We have considered a business case of fast-food restaurant where a typical meal could be a burger
 * and a cold drink. Burger could be either a Veg Burger or Chicken Burger and will be packed by a
 * wrapper. Cold drink could be either a coke or pepsi and will be packed in a bottle.
 * </p>
 *
 * <p>
 * We are going to create an <i>Item</i> interface representing food items such as burgers and cold
 * drinks and concrete classes implementing the <i>Item</i> interface and a <i>Packing</i> interface
 * representing packaging of food items and concrete classes implementing the <i>Packing</i>
 * interface as burger would be packed in wrapper and cold drink would be packed as bottle.
 * </p>
 *
 * <p>
 * We then create a <i>Meal</i> class having <i>ArrayList</i> of <i>Item</i> and a
 * <i>MealBuilder</i> to build different types of <i>Meal</i> objects by combining <i>Item</i>.
 * <i>BuilderPatternDemo</i>, our demo class will use <i>MealBuilder</i> to build a <i>Meal</i>.
 * </p>
 *
 * <p>
 * <img src="./builder_pattern_uml_diagram.jpg" alt="Builder Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./builder_pattern_uml_diagram.gif" alt="Builder Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package builders.cokies;