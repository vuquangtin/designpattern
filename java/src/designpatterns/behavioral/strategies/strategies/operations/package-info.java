/**
 * <h1>Design Patterns - Strategy Pattern</h1>
 *
 * <p>
 * In Strategy pattern, a class behavior or its algorithm can be changed at run time. This type of
 * design pattern comes under behavior pattern.
 * </p>
 *
 * <p>
 * In Strategy pattern, we create objects which represent various strategies and a context object
 * whose behavior varies as per its strategy object. The strategy object changes the executing
 * algorithm of the context object.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We are going to create a <i>Strategy</i> interface defining an action and concrete strategy
 * classes implementing the <i>Strategy</i> interface. <i>Context</i> is a class which uses a
 * Strategy.
 * </p>
 *
 * <p>
 * <i>StrategyPatternDemo</i>, our demo class, will use <i>Context</i> and strategy objects to
 * demonstrate change in Context behaviour based on strategy it deploys or uses.
 * </p>
 *
 * <p>
 * <img src="./strategy_pattern_uml_diagram.jpg" alt="Strategy Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./strategy_pattern_uml_diagram.gif" alt="Strategy Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package strategies.operations;