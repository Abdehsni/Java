package View;


import Controller.Controller;
import Model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


/**
 * The type Player ui.
 */
public class PlayerUi extends VBox {

    private CardsOfPlayersUi cards;

    /**
     * Instantiates a new Player ui.
     *
     * @param player     the player
     * @param controller the controller
     */
    public PlayerUi(Player player, Controller controller) {
        super(10);
        Label labelPlayer = new Label("Joueur " + player.getIdOwnerOfCards().getValue() + " ,Points: " + player.getScore());
        labelPlayer.setStyle(" -fx-background-color : yellow;" + "-fx-background-radius: 15;");
        labelPlayer.setAlignment(Pos.CENTER);
        labelPlayer.setPrefWidth(200);
        cards = new CardsOfPlayersUi(player,controller);

        this.getChildren().addAll(labelPlayer,cards);
        this.setAlignment(Pos.CENTER);

    }

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public CardsOfPlayersUi getCards() {
        return cards;
    }

    /**
     * Sets cards.
     *
     * @param cards the cards
     */
    public void setCards(CardsOfPlayersUi cards) {
        this.cards = cards;
    }


}
