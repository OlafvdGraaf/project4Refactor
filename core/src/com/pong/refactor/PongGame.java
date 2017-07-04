package com.pong.refactor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dymos on 03/07/2017.
 */

public class PongGame implements IGameState{

    PongComponentList pongList;

    BallList ballList;

    UserPaddle userPaddle;

    public PongGame(){

        ballList = new BallList();
        ballList.add(new Ball());

        userPaddle = new UserPaddle();
        PongComponentVisitor.uPaddle = userPaddle;

        pongList = new PongComponentList();
        pongList.Add(userPaddle);
    }

    public IGameState Run(){

        pongList.accept();
        ballList = pongList.accept(ballList);

        return this;
    }
}
