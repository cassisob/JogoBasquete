package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

// natalia e vitoria

public class GameMenu extends InputAdapter implements Screen {

    private static final int playWidth = 309;
    private static final int playHeight = 94;
    private static final int playY = 376;
    private static final int playX = 94;

    SpriteBatch batch;
    ShapeRenderer renderer;
    StretchViewport viewport;

    basketGame game;
    Texture img;
    Texture img1;


    public GameMenu(basketGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        batch = new SpriteBatch();
        img = new Texture("Menu.jpg");
        img1 = new Texture("menuchoices.jpg");

        viewport = new StretchViewport(500, 800);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {

        viewport.apply();
        renderer.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();

        batch.draw(img, 0, 0);

        if (Gdx.input.getX() < playX + playWidth && Gdx.input.getX() > playX && 800 - Gdx.input.getY() < playY + playHeight && 800 - Gdx.input.getY() > playY) {
            batch.draw(img1, playX, playY, playWidth, playHeight);
            if (Gdx.input.isTouched()){
                game.showGamePlayScreen();
            } else {
                batch.draw(img1, playX, playY, playWidth, playHeight);
            }
        }

        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(500, 800, true);
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
        renderer.dispose();
    }

}
