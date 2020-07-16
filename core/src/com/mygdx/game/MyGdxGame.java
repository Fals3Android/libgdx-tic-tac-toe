package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import game.main.Play;
import game.ui.CreatePlayArea;

import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
	Stage stage;
	Label roundComplete;
	Label.LabelStyle textStyle;
	Play game = new Play();
	List<TextButton> buttons;

	@Override
	public void create () {
		stage = new Stage();
		buttons = new CreatePlayArea().create(game);
		for(TextButton button : buttons) {
			stage.addActor(button);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.75f, 0.25f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.input.setInputProcessor(stage);
		stage.draw();

		if(game.gameOver && game.gameWinner != -1) {
			String whoWon = game.gameWinner == 0 ? "Player" : "AI";
			BitmapFont font	= new BitmapFont();
			textStyle = new Label.LabelStyle();
			textStyle.font = font;
			roundComplete = new Label("Round Complete: " + whoWon + " wins this match", textStyle);
			roundComplete.setFontScale(1f, 1f);
			stage.addActor(roundComplete);
			//TODO: create button that resets game
			return;
		}

		if(game.currentRandomIndex != -1 && buttons.get(game.currentRandomIndex) != null) {
			buttons.get(game.currentRandomIndex).setText("O");
		}
	}
	
	@Override
	public void dispose () {
//		batch.dispose();
	}
}
