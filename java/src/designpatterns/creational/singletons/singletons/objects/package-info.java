/**
 * <h1>Design Pattern - Singleton Pattern</h1>
 *
 * <p>
 * Singleton pattern is one of the simplest design patterns in Java. This type of design pattern
 * comes under creational pattern as this pattern provides one of the best ways to create an object.
 * </p>
 *
 * <p>
 * This pattern involves a single class which is responsible to create an object while making sure
 * that only single object gets created. This class provides a way to access its only object which
 * can be accessed directly without need to instantiate the object of the class.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We're going to create a <i>SingleObject</i> class. <i>SingleObject</i> class have its constructor
 * as private and have a static instance of itself.
 * </p>
 *
 * <p>
 * <i>SingleObject</i> class provides a static method to get its static instance to outside world.
 * <i>SingletonPatternDemo</i>, our demo class will use <i>SingleObject</i> class to get a
 * <i>SingleObject</i> object.
 * </p>
 *
 * <p>
 * <img src="./singleton_pattern_uml_diagram.jpg" alt="Singleton Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./singleton_pattern_uml_diagram.gif" alt="Singleton Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package singletons.objects;