package com.pong.refactor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dymos on 03/07/2017.
 */

public class PongGame implements IGameState{

    PongComponentList pongList;

    public PongGame(){

        pongList = new PongComponentList();
        pongList.Add(new UserPaddle());
        pongList.Add(new BallList());
        pongList.Add(new BotPaddle());

        PongComponentVisitor.Reset();
    }

    public IGameState Run(){

        pongList.accept();

        return this;
    }
}
