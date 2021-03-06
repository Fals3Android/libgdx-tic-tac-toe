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
	List<TextButton> board;
	TextButton resetGameButton;
	CreatePlayArea instance;

	@Override
	public void create () {
		stage = new Stage();
		instance = new CreatePlayArea();
		board = instance.createBoard(game);
		for(TextButton button : board) {
			stage.addActor(button);
		}
		resetGameButton = instance.createResetGameButton(game);
		stage.addActor(resetGameButton);

		BitmapFont font	= new BitmapFont();
		textStyle = new Label.LabelStyle();
		textStyle.font = font;
		Label playerWinsLabel = new Label("Player Wins: " + game.playerWins, textStyle);
		playerWinsLabel.setScale(2f);
		playerWinsLabel.setPosition(300, 450);
		playerWinsLabel.setFontScale(1f, 1f);
		stage.addActor(playerWinsLabel);
		Label aiWinsLabel = new Label("AI: " + game.playerWins, textStyle);
		aiWinsLabel.setScale(2f);
		aiWinsLabel.setPosition(300, 400);
		aiWinsLabel.setFontScale(1f, 1f);
		stage.addActor(aiWinsLabel);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.75f, 0.25f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.input.setInputProcessor(stage);
		stage.draw();

		if(game.currentRandomIndex != -1 && board.get(game.currentRandomIndex) != null) {
			board.get(game.currentRandomIndex).setText("O");
		}

		if(game.gameOver && game.gameWinner != -1) {
			String whoWon = game.gameWinner == 0 ? "Player" : "AI";
			BitmapFont font	= new BitmapFont();
			textStyle = new Label.LabelStyle();
			textStyle.font = font;
			roundComplete = new Label("Round Complete: " + whoWon + " wins this match", textStyle);
			roundComplete.setFontScale(1f, 1f);
			stage.addActor(roundComplete);
			return;
		}

		if(resetGameButton.getClickListener().isPressed()) {
			stage.clear();
			board = instance.createBoard(game);
			for(TextButton button : board) {
				stage.addActor(button);
			}
			resetGameButton = instance.createResetGameButton(game);
			stage.addActor(resetGameButton);

			BitmapFont font	= new BitmapFont();
			textStyle = new Label.LabelStyle();
			textStyle.font = font;
			Label playerWinsLabel = new Label("Player Wins: " + game.playerWins, textStyle);
			playerWinsLabel.setScale(2f);
			playerWinsLabel.setPosition(300, 450);
			playerWinsLabel.setFontScale(1f, 1f);
			stage.addActor(playerWinsLabel);
			Label aiWinsLabel = new Label("AI: " + game.aiWins, textStyle);
			aiWinsLabel.setScale(2f);
			aiWinsLabel.setPosition(300, 400);
			aiWinsLabel.setFontScale(1f, 1f);
			stage.addActor(aiWinsLabel);
		}
	}
	
	@Override
	public void dispose () { }
}
