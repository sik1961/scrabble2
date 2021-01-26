package com.sik.scrabble2;

import lombok.*;

import java.util.UUID;

@Getter
@EqualsAndHashCode
@ToString
public class ScrabbleTile {
    private String id;
    private String letter;
    private TileType type;
    private int value;

    public ScrabbleTile(final String letter) {
        this.id = UUID.randomUUID().toString();
        this.letter = letter;
        switch (letter) {
            case "Q":
            case "Z":
                this.value = 10;
                break;
            case "J":
            case "X":
                this.value = 8;
                break;
            case "K":
                this.value = 5;
                break;
            case "F":
            case "H":
            case "V":
            case "W":
            case "Y":
                this.value = 4;
                break;
            case "B":
            case "C":
            case "M":
            case "P":
                this.value = 3;
                break;
            case "D":
            case "G":
                this.value = 2;
                break;
            case " ":
                this.value = 0;
                break;
            default: this.value = 1;
                break;
        }

        switch (letter) {
            case " ":  this.type = TileType.BLANK;
                break;
            case "A":
            case "E":
            case "I":
            case "O":
            case "U":
                this.type = TileType.VOWEL;
                break;
            default: this.type = TileType.CONSONANT;
                break;
        }
    }
}
