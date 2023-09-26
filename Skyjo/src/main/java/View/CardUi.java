package View;

import Model.Card;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The type Card ui.
 */
public class CardUi extends Button {

    private IdCardOfPlayer idPlayer;
    private int idCard;

    /**
     * Instantiates a new Card ui.
     *
     * @param card the card
     */
    public CardUi(Card card) {

        this.setMinWidth(50);
        this.setMinHeight(60);
        this.setMaxHeight(60);
        this.setMaxWidth(50);

        Image image = new Image("hexess.png");
        ImageView imageview = new ImageView(image);
        //Rectangle value = new Rectangle();

        if (card.isHidden()) {

            imageview.fitWidthProperty().bind(this.widthProperty());       //Oblige l'image à avoir la meme taille que le boutton
            imageview.fitHeightProperty().bind(this.heightProperty());     //
                                                                            //Préserve le ratio de l'image pour pas lávoir trop étirée nonplus
            this.setGraphic(imageview);
        } else {
            this.setGraphic(null);
            this.setText(String.valueOf(card.getValue()));
        }
    }

    /**
     * Sets id player.
     *
     * @param idPlayer the id player
     */
    public void setIdPlayer(IdCardOfPlayer idPlayer) {
        this.idPlayer = idPlayer;
    }

    /**
     * Gets id player.
     *
     * @return the id player
     */
    public IdCardOfPlayer getIdPlayer() {
        return idPlayer;
    }

    /**
     * Gets id card of player.
     *
     * @return the id card of player
     */
    public int getIdCardOfPlayer() {
        return idCard;
    }

    /**
     * Sets id card of player.
     *
     * @param idCardOfPlayer the id card of player
     */
    public void setIdCardOfPlayer(int idCardOfPlayer) {
        this.idCard = idCardOfPlayer;
    }
}



