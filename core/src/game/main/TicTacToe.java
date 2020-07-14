package game.main;

import java.util.Arrays;
import java.util.List;

public class TicTacToe {
    List<Integer> board = Arrays.asList(null, null, null, null, null, null, null, null, null);
    int moves = 0;
    public boolean gameOver = false;
    public int currentRandomIndex = -1;

    public TicTacToe() { }

    public List<Integer> getBoard() {
        return board;
    }

    public void setBoard(int index) {
        board.set(index, 0);
        moves++;
        isGameOver(moves);
    }

    public void setBoardAtRandom() {
        int randomIndex = (int) (Math.random() * board.size());
        if(board.get(randomIndex) == null) {
            board.set(randomIndex, 1);
            currentRandomIndex = randomIndex;
            moves++;
            isGameOver(moves);
            return;
        }

        if(!gameOver) {
            setBoardAtRandom();
        }

    }

    public void isGameOver(int moves) {
        if(moves == board.size()) {
            gameOver = true;
        }
    }
}
