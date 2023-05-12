package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;



public class Ball {

    Vector2 position;
    Viewport viewport;
    Texture img = new Texture("ball.png");

    Boolean remember = true;
    Boolean play1 = true;
    Boolean play2 = true;
    Boolean behind = true;
    Boolean point = true;
    int i;
    int firstYposition;
    int firstXposition;
    int newYposition;
    int newXposition;
    int pointsHere = 0;
    int points = 0;
    int lifeHere = 5;
    int life = 5;
    double acumY;

    public Ball(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(215, 100);
    }

    public void update() {
        for (i = 0; i < 1; i++) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getY() >= 400 && play1) {
                if (remember) {
                    firstYposition = Gdx.input.getY();
                    firstXposition = Gdx.input.getX();
                    remember = false;
                }
                position.y = 765 - Gdx.input.getY();
                position.x = Gdx.input.getX() - 35;
                newYposition = Gdx.input.getY();
                newXposition = Gdx.input.getX();
                play2 = false;
                break;
            }

            double teste = newXposition - firstXposition;
            double teste1 = newYposition - firstYposition;
            double teste2 = 117;
            double coords = (teste * teste2) / teste1;

            if (!play2) {
                if (firstYposition - newYposition < 50 ) {
                    position.y = 100;
                    position.x = 215;
                    remember = true;
                    break;

                } else if (firstYposition - newYposition < 100) {
                    position.y += 16 - acumY;
                    acumY += 0.4;
                    coords = coords / 40;
                    if (coords > 0) {
                        position.x -= coords;
                    } else {
                        position.x += coords * -1;
                    }

                } else if (firstYposition - newYposition < 150) {
                    position.y += 18 - acumY;
                    acumY += 0.4;
                    coords = coords / 44;
                    if (coords > 0) {
                        position.x -= coords;
                    } else {
                        position.x += coords * -1;
                    }

                } else if (firstYposition - newYposition > 150) {
                    position.y += 20 - acumY;
                    acumY += 0.4;
                    coords = coords / 72;
                    if (coords > 0) {
                        position.x -= coords;
                    } else {
                        position.x += coords * -1;
                    }
                    if (position.y > 785 && behind) {
                        behind = false;
                    }
                }
                play1 = false;

            }

            if (acumY == 20 || acumY == 18 || acumY == 16) {
                if (position.x > 200 && position.x < 240 && position.y > 650 && position.y < 780) {
                   pointsHere += 1;
                   lifeHere += 1;
                   point = false;
                } else {
                   lifeHere -= 1;
                }
            }

            if (position.y < -100) {
                position.y = 100;
                position.x = 215;
                points = pointsHere;
                life = lifeHere;
                behind = true;
                remember = true;
                play2 = true;
                play1 = true;
                point = true;
                acumY = 0;
            }

        }

    }


    public void render(SpriteBatch batch) {
        batch.draw(img, position.x, position.y);
    }

}
