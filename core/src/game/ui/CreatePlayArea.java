package game.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import game.main.TicTacToe;

import java.util.Arrays;
import java.util.List;

public class CreatePlayArea {
    BitmapFont font;
    TicTacToe game;

    public List<TextButton> create(TicTacToe newGame) {
        font = new BitmapFont();
        game = newGame;

        List<TextButton> buttons = Arrays.asList(
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

        return buttons;
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
                if(game.gameOver == false) {
                    game.setBoard(index);
                    button.setText(button.getText().toString().equals("X") ? "O" : "X");
                    game.setBoardAtRandom();
                }
            }
        });
        return button;
    }
}
