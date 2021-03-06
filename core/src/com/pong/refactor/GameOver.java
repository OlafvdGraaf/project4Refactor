package com.pong.refactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Dymos on 03/07/2017.
 */

public class GameOver extends inputdb implements IGameState {

    //the list that iterates through and visits the components
    PongComponentList pongList;

    //all the elemtents you want in the Homescreen
    Button btn;

    String text;
    Color color;

    inputdb inserter = new inputdb();

    public GameOver(String Text, boolean gameWon, Color color){
        this.text = Text;
        this.color = color;
        btn = new Button(200, 5, 0, "Main Menu");

        //adding the elements tot the component list
        pongList = new PongComponentList();
        pongList.Add(btn);

    }

    public IGameState Run(){
        pongList.accept();

        PongComponentVisitor.endFont.setColor(this.color);
        PongComponentVisitor.endFont.getData().setScale(4);
        PongComponentVisitor.batch.begin();
        PongComponentVisitor.endFont.draw(PongComponentVisitor.batch, this.text, (Gdx.graphics.getWidth() * 0.5f) - 125, Gdx.graphics.getHeight() * 0.8f);
        PongComponentVisitor.batch.end();

        //to check if the button is pressed
        if(btn.isPressed){
            System.out.print(inserter.text);
            return new Homescreen();}
        else{return this;}
    }
}
