package View;

import Controller.Controller;
import Handlers.CardDeckHandler;
import Handlers.CardDefausseHandler;
import Model.DeckCards;
import Model.DefausseCards;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * The type Center of game ui.
 */
public class CenterOfGameUi extends GridPane {

    private final CardUi deckView;
    private final CardUi defausseView;

    /**
     * Instantiates a new Center of game ui.(deck of the game and defausse of the game)
     *
     * @param deck       the deck
     * @param defausse   the defausse
     * @param controller the controller
     */
    public CenterOfGameUi(DeckCards deck, DefausseCards defausse,Controller controller) {
        CardDeckHandler DeckHandler = new CardDeckHandler(controller);
        CardDefausseHandler DeffausseHandler = new CardDefausseHandler(controller);
        deckView = new CardUi(deck.getFirst());
        defausseView = new CardUi(defausse.getfirst());
        deckView.setOnAction(DeckHandler);
        defausseView.setOnAction(DeffausseHandler);
        Image draw = new Image("card-draw.png");
        ImageView drawView = new ImageView(draw);
        reSizeImage(drawView);
        Image discard = new Image("card-discard.png");
        ImageView discardView = new ImageView(discard);
        reSizeImage(discardView);

        this.add(drawView, 0, 0);
        this.add(discardView, 1, 1);
        this.add(deckView, 1, 0);
        this.add(defausseView, 0, 1);
        this.setAlignment(Pos.CENTER);
        this.setHgap(5);
        this.setVgap(5);


    }

    /**
     * Re size image.
     *
     * @param image the image
     */
    public void reSizeImage(ImageView image) {
        image.setFitHeight(55);
        image.setFitWidth(50);
    }


    /**
     * Gets deck view.
     *
     * @return the deck view
     */
    public CardUi getDeckView() {
        return deckView;
    }

    /**
     * Gets defausse view.
     *
     * @return the defausse view
     */
    public CardUi getDefausseView() {
        return defausseView;
    }


}
