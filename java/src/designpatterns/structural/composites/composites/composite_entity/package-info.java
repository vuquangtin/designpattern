/**
 * <h1>Design Patterns - Composite Entity Pattern</h1>
 *
 * <p>
 * Composite Entity pattern is used in EJB persistence mechanism. A Composite entity is an EJB
 * entity bean which represents a graph of objects. When a composite entity is updated, internally
 * dependent objects beans get updated automatically as being managed by EJB entity bean. Following
 * are the participants in Composite Entity Bean.
 * </p>
 *
 * <ul>
 * <li><b>Composite Entity</b> - It is primary entity bean. It can be coarse grained or can contain
 * a coarse grained object to be used for persistence purpose.</li>
 * <li><b>Coarse-Grained Object</b> - This object contains dependent objects. It has its own life
 * cycle and also manages life cycle of dependent objects.</li>
 * <li><b>Dependent Object</b> - Dependent object is an object which depends on coarse grained
 * object for its persistence lifecycle.</li>
 * <li><b>Strategies</b> - Strategies represents how to implement a Composite Entity.</li>
 * </ul>
 *
 * <h2>Implementation</h2>
 *
 * <p>
 * We are going to create <i>CompositeEntity</i> object acting as CompositeEntity.
 * <i>CoarseGrainedObject</i> will be a class which contains dependent objects.
 * <i>CompositeEntityPatternDemo</i>, our demo class will use <i>Client</i> class to demonstrate use
 * of Composite Entity pattern.
 * </p>
 *
 * <p>
 * <img src="./compositeentity_pattern_uml_diagram.jpg"
 * alt="Composite Entity Pattern Original UML Diagram" width="100%">
 * </p>
 *
 * <p>
 * <img src="./compositeentity_pattern_uml_diagram.gif"
 * alt="Composite Entity Pattern Actual UML Diagram" width="100%">
 * </p>
 */
package composites.composite_entity;