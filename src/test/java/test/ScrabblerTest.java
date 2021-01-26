package test;

import com.sik.scrabble2.ScrabbleBag;
import com.sik.scrabble2.ScrabbleHand;
import com.sik.scrabble2.Scrabbler;
import org.junit.Test;

import static com.sik.scrabble2.ScrabbleConstants.SEVEN;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ScrabblerTest {

    private ScrabbleBag bag = new ScrabbleBag();
    @Test
    public void shouldCreateScrabbler() {

        Scrabbler player = new Scrabbler(new ScrabbleHand(bag));
        player.setHand(new ScrabbleHand(bag.pick(SEVEN)));


        assertThat(player.getHand(), notNullValue());
        assertThat(player.getHand().getTiles(), hasSize(7));
    }
}
