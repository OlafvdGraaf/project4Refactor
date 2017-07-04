package com.pong.refactor;

import com.badlogic.gdx.Gdx;

/**
 * Created by Dymos on 03/07/2017.
 */

public final class LeftUpState implements IBallState {

    @Override
    public IBallState Update(Ball ball){

        //checks if the particle is on the left edge screen
        if(ball.x <= 0){ball.xV = Math.abs(ball.xV); return new RightUpState();}

        ball.UpdateVeloc();

        return this;
    }

}
