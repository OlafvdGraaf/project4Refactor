package com.pong.refactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import sun.font.TrueTypeFont;

/**
 * Created by Dymos on 03/07/2017.
 */

public class Homescreen implements IGameState {

    PongComponentList pongList;

    Button strtBTN;

    AnimatedBackground backGround;

    public Homescreen(){

        pongList = new PongComponentList();
        pongList.Add(strtBTN = new Button(100, 2));

        backGround = new AnimatedBackground();
    }

    public IGameState Run(){

        pongList.accept();

        backGround.Run();

        if(strtBTN.isPressed){return new PongGame();}
        else{return this;}
    }
}
