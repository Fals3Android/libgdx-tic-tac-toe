package game.main;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayTest {
    @Nested
    @DisplayName("hasPlayerWonGame()")
    class hasPlayerWonGame {
        @Test
        public void playerShouldWinCase() {
            Play instance = new Play();
            instance.setBoard(3);
            instance.setBoard(4);
            instance.setBoard(5);
            assertEquals(0, instance.hasPlayerWonGame(0));
        }

        @Test
        public void playerShouldLoseCase() {
            Play instance = new Play();
            instance.setBoard(4);
            assertEquals(-1, instance.hasPlayerWonGame(0));
        }
    }
}
