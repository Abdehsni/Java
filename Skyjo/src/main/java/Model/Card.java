package Model;


import java.util.Objects;

/**
 * The type Card.
 */
public class Card{

    private final int value;
    private boolean hidden;

    /**
     * Instantiates a new Card.
     *
     * @param value the value
     */
    public Card(int value) {
        Objects.requireNonNull(value);
        this.value = value;
        this.hidden=true;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Is hidden boolean.
     *
     * @return the boolean
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Show.
     */
    public void show() {
        this.hidden=false;
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
