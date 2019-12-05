/**
 * <h1>Design Patterns - Mediator Pattern</h1>
 *
 * <p>
 * Mediator pattern is used to reduce communication complexity between multiple objects or classes.
 * This pattern provides a mediator class which normally handles all the communications between
 * different classes and supports easy maintenance of the code by loose coupling. Mediator pattern
 * falls under behavioral pattern category.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We are demonstrating mediator pattern by example of a chat room where multiple users can send
 * message to chat room and it is the responsibility of chat room to show the messages to all users.
 * We have created two classes <i>ChatRoom</i> and <i>User</i>. <i>User</i> objects will use
 * <i>ChatRoom</i> method to share their messages.
 * </p>
 *
 * <p>
 * <i>MediatorPatternDemo</i>, our demo class, will use <i>User</i> objects to show communication
 * between them.
 * </p>
 *
 * <p>
 * <img src="./mediator_pattern_uml_diagram.jpg" alt="Mediator Pattern Original UML Diagram"
 * width="100%">
 * </p>
 *
 * <p>
 * <img src="./mediator_pattern_uml_diagram.gif" alt="Mediator Pattern Actual UML Diagram"
 * width="100%">
 * </p>
 */
package chatroom;
