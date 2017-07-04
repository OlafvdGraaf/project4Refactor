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

    IBallState state;

    public Ball(){
        x = Gdx.graphics.getWidth() * 0.5f;
        y = Gdx.graphics.getHeight() * (randGen.nextInt(9) * 0.1f);

        hit = 0;

        xV = 5;
        yV = 5;

        state = new RightUpState();
    }

    public void accept(){

        this.state = state.Update(this);

        PongComponentVisitor.visit(this);
    }

    public boolean checkPaddleHit(){
        //checks if the ball hit the user paddle
        if(this.x + 20 >= PongComponentVisitor.uPaddle.x &&
                this.x - 10 <= PongComponentVisitor.uPaddle.x + 10 &&
                this.y + 10 >= PongComponentVisitor.uPaddle.y &&
                this.y - 10 <= PongComponentVisitor.uPaddle.y + 100){

            this.calcVeloc();

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
        if(this.y + 20 >= Gdx.graphics.getHeight()){this.yV = this.yV - this.yV - this.yV;}
        if(this.y <= 0){this.yV = Math.abs(this.yV);}

        this.x += this.xV;
        this.y += this.yV;
    }
}
