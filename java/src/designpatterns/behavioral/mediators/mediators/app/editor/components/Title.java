package mediators.app.editor.components;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

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

@SuppressWarnings("serial")
public class Title extends JTextField implements NoteComponent {
	
//  Concrete components don't reference each other. 
//  They have only one way of communicating: sending requests to the mediator.
	
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "Title";
    }
}