package com.pong.refactor;

import com.badlogic.gdx.Gdx;

/**
 * Created by Dymos on 03/07/2017.
 */

public final class RightUpState implements IBallState {

    @Override
    public IBallState Update(Ball ball){

        //checks if the particle is on the right edge screen
        if(ball.x + 20 >= Gdx.graphics.getWidth()){ball.xV = ball.xV - ball.xV - ball.xV; return new LeftUpState();}

        //checks if the ball hit the user paddle
        if(ball.checkPaddleHit()){ball.hit++; ball.xV = ball.xV - ball.xV - ball.xV;  return new LeftUpState();}

        ball.UpdateVeloc();

        return this;
    }
}
