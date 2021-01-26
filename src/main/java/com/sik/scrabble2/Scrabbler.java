package com.sik.scrabble2;

import lombok.Data;

@Data
public class Scrabbler {
    private ScrabbleHand hand;
    private boolean myTurn;

    public Scrabbler(ScrabbleHand hand) {
        this.hand = hand;
        this.myTurn = false;
    }

}
