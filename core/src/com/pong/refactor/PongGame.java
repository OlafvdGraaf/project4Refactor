package com.pong.refactor;

import com.badlogic.gdx.graphics.Color;
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
        pongList.Add(PongComponentVisitor.bPaddle);

        PongComponentVisitor.Reset();
    }

    public IGameState Run(){

        pongList.accept();

        if(PongComponentVisitor.playerOneLives.livesCount == 0){return new GameOver("You Won!", true, Color.GREEN);}
        if(PongComponentVisitor.playerTwoLives.livesCount == 0){return new GameOver("You Lost!", false, Color.RED);}

        return this;
    }
}
