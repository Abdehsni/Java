package esi.atl.g55140.cards;

public enum Value {
    ACE (1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(11),
    KING(11);


    private int score;
    Value(int score){
        this.score = score ;
    }

    /**
     * Donne la valeur d'une carte dans le jeu
     * @return la valeur de la carte
     */
    public int getScore() {
        return score;
    }
}
