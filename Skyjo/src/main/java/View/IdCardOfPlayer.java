package View;

/**
 * The enum Id card of player.
 */
public enum IdCardOfPlayer {
    /**
     * Card of p 1 id card of player.
     */
    CARD_OF_P1(1),
    /**
     * Card of p 2 id card of player.
     */
    CARD_OF_P2(2);

    private final int value;

    IdCardOfPlayer(int value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }
}
