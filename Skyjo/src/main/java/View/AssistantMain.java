package View;

import Controller.Controller;
import Model.DeckCards;
import Model.DefausseCards;
import Model.Game;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * The type Assistant main.
 */
public class AssistantMain extends HBox {

    private PlayerUi p1;
    private PlayerUi p2;
    private CenterOfGameUi centerofgame;
    private final Controller controller;

    /**
     * Instantiates a new Assistant main.
     *
     * @param controller of  the game
     */
    public AssistantMain(Controller controller) {
        super(20);
        DeckCards deck = controller.getGame().getDeck();
        this.controller = controller;

        p1 = new PlayerUi(controller.getGame().getPlayer1(), this.controller);
        p2 = new PlayerUi(controller.getGame().getPlayer2(), this.controller);

        DefausseCards def = controller.getGame().getDefausse();
        centerofgame = new CenterOfGameUi(deck, def, controller);

        this.getChildren().addAll(p1, centerofgame, p2);
        this.setAlignment(Pos.CENTER);
    }


    /**
     * Refresh.
     *
     * @param game the game
     */
    public void refresh(Game game) {
        this.getChildren().removeAll(p1, centerofgame, p2);
        p1 = new PlayerUi(game.getPlayer1(), controller);
        p2 = new PlayerUi(game.getPlayer2(), controller);
        centerofgame = new CenterOfGameUi(game.getDeck(), game.getDefausse(), controller);
        this.getChildren().addAll(p1, centerofgame, p2);
        System.out.println("game refreshed");
    }
}
