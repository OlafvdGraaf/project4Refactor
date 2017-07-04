package com.pong.refactor;

import com.badlogic.gdx.Gdx;

import java.util.Random;

/**
 * Created by Dymos on 03/07/2017.
 */

public class Ball implements IPongComponent {
    float x;
    float y;

    float xV;
    float yV;

    int hit;

    Random randGen = new Random();

    public Ball(){
        x = Gdx.graphics.getWidth() * 0.5f;
        y = Gdx.graphics.getHeight() * (randGen.nextInt(9) * 0.1f);

        hit = 0;

        xV = 5;
        yV = 5;
    }

    public void accept(){

        this.UpdateVeloc();

        PongComponentVisitor.visit(this);
    }

    public boolean checkUPaddleHit(){
        //checks if the ball hit the user paddle
        if(this.x + 20 >= PongComponentVisitor.uPaddle.x &&
                this.x - 10 <= PongComponentVisitor.uPaddle.x + 10 &&
                this.y + 10 >= PongComponentVisitor.uPaddle.y &&
                this.y - 10 <= PongComponentVisitor.uPaddle.y + 100){

            this.calcVeloc();

            this.hit++;
            this.xV = this.xV - this.xV - this.xV;

            return true;
        }
        return false;
    }

    private void calcVeloc(){
        float relativeIntersectY = (PongComponentVisitor.uPaddle.y + ( 50.0f )) - this.y;
        float normalizedRelativeIntersectionY = (relativeIntersectY / ( 50/2 ));
        double bounceAngle = normalizedRelativeIntersectionY * (5 * Math.PI/12);
        this.xV = (float)(5 * Math.cos(bounceAngle));
        this.yV = (float)(5 * -Math.sin(bounceAngle));


    }

    public void UpdateVeloc(){
        PongComponentVisitor.hasHit = false;

        if(this.x + 20 >= Gdx.graphics.getWidth()){PongComponentVisitor.hasHit = true;}
        if(this.x <= 0){this.xV = Math.abs(this.xV);}

        if(this.y + 20 >= Gdx.graphics.getHeight()){this.yV = this.yV - this.yV - this.yV;}
        if(this.y <= 0){this.yV = Math.abs(this.yV);}

        this.checkUPaddleHit();

        this.x += this.xV;
        this.y += this.yV;
    }
}
