package esi.atl.g55140.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

    private List<Card> cards;

    public Deck(){

        cards = new ArrayList<>();

        for(Value value: Value.values()) {
            for (Color color : Color.values()) {
                Card card = new Card(color, value);
                cards.add(card);
            }
        }
        shuffle();
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public Card hit(){

        if(cards.isEmpty()){
            throw new IllegalArgumentException("Le deck est vide");
        }

        return cards.remove(cards.size() - 1);
    }

    public Card showTheCard(){
        return cards.get(cards.size() - 1);
    }


    public int size(){
        return cards.size();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
