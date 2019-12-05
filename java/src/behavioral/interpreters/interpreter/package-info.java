/**
 * <h1>Design Patterns - Interpreter Pattern</h1>
 *
 * <p>
 * Interpreter pattern provides a way to evaluate language grammar or expression. This type of
 * pattern comes under behavioral pattern. This pattern involves implementing an expression
 * interface which tells to interpret a particular context. This pattern is used in SQL parsing,
 * symbol processing engine etc.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We are going to create an interface <i>Expression</i> and concrete classes implementing the
 * <i>Expression</i> interface. A class <i>TerminalExpression</i> is defined which acts as a main
 * interpreter of context in question. Other classes <i>OrExpression</i>, <i>AndExpression</i> are
 * used to create combinational expressions.
 * </p>
 *
 * <p>
 * <i>InterpreterPatternDemo</i>, our demo class, will use <i>Expression</i> class to create rules
 * and demonstrate parsing of expressions.
 * </p>
 *
 * <p>
 * <img src="./interpreter_pattern_uml_diagram.jpg" alt="Interpreter Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./interpreter_pattern_uml_diagram.gif" alt="Interpreter Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package interpreter;