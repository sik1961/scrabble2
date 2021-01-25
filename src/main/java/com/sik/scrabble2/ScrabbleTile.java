package com.sik.scrabble2;

import lombok.*;

import java.util.UUID;

@Getter
@EqualsAndHashCode
@ToString
public class ScrabbleTile {
    private String id;
    private String letter;
    private int value;

    public ScrabbleTile(final String letter, final int value) {
        this.id = UUID.randomUUID().toString();
        this.letter = letter;
        this.value = value;
    }
}
