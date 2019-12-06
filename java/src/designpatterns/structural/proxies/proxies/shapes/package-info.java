/**
 * <h1>Design Patterns - Proxy Pattern</h1>
 *
 * <p>
 * In proxy pattern, a class represents functionality of another class. This type of design pattern
 * comes under structural pattern.
 * </p>
 *
 * <p>
 * In proxy pattern, we create object having original object to interface its functionality to outer
 * world.
 * </p>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We are going to create an <i>Image</i> interface and concrete classes implementing the
 * <i>Image</i> interface. <i>ProxyImage</i> is a a proxy class to reduce memory footprint of
 * <i>RealImage</i> object loading.
 * </p>
 *
 * <p>
 * <i>ProxyPatternDemo</i>, our demo class, will use <i>ProxyImage</i> to get an <i>Image</i> object
 * to load and display as it needs.
 * </p>
 *
 * <p>
 * <img src="./proxy_pattern_uml_diagram.jpg" alt="Proxy Pattern Original UML Diagram" width="100%">
 * </p>
 *
 * <p>
 * <img src="./proxy_pattern_uml_diagram.gif" alt="Proxy Pattern Actual UML Diagram" width="100%">
 * </p>
 *
 */
package proxies.shapes;