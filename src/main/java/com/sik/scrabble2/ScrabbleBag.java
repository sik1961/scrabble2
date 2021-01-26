package com.sik.scrabble2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Data
@NoArgsConstructor
public class ScrabbleBag {
    private static final Random RANDOM = new Random();

    private List<ScrabbleTile> tiles;

    public void initialise() {
        this.tiles = new ArrayList<>();
        this.tiles.addAll(this.createMulti("A",9));
        this.tiles.addAll(this.createMulti("B",2));
        this.tiles.addAll(this.createMulti("C",2));
        this.tiles.addAll(this.createMulti("D",4));
        this.tiles.addAll(this.createMulti("E",12));
        this.tiles.addAll(this.createMulti("F",2));
        this.tiles.addAll(this.createMulti("G",3));
        this.tiles.addAll(this.createMulti("H",2));
        this.tiles.addAll(this.createMulti("I",9));
        this.tiles.addAll(this.createMulti("J",1));
        this.tiles.addAll(this.createMulti("K",1));
        this.tiles.addAll(this.createMulti("L",4));
        this.tiles.addAll(this.createMulti("M",2));
        this.tiles.addAll(this.createMulti("N",6));
        this.tiles.addAll(this.createMulti("O",8));
        this.tiles.addAll(this.createMulti("P",2));
        this.tiles.addAll(this.createMulti("Q",1));
        this.tiles.addAll(this.createMulti("R",6));
        this.tiles.addAll(this.createMulti("S",4));
        this.tiles.addAll(this.createMulti("T",6));
        this.tiles.addAll(this.createMulti("U",4));
        this.tiles.addAll(this.createMulti("V",2));
        this.tiles.addAll(this.createMulti("W",2));
        this.tiles.addAll(this.createMulti("X",1));
        this.tiles.addAll(this.createMulti("Y",2));
        this.tiles.addAll(this.createMulti("Z",1));
        this.tiles.addAll(this.createMulti(" ",2));
    }

    private List<ScrabbleTile> createMulti(String letter, int amount) {
        List<ScrabbleTile> newTiles = new ArrayList<>();
        for(int i=0;i<amount;i++) {
            newTiles.add(new ScrabbleTile(letter));
        }
        return newTiles;
    }

    public List<ScrabbleTile> pick(int amount) {
        List<ScrabbleTile> tiles = new ArrayList<>();
        for(int i = 0; i<amount;i++) {
            Optional<ScrabbleTile> picked = pickRandomTile();
            if (picked.isPresent()) {
                tiles.add(picked.get());
            }
        }
        return tiles;
    }

    private Optional<ScrabbleTile> pickRandomTile() {
        return this.tiles.isEmpty() ? Optional.empty() : Optional.of(this.tiles.remove(this.RANDOM.nextInt(this.tiles.size())));
    }
}
