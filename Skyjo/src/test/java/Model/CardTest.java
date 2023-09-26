package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void Card_Value() {
        Card lamba = new Card(5);
        int value = lamba.getValue();
        assertEquals(5,value);
    }
}