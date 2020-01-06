package mediators.app.editor.components;

import mediators.app.editor.Mediator;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
//Interface for the components that would normally be related
public interface NoteComponent {
  void setMediator(Mediator mediator);	//There will be a relation through the mediator
  String getName();
}