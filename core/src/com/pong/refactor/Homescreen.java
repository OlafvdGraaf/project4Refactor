package com.pong.refactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import sun.font.TrueTypeFont;

/**
 * Created by Dymos on 03/07/2017.
 */

public class Homescreen implements IGameState {

    PongComponentList pongList;

    Button strtBTN;
    Button optBTN;

    float Volume;

    AnimatedBackground backGround;

    public Homescreen(){

        pongList = new PongComponentList();
        pongList.Add(strtBTN = new Button(100, 4, 0));
        pongList.Add(optBTN = new Button(100, 3, 0));

        Volume = 100f;

        backGround = new AnimatedBackground();

        PongComponentVisitor.bPaddle = new BotPaddle();
    }

    public IGameState Run(){

        pongList.accept();

        backGround.Run();

        if(strtBTN.isPressed){return new PongGame();}
        if (optBTN.isPressed) {return new Optionscreen();}
        else{return this;}
    }
}
