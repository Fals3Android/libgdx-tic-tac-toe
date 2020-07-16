package game.main;

import java.util.Arrays;
import java.util.List;

public class Play {
    List<Integer> board = Arrays.asList(null, null, null, null, null, null, null, null, null);
    List<List<Integer>> winningCombinations = Arrays.asList(
            Arrays.asList(0, 1, 2),
            Arrays.asList(3, 4, 5),
            Arrays.asList(6, 7, 8),
            Arrays.asList(2, 4, 6),
            Arrays.asList(0, 4, 8),
            Arrays.asList(0, 3, 6),
            Arrays.asList(1, 4, 7),
            Arrays.asList(2, 5, 8)
    );
    int moves = 0;
    public boolean gameOver = false;
    public int currentRandomIndex = -1;
    public int gameWinner = -1;

    public Play() { }

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

    public void resetBoard() {
        board = Arrays.asList(null, null, null, null, null, null, null, null, null);
    }

    public int hasPlayerWonGame(int playerIndex) {
        if(!gameOver) {
            boolean hasWonGame = false;
            for(List<Integer> combination: winningCombinations) {
                for(int value: combination) {
                    if(board.get(value) == null) {
                        hasWonGame = false;
                        break;
                    }
                    if(board.get(value) != playerIndex) {
                        hasWonGame = false;
                        break;
                    }
                    if(board.get(value) == playerIndex) {
                        hasWonGame = true;
                    }
                }

                if(hasWonGame) {
                    return playerIndex;
                }
            }

        }

        return -1;
    }
}
