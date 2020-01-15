package builders.app;

import builders.app.controller.ConnectFourController;
import builders.app.model.ConnectFourModel;
import builders.app.view.ConnectFourView;

/**
 * 
 * This class creates a model, view and controller, and launches the game
 * by calling the controller's run method on model and view. 
 * 
 * By default both players are selected as 'human', however one can change 
 * this selection before hitting the start button. After one game finishes
 * the options will be reset to default.
 * 
 * It is also possible to make two bot players against each other. There
 * is a programmed randomized delay in this mode to make the animation
 * slow enough to see transitions.
 * 
 * @author abhishek bhunia
 *
 */
public class GameMain {
  
  public static void main(String[] args) {
    ConnectFourController controller = new ConnectFourController();
    ConnectFourModel model = new ConnectFourModel();
    ConnectFourView view = new ConnectFourView(controller);
    controller.run(model, view);
  }
}
