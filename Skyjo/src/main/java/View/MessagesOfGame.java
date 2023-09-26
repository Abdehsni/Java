package View;

import Model.Game;
import Model.GameState;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

/**
 * The type Messages of game.
 */
public class MessagesOfGame extends Label {


    /**
     * Instantiates a new Messages of game.
     *
     * @param game the game
     */
    public MessagesOfGame(Game game) {
        super();
        GameState state = game.getState();
        int joueur = 1;
        if (!game.isPlayer1Turn()) joueur = 2;

        switch (state) {
            case START:
                setText("Le joueur " + joueur + " commence");
                break;
            case TAKE_CARD:
                setText("Joueur " + joueur + " ,tirez une carte du deck ou de la defausse");
                break;
            case DECK:
                setText("Joueur " + joueur + ",défaussez ou échangez la carte avec l'une de votre jeu");
                break;
            case DEFAUSSE:
                setText("Joueur " + joueur + ",choisissez une carte dans votre jeu pour l'échanger avec celle de la défausse");
                break;
            case DROP:
                setText("Joueur " + joueur + ",dévoilez une de vos carte de votre jeu");
                break;
            case END:
                setText("Joueur" + game.winner().getIdOwnerOfCards().getValue() + "a gagné avec : "+ game.winner().getScore());
            default:
                break;
        }

        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setStyle("-fx-background-color: azure ;");
    }
}
