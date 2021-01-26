package test;

import com.sik.scrabble2.ScrabbleBag;
import com.sik.scrabble2.ScrabbleTile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.sik.scrabble2.ScrabbleConstants.SEVEN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ScrabbleSimulatorTest {

    private Random random = new Random();

    @Test
    public void shouldInitialiseScrabbleBag() {

        ScrabbleBag bag = new ScrabbleBag();
        bag.getTiles().forEach(System.out::println);
        assertThat(bag.getTiles(), hasSize(100));

    }

    @Test
    public void shouldPickSevenLetters() {

        ScrabbleBag bag = new ScrabbleBag();
        List<ScrabbleTile> newTiles = bag.pick(SEVEN);
        assertThat(bag.getTiles(), hasSize(93));
        assertThat(newTiles, hasSize(SEVEN));
        newTiles.forEach(System.out::println);
    }

    @Test
    public void AdhoRun() {

        ScrabbleBag bag = new ScrabbleBag();

        List<ScrabbleTile> newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();

        newTiles = bag.pick(SEVEN);
        printHand(newTiles,"Hand:" );
        newTiles.clear();
    }

    @Test
    public void shouldSimulateGame() {

        ScrabbleBag bag = new ScrabbleBag();

        List<ScrabbleTile> player1 = bag.pick(SEVEN);
        List<ScrabbleTile> player2 = bag.pick(SEVEN);


        while(!player1.isEmpty() && !player2.isEmpty()) {

            //player1
            printHand(player1, "P1 Hand:   ");


            if (!player1.isEmpty()) {
                List<ScrabbleTile> p1toPlay = new ArrayList<>();
                int p1numberToPlay = player1.size()>1?random.nextInt(player1.size()):1;
                for(int i=0;i<p1numberToPlay;i++) {
                    p1toPlay.add(player1.remove(random.nextInt(player1.size())));
                }
                printHand(p1toPlay,"P1 Playing:");
                player1.removeAll(p1toPlay);
                if (!bag.getTiles().isEmpty())  {
                    player1.addAll(bag.pick(p1numberToPlay));
                }
            }


            System.out.println("In bag: " + bag.getTiles().size());
            System.out.println();

            //player2
            if (player1.isEmpty()) break;

            printHand(player2, "P2 Hand:   ");


            if (!player2.isEmpty()) {
                List<ScrabbleTile> p2toPlay = new ArrayList<>();
                int p2numberToPlay = player2.size()>1?random.nextInt(player2.size()):1;
                for(int i=0;i<p2numberToPlay;i++) {
                    p2toPlay.add(player2.remove(random.nextInt(player2.size())));
                }
                printHand(p2toPlay,"P2 Playing:");
                player2.removeAll(p2toPlay);
                if (!bag.getTiles().isEmpty())  {
                    player2.addAll(bag.pick(p2numberToPlay));
                }
            }


            System.out.println("In bag: " + bag.getTiles().size());
            System.out.println();

        }
        if (player1.isEmpty()) {
            System.out.println("Player 1 wins");
        }
        if (player2.isEmpty()) {
            System.out.println("Player 2 wins");
        }

    }

    private boolean notEmpty(ScrabbleBag bag) {
        return !bag.getTiles().isEmpty();
    }

    private void printHand(List<ScrabbleTile> tiles, String label) {
        StringBuilder sb = new StringBuilder(label);
        String delim = "";
        for(ScrabbleTile t:tiles) {
            sb.append(delim + t.getLetter());
            delim=",";
        }
        System.out.println(sb.toString());
    }
}
