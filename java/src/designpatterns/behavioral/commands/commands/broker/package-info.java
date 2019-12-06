/**
 * <h1>Design Patterns - Command Pattern</h1>
 *
 * <p>
 * Command pattern is a data driven design pattern and falls under behavioral pattern category. A
 * request is wrapped under an object as command and passed to invoker object. Invoker object looks
 * for the appropriate object which can handle this command and passes the command to the
 * corresponding object which executes the command.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We have created an interface <i>Order</i> which is acting as a command. We have created a
 * <i>Stock</i> class which acts as a request. We have concrete command classes <i>BuyStock</i> and
 * <i>SellStock</i> implementing <i>Order</i> interface which will do actual command processing. A
 * class <i>Broker</i> is created which acts as an invoker object. It can take and place orders.
 * </p>
 *
 * <p>
 * <i>Broker</i> object uses command pattern to identify which object will execute which command
 * based on the type of command. <i>CommandPatternDemo</i>, our demo class, will use <i>Broker</i>
 * class to demonstrate command pattern.
 * </p>
 *
 * <p>
 * <img src="./command_pattern_uml_diagram.jpg" alt="Command Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./command_pattern_uml_diagram.gif" alt="Command Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 *
 */
package commands.broker;