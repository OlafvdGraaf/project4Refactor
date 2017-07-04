package com.pong.refactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Dymos on 03/07/2017.
 */

public class AnimatedBackground {

    public void Run(){

        this.DrawLogo();
    }

    private void DrawLogo() {
        float screenWidth1 = Gdx.graphics.getWidth() * 0.2f;
        float screenWidth2 = Gdx.graphics.getWidth() * 0.4f;
        float screenWidth3 = Gdx.graphics.getWidth() * 0.6f;
        float screenWidth4 = Gdx.graphics.getWidth() * 0.8f;

        float screenHeight = Gdx.graphics.getHeight() * 0.8f;


        //de P
        PongComponentVisitor.Draw(screenWidth1 - 25, screenHeight, 25, 150);
        PongComponentVisitor.Draw(screenWidth1 - 25, screenHeight + 150, 100, 25);
        PongComponentVisitor.Draw(screenWidth1 + 50, screenHeight + 100, 25, 70);
        PongComponentVisitor.Draw(screenWidth1  - 25, screenHeight + 80, 100, 25);

        //de O
        PongComponentVisitor.Draw(screenWidth2 - 25, screenHeight, 25, 150);
        PongComponentVisitor.Draw(screenWidth2 - 25, screenHeight + 150, 100, 25);
        PongComponentVisitor.Draw(screenWidth2 - 25, screenHeight, 100, 25);
        PongComponentVisitor.Draw(screenWidth2 + 50, screenHeight, 25, 150);

        //de N
        PongComponentVisitor.Draw(screenWidth3, screenHeight, 25, 150);
        PongComponentVisitor.Draw(screenWidth3, screenHeight + 150, 100, 25);
        PongComponentVisitor.Draw(screenWidth3 + 75, screenHeight, 25, 150);

        //de G
        PongComponentVisitor.Draw(screenWidth4, screenHeight, 25, 150);
        PongComponentVisitor.Draw(screenWidth4, screenHeight + 150, 100, 25);
        PongComponentVisitor.Draw(screenWidth4, screenHeight, 100, 25);
        PongComponentVisitor.Draw(screenWidth4 + 75, screenHeight, 25, 75);
        PongComponentVisitor.Draw(screenWidth4 + 50, screenHeight + 70, 50, 25);
    }
}
