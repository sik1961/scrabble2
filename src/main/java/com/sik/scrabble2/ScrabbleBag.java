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
    private final Random random = new Random();

    private List<ScrabbleTile> tiles;

    public void initialise() {
        this.tiles = new ArrayList<>();
        this.tiles.addAll(this.createMulti("A",1,9));
        this.tiles.addAll(this.createMulti("B",3,2));
        this.tiles.addAll(this.createMulti("C",3,2));
        this.tiles.addAll(this.createMulti("D",2,4));
        this.tiles.addAll(this.createMulti("E",1,12));
        this.tiles.addAll(this.createMulti("F",4,2));
        this.tiles.addAll(this.createMulti("G",2,3));
        this.tiles.addAll(this.createMulti("H",4,2));
        this.tiles.addAll(this.createMulti("I",1,9));
        this.tiles.addAll(this.createMulti("J",8,1));
        this.tiles.addAll(this.createMulti("K",5,1));
        this.tiles.addAll(this.createMulti("L",1,4));
        this.tiles.addAll(this.createMulti("M",3,2));
        this.tiles.addAll(this.createMulti("N",1,6));
        this.tiles.addAll(this.createMulti("O",1,8));
        this.tiles.addAll(this.createMulti("P",3,2));
        this.tiles.addAll(this.createMulti("Q",10,1));
        this.tiles.addAll(this.createMulti("R",1,6));
        this.tiles.addAll(this.createMulti("S",1,4));
        this.tiles.addAll(this.createMulti("T",1,6));
        this.tiles.addAll(this.createMulti("U",1,4));
        this.tiles.addAll(this.createMulti("V",4,2));
        this.tiles.addAll(this.createMulti("W",4,2));
        this.tiles.addAll(this.createMulti("X",8,1));
        this.tiles.addAll(this.createMulti("Y",4,2));
        this.tiles.addAll(this.createMulti("Z",10,1));
        this.tiles.addAll(this.createMulti(" ",0,2));
    }

    private List<ScrabbleTile> createMulti(String letter, int value, int amount) {
        List<ScrabbleTile> newTiles = new ArrayList<>();
        for(int i=0;i<amount;i++) {
            newTiles.add(new ScrabbleTile(letter,value));
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
        return this.tiles.isEmpty() ? Optional.empty() : Optional.of(this.tiles.remove(this.random.nextInt(this.tiles.size())));
    }
}
