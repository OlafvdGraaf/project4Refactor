package com.pong.refactor;

import com.badlogic.gdx.Gdx;

/**
 * Created by Dymos on 04/07/2017.
 */

public class UserPaddle extends Paddle {

    public AdapterPaddle adapterPaddle;

    float x = Gdx.graphics.getWidth() * 0.8f;
    float y;

    public UserPaddle(){
        y = Gdx.graphics.getHeight() * 0.5f;

        adapterPaddle = new AdapterPaddle();
    }

    @Override
    public void Control(){
        this.adapterPaddle.control(this);
    }

    public void accept(){
        this.Control();

        PongComponentVisitor.uPaddle = this;

        PongComponentVisitor.visit(this);
    }
}
