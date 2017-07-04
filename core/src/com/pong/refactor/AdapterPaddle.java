package com.pong.refactor;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by Dymos on 04/07/2017.
 */

public class AdapterPaddle {
    public void control(UserPaddle paddle){
        if(Gdx.app.getType() == Application.ApplicationType.Android){
            paddle.y = (Gdx.graphics.getHeight() - Gdx.input.getY()) - 100;
        }else{
            if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)){
                if(paddle.y + 100 <= Gdx.graphics.getHeight()) {
                    paddle.y += 20;
                }}
            if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)){
                if(paddle.y >= 0) {
                    paddle.y -= 20;
                }}}}

    public int paddle_height(){
        if(Gdx.app.getType() == Application.ApplicationType.Android) {
            return 200;
        }
        else {
            return 100;
        }
    }

    public int paddlewidth(){
        return 10;
    }
}
