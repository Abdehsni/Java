package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Defausse cards.
 */
public class DefausseCards {

    private final List<Card> defausse;

    /**
     * Instantiates a new Defausse deckcards.
     *
     * @param deckcard the deckcard
     */
    public DefausseCards(DeckCards deckcard) {
        Card def= deckcard.drawACard();
        def.show();
        defausse = new ArrayList<>();
        defausse.add(def);
    }

    /**
     * Instantiates a new Defausse cards.
     *
     * @param def the def
     */
    public DefausseCards(DefausseCards def){
        defausse=def.defausse;
    }


    /**
     * Get card of defausse card.
     *
     * @return the card
     */
    public Card getCardOfDefausse(){
        return defausse.get(0);
    }

    /**
     * Remove card from defausse.
     */
    public void removeCardFromDefausse(){
        defausse.remove(0);
    }

    /**
     * Sets defausse.
     *
     * @param card the card
     */
    public void addToDefausse(Card card) {
        card.show();
        this.defausse.add(0,card);
    }

    /**
     * Getfirst card.
     *
     * @return the card
     */
    public Card getfirst(){
        return defausse.get(0);
    }


}
