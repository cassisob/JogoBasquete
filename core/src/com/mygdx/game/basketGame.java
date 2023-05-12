package com.mygdx.game;

import com.badlogic.gdx.Game;

public class basketGame extends Game {

	@Override
	public void create() {
		showMenuScreen();
	}


	public void showMenuScreen() {
		setScreen(new GameMenu(this));
	}

	public void showGamePlayScreen() {
		setScreen(new GamePlay(this));
	}

}
