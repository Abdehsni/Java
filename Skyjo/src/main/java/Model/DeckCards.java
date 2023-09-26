package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Deck cards.
 */
public class DeckCards {


    private final List<Card> Deck;

    /**
     * Instantiates a new Deck cards.
     */
    public DeckCards() {
        Deck= new ArrayList<>();
        int min = -2;
        int max = 12;
        int range = max - min + 1;

        for (int i = 0; i < 150; i++) {
            int rand = (int) (Math.random() * range) + min;
            Deck.add(new Card(rand));
        }

    }

    /**
     * Instantiates a new Deck cards.
     *
     * @param d the d
     */
    public DeckCards(DeckCards d){
        Deck=d.Deck;
    }


    /**
     * Draw a card card and remove it from the deck
     *
     * @return the card
     */
    public Card drawACard(){
     Card card= Deck.get(0);
     Deck.remove(0);
     return card;
    }

    /**
     * Before drawing a card.
     */
    public void beforeDrawingACard(){
        Deck.get(0).show();
    }

    /**
     * Get the first card.
     *
     * @return the card
     */
    public Card getFirst(){
        return Deck.get(0);
    }

}
