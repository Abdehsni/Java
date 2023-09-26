package Model;

import View.IdCardOfPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Player.
 */
public class Player {

    private int score;
    private final List<Card> listCards;
    private final IdCardOfPlayer idOwnerOfCards;
    private boolean played;

    /**
     * Instantiates a new Player.
     *
     * @param idOwnerOfCards the id owner of cards
     */
    public Player(IdCardOfPlayer idOwnerOfCards) {
        this.score = 0;
        this.listCards = new ArrayList<>();
        this.idOwnerOfCards = idOwnerOfCards;
        this.played = false;
    }

    /**
     * Instantiates a new Player.
     *
     * @param p the p
     */
    public Player(Player p) {
        score = p.score;
        listCards = p.listCards;
        idOwnerOfCards = p.idOwnerOfCards;
        played = p.played;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets id owner of cards.
     *
     * @return the id owner of cards
     */
    public IdCardOfPlayer getIdOwnerOfCards() {
        return idOwnerOfCards;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Update score.
     */
    public void updateScore() {
        score = 0;
        for (Card card : listCards) {
            if (!card.isHidden()) {
                score += card.getValue();
            }
        }
    }

    /**
     * Gets list cards.
     *
     * @return the list cards
     */
    public List<Card> getListCards() {
        return listCards;
    }

    /**
     * Show a hidden card.
     *
     * @param index the index
     */
    public void showAHiddenCard(int index) {
        this.listCards.get(index).show();
    }


    /**
     * Add cards.
     *
     * @param card the card
     */
    public void addCards(Card card) {
        this.listCards.add(card);
    }


    /**
     * Initialise.
     *
     * @param deck the deck
     */
    public void initialise(DeckCards deck) {
        for (int i = 0; i < 12; i++) {
            addCards(deck.drawACard());
        }

        int min = 0;
        int max = 11;
        int range = max - min + 1;
        int PlayerIndex = (int) (Math.random() * range) + min;
        int PlayerIndexbis = (int) (Math.random() * range) + min;

        while (PlayerIndexbis == PlayerIndex) {
            PlayerIndexbis = (int) (Math.random() * range) + min;
        }

        showAHiddenCard(PlayerIndex);
        showAHiddenCard(PlayerIndexbis);

    }

    /**
     * All cards showed boolean.
     *
     * @return the boolean
     */
    public boolean allCardsShowed() {
        boolean result = true;
        for (Card card : listCards) {
            if (card.isHidden()) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Set one card.
     *
     * @param index the index
     * @param card  the card
     */
    public void setOneCard(int index, Card card) {
        listCards.remove(index);
        listCards.add(index, card);
    }

    /**
     * Sets played.
     */
    public void setPlayed() {
        this.played = true;
    }

    /**
     * Sets un played.
     */
    public void setUnPlayed() {
        this.played = false;
    }

    /**
     * Is played boolean.
     *
     * @return the boolean
     */
    public boolean isPlayed() {
        return played;
    }
}
