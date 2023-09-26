package View;

import Controller.Controller;
import Handlers.CardPlayerHandler;
import Model.Player;
import javafx.scene.layout.GridPane;

/**
 * The type Cards of players ui.
 */
public class CardsOfPlayersUi extends GridPane {

    /**
     * Instantiates a new Cards of players ui.
     *
     * @param p          the p
     * @param controller the controller
     */
    public CardsOfPlayersUi(Player p, Controller controller) {
        CardPlayerHandler PlayerHandler = new CardPlayerHandler(controller);
        int indexCard = 0;

        for (int column = 0; column < 4; column++) {
            for (int line = 0; line < 3; line++) {
                CardUi Card = new CardUi(p.getListCards().get(indexCard));
                Card.setIdCardOfPlayer(indexCard);
                Card.setIdPlayer(p.getIdOwnerOfCards());

                if (p.getIdOwnerOfCards().equals(controller.idCurrentPlayer())) {
                    Card.setOnAction(PlayerHandler);
                }
                this.add(Card, column, line);
                indexCard++;
            }

            this.setHgap(5);
            this.setVgap(5);
        }

    }


}