package com.pong.refactor;

import com.badlogic.gdx.Gdx;

/**
 * Created by Dymos on 04/07/2017.
 */

public class BotPaddle extends Paddle {

    float x = Gdx.graphics.getWidth() * 0.2f;
    float y;

    float veloc;

    public BotPaddle() {
        y = Gdx.graphics.getHeight() * 0.5f;

        veloc = 8;

    }

    @Override
    public void Control(){
        if(PongComponentVisitor.closestBall != null) {

            if(0 == (PongComponentVisitor.closestBall.xV + Math.abs(PongComponentVisitor.closestBall.xV))) {

                if (this.y + 45 > PongComponentVisitor.closestBall.y) {
                    this.y -= veloc;
                }

                if (this.y + 45 < PongComponentVisitor.closestBall.y) {
                    this.y += veloc;
                }
            }
        }
    }

    public void accept(){
        this.Control();

        PongComponentVisitor.bPaddle = this;

        PongComponentVisitor.visit(this);
    }
}
