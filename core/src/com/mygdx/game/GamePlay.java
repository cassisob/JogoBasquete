package com.mygdx.game;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class GamePlay extends InputAdapter implements Screen {

	SpriteBatch batch;
	BitmapFont font;
	ExtendViewport viewport;
	ShapeRenderer renderer;

	Texture img;
	Texture img1;
	basketGame game;
	Ball ball;
	Basket basket;


	public GamePlay(basketGame game) {
		this.game = game;
	}

	@Override
	public void show() {
		renderer = new ShapeRenderer();
		viewport = new ExtendViewport(500, 800);

		batch = new SpriteBatch();
		img = new Texture("red.png");
		img1 = new Texture("fundo.png");
		font = new BitmapFont();

		basket = new Basket(viewport);
		ball = new Ball(viewport);
	}

	@Override
	public void render(float delta) {
		basket.update();
		ball.update();

		batch.begin();

		batch.draw(img1, 0, 0);

		basket.render(batch);
		ball.render(batch);

		if (ball.behind.equals(false)) {
			basket.render(batch);
		}
		if (ball.point.equals(false)) {
			batch.draw(img, 100, 600);
		}
		if (ball.life == 0) {
			game.showMenuScreen();
		}
		font.draw(batch, "Pontos: " + ball.points, 60, 50);
		font.draw(batch, "Chances: " + ball.life, 60, 70);

		batch.end();

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

}
