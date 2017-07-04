package com.pong.refactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by Dymos on 04/07/2017.
 */

public class ScoreCounter implements IPongComponent {
    float x;
    float y;
    float width;
    float height;
    String text = "Score : ";
    int counter;

    public ScoreCounter() {
        this.x = (float)Gdx.graphics.getWidth() * 0.5F - 150.0F;
        this.y = (float)Gdx.graphics.getHeight() * 0.9F;
        this.width = 300.0F;
        this.height = 100.0F;
        this.counter = 0;
    }

    public void accept() {
        PongComponentVisitor.visit(this);
    }
}
