package com.sik.scrabble2;


import java.util.ArrayList;
import java.util.List;

public class ScrabbleHand {


    private List<ScrabbleTile> hand;
    private int shitness;
    private ScrabbleBag bag;

    public ScrabbleHand(ScrabbleBag bag) {
        this.hand = new ArrayList<>();
        this.updateShitness();
        this.bag = bag;
    }

    public ScrabbleHand(List<ScrabbleTile> hand) {
        this.hand = hand;
        this.updateShitness();
    }

    public List<ScrabbleTile> getHand() {
        return hand;
    }

    public void setHand(List<ScrabbleTile> hand) {
        this.hand = hand;
        this.updateShitness();
    }

    public void addToHand(List<ScrabbleTile> tiles) {
        hand.addAll(tiles);
        this.updateShitness();
    }

    public int getShitness() {
        return shitness;
    }

    public void updateShitness() {
        int vCount = 0;
        int cCount = 0;
        int bCount = 0;
        for (ScrabbleTile tile:hand) {
            switch (tile.getType()) {
                case BLANK:  bCount++;
                    break;
                case VOWEL: vCount++;
                    break;
                case CONSONANT: cCount++;
                    break;
            }
        }
        this.shitness = Math.abs((vCount-cCount)-bCount);
    }
}
