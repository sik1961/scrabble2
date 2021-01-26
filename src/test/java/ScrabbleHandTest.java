import com.sik.scrabble2.ScrabbleBag;
import com.sik.scrabble2.ScrabbleHand;
import com.sik.scrabble2.ScrabbleTile;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class ScrabbleHandTest {

    private ScrabbleBag bag;

    @Before
    public void init() {
        bag = new ScrabbleBag();
    }
    @Test
    public void shouldCreateScrabbleHand() {
//        ScrabbleBag bag = new ScrabbleBag();
//        bag.initialise();
        ScrabbleHand hand = new ScrabbleHand(bag);
        hand.addToHand(bag.pick(7));

        assertThat(bag.getTiles(), hasSize(93));
        assertThat(hand.getHand(), hasSize(7));
    }

    @Test
    public void shouldSetShitnessAllVowels() {

        ScrabbleTile st1 = new ScrabbleTile("A");
        ScrabbleTile st2 = new ScrabbleTile("A");
        ScrabbleTile st3 = new ScrabbleTile("A");
        ScrabbleTile st4 = new ScrabbleTile("A");
        ScrabbleTile st5 = new ScrabbleTile("A");
        ScrabbleTile st6 = new ScrabbleTile("A");
        ScrabbleTile st7 = new ScrabbleTile("A");

        ScrabbleHand hand = new ScrabbleHand(bag);
        hand.addToHand(Arrays.asList(st1,st2,st3,st4,st5,st6,st7));
        assertThat(hand.getHand(), hasSize(7));
        assertThat(hand.getShitness(), is(7));

    }

    @Test
    public void shouldSetShitnessGoodMix() {

        ScrabbleTile st1 = new ScrabbleTile("A");
        ScrabbleTile st2 = new ScrabbleTile("A");
        ScrabbleTile st3 = new ScrabbleTile("A");
        ScrabbleTile st4 = new ScrabbleTile("N");
        ScrabbleTile st5 = new ScrabbleTile("N");
        ScrabbleTile st6 = new ScrabbleTile("N");
        ScrabbleTile st7 = new ScrabbleTile("N");

        ScrabbleHand hand = new ScrabbleHand(bag);
        hand.addToHand(Arrays.asList(st1,st2,st3,st4,st5,st6,st7));
        assertThat(hand.getHand(), hasSize(7));
        assertThat(hand.getShitness(), is(1));

    }

    @Test
    public void shouldSetShitnessWithBlank() {

        ScrabbleTile st1 = new ScrabbleTile("A");
        ScrabbleTile st2 = new ScrabbleTile("A");
        ScrabbleTile st3 = new ScrabbleTile("A");
        ScrabbleTile st4 = new ScrabbleTile(" ");
        ScrabbleTile st5 = new ScrabbleTile("A");
        ScrabbleTile st6 = new ScrabbleTile("N");
        ScrabbleTile st7 = new ScrabbleTile("N");

        ScrabbleHand hand = new ScrabbleHand(bag);
        hand.addToHand(Arrays.asList(st1,st2,st3,st4,st5,st6,st7));
        assertThat(hand.getHand(), hasSize(7));
        assertThat(hand.getShitness(), is(1));

    }
}
