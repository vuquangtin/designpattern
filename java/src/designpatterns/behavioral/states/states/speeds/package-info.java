/**
 * <h1>Design Patterns - State Pattern</h1>
 *
 * <p>
 * In State pattern a class behavior changes based on its state. This type of design pattern comes
 * under behavior pattern.
 * </p>
 *
 * <p>
 * In State pattern, we create objects which represent various states and a context object whose
 * behavior varies as its state object changes.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We are going to create a <i>State</i> interface defining an action and concrete state classes
 * implementing the <i>State</i> interface. <i>Context</i> is a class which carries a State.
 * </p>
 *
 * <p>
 * <i>StatePatternDemo</i>, our demo class, will use <i>Context</i> and state objects to demonstrate
 * change in Context behavior based on type of state it is in.
 * </p>
 *
 * <p>
 * <img src="./state_pattern_uml_diagram.jpg" alt="State Pattern Original UML Diagram" width="100%">
 * </p>
 *
 * <p>
 * <img src="./state_pattern_uml_diagram.gif" alt="State Pattern Actual UML Diagram" width="100%">
 * </p>
 */
package states.speeds;