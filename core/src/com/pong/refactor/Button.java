package com.pong.refactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by Dymos on 03/07/2017.
 */

public class Button implements IPongComponent {
    boolean isPressed;

    float x;
    float y;

    float width;
    float height;

    String text;

    public Button(float size, float yPos, float xPos, String text){

        this.width = size;
        this.height = size * 0.5f;

        this.x = xPos + (Gdx.graphics.getWidth() * 0.5f) - (this.width *0.5f);
        this.y = Gdx.graphics.getHeight() * (yPos * 0.10f);

        this.text = text;

        isPressed = false;
    }

    public void accept(){
        PongComponentVisitor.visit(this);
        this.checkPressed();
    }

    public void checkPressed(){
        if(     Gdx.input.isButtonPressed(Input.Buttons.LEFT) &&
                Gdx.input.getX() > this.x &&
                Gdx.input.getX() < this.x + this.width &&
                Gdx.input.getY() < Gdx.graphics.getHeight() - this.y &&
                Gdx.input.getY() > Gdx.graphics.getHeight() - this.y - this.height){

            isPressed = true;
        }
        else{

            isPressed = false;
        }
    }

}
