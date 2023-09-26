package View;

import Controller.Controller;
import Model.Game;
import Observable_Observer.Observable;
import Observable_Observer.Observer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The type Skyjo gui.
 */
public class SkyjoGui implements Observer {

    private VBox main;
    private AssistantMain assistantMain;
    private MessagesOfGame labelBottomPage;


    /**
     * Start view stage.
     *
     * @param primaryStage the primary stage
     * @param controller   the controller
     * @return the stage
     */
    public Stage startView(Stage primaryStage,Controller controller){
        primaryStage.setTitle("Skyjo");
        primaryStage.setMinWidth(650);
        primaryStage.setMinHeight(450);
        primaryStage.setMaxWidth(850);
        primaryStage.setMaxHeight(500);
        main = new VBox(10);
        assistantMain = new AssistantMain(controller);
        labelBottomPage = new MessagesOfGame(controller.getGame());
        main.getChildren().addAll(assistantMain, labelBottomPage);
        main.setStyle("-fx-background-color : green ;");
        main.setAlignment(Pos.CENTER);
        Scene scene = new Scene(main);
        primaryStage.setScene(scene);
        return primaryStage;
    }



    @Override
    public void update(Observable observable, Object arg) {
        Game game = (Game) observable;
        assistantMain.refresh(game);
        refreshLabel(game);
    }


    private void refreshLabel(Game game){
        main.getChildren().removeAll(labelBottomPage);
        labelBottomPage = new MessagesOfGame(game);
        main.getChildren().addAll(labelBottomPage);
    }
}