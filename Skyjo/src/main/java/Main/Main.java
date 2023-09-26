package Main;

import Controller.Controller;
import Model.Game;
import View.SkyjoGui;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * The type Main.
 */
public class Main extends Application{


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) {
        Game game = new Game();
        SkyjoGui view = new SkyjoGui();
        Controller controller = new Controller(game,view);
        controller.addObserver();
        controller.start(stage).show();
        controller.playGame();

    }


}