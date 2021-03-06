package game.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import game.main.Play;

import java.util.Arrays;
import java.util.List;

public class CreatePlayArea {
    BitmapFont font;
    Play game;

    public List<TextButton> createBoard(Play newGame) {
        font = new BitmapFont();
        game = newGame;

        return Arrays.asList(
            createSingleButton("#", 100, 100, 0),
            createSingleButton("#", 200, 100, 1),
            createSingleButton("#", 300, 100, 2),
            createSingleButton("#", 100, 200, 3),
            createSingleButton("#", 200, 200, 4),
            createSingleButton("#", 300, 200, 5),
            createSingleButton("#", 100, 300, 6),
            createSingleButton("#", 200, 300, 7),
            createSingleButton("#", 300, 300, 8)
        );
    }

    private TextButton createSingleButton(String text, int positionX, int positionY, final int index) {
        final TextButton button;
        TextButton.TextButtonStyle textButtonStyle;
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        button = new TextButton(text, textButtonStyle);
        button.setTransform(true);
        button.setScale(5f);
        button.setPosition(positionX, positionY);
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(!game.gameOver && button.getText().toString().equals("#")) {
                    game.setBoard(index);
                    button.setText("X");
                    game.setBoardAtRandom();
                    if(game.hasPlayerWonGame(0) != -1) {
                        game.gameOver = true;
                        game.gameWinner = 0;
                        game.playerWins++;
                    }
                    if(game.hasPlayerWonGame(1) != -1) {
                        game.gameOver = true;
                        game.gameWinner = 1;
                        game.aiWins++;
                    }
                }
            }
        });
        return button;
    }

    public TextButton createResetGameButton(Play currentGame) {
        game = currentGame;
        TextButton resetGameButton;
		TextButton.TextButtonStyle textButtonStyle;
		textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = font;
        resetGameButton = new TextButton("New Game", textButtonStyle);
        resetGameButton.setTransform(true);
        resetGameButton.setScale(2f);
        resetGameButton.setPosition(100, 450);
        resetGameButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.resetGame();
            }
        });
        return resetGameButton;
    }
}
