package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;



public class Basket {

    Vector2 position;
    Viewport viewport;
    Texture img = new Texture("basket.png");

    public Basket(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(100, 600);
    }

    public void update() {
    }


    public void render(SpriteBatch batch) {
        batch.draw(img, position.x, position.y);
    }

}
