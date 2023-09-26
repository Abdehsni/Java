package esi.atl.g55140.cards;

public class Card {

    private final Color color;
    private final Value value;

    public Card(Color color, Value value) {

        if( color == null || value == null){
            throw new IllegalArgumentException ("couleur ou valeur non reconnue");
        }

        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.name()+" of "+color.name();
    }
}
