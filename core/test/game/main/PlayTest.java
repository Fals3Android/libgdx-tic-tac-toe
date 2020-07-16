package game.main;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PlayTest {
    @Nested
    @DisplayName("resetBoard()")
    class resetBoard {
        @Test
        public void shouldResetBoard() {
            Play instance = new Play();
            instance.setBoard(0);
            instance.setBoard(1);
            instance.setBoard(2);
            instance.setBoard(8);
            assertEquals(Arrays.asList(0,0,0, null, null, null, null, null, 0), instance.getBoard());
            instance.resetBoard();
            assertEquals(Arrays.asList(null,null,null, null, null, null, null, null, null), instance.getBoard());
        }
    }

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
