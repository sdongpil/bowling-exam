import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void canRoll() {
        game.roll(0);
    }

    private void rollMany(int pins, int frames) {
        for (int i = 0; i < frames; i++) {
            game.roll(pins);
        }
    }
    @Test
    public void gutterGame() {
        rollMany(0, 20);
        assertThat(game.getScore(), is(20));

    }


    @Test
    public void allOnes() {
        rollMany(1, 20);
        assertThat(game.getScore(), is(20));

    }
    @Test
    public void oneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore(), is(16));
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5); // spare
    }

    @Test
    public void oneStrike() {
        game.roll(10);
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertThat(game.getScore(), is(26));
    }

}
