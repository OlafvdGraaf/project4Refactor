package com.pong.refactor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dymos on 03/07/2017.
 */

public class GameOver implements IGameState {

    //the list that iterates through and visits the components
    PongComponentList pongList;

    //all the elemtents you want in the Homescreen
    Button btn;

    public GameOver(){

        btn = new Button(5, 5, 0);

        //adding the elements tot the component list
        pongList = new PongComponentList();
        pongList.Add(btn = new Button(100, 4, 0));
    }

    public IGameState Run(){
        pongList.accept();

        //to check if the button is pressed
        if(btn.isPressed){return new Homescreen();}
        else{return this;}
    }
}
