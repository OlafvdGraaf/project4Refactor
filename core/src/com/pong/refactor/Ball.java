package com.pong.refactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.Random;

/**
 * Created by Dymos on 03/07/2017.
 */

public class Ball implements IPongComponent {
    float x;
    float y;

    float xV;
    private float yV;

    int hit;

    private Random randGen = new Random();

    private float relativeIntersectY;
    private float normalizedRelativeIntersectionY;
    private double bounceAngle;
    private Sound hit_1, hit_2, loss;

    public Ball(){
        hit_1 = Gdx.audio.newSound(Gdx.files.internal("sounds/hit_1.wav"));
        hit_2 = Gdx.audio.newSound(Gdx.files.internal("sounds/hit_2.wav"));
        loss = Gdx.audio.newSound(Gdx.files.internal("sounds/loss.wav"));
        x = Gdx.graphics.getWidth() * 0.5f;
        y = Gdx.graphics.getHeight() * (randGen.nextInt(9) * 0.1f);

        hit = 0;

        xV = 4;
        yV = 4;
    }

    public void accept(){

        this.UpdateVeloc();

        PongComponentVisitor.visit(this);
    }

    private void checkPaddleHit(){
        //checks if the ball hit the user paddle
        if(this.x + 20      >= PongComponentVisitor.uPaddle.x      &&
                this.x      <= PongComponentVisitor.uPaddle.x + 10 &&
                this.y + 10 >= PongComponentVisitor.uPaddle.y      &&
                this.y      <= PongComponentVisitor.uPaddle.y + PongComponentVisitor.uPaddle.adapterPaddle.paddle_height()){
            hit_1.play(1.0f);
            relativeIntersectY = (PongComponentVisitor.uPaddle.y + ( 50.0f )) - this.y;
            normalizedRelativeIntersectionY = (relativeIntersectY / ( 50/2 )) * 0.1f;
            bounceAngle = normalizedRelativeIntersectionY * 3f;

            this.calcVeloc();

            PongComponentVisitor.HitRight++;

            this.hit++;
            this.xV = this.xV - this.xV - this.xV;
        }

        //checks if the ball hit the bot paddle
        if(this.x + 20      >= PongComponentVisitor.bPaddle.x      &&
                this.x      <= PongComponentVisitor.bPaddle.x + 10 &&
                this.y + 10 >= PongComponentVisitor.bPaddle.y      &&
                this.y      <= PongComponentVisitor.bPaddle.y + PongComponentVisitor.uPaddle.adapterPaddle.paddle_height()){
            hit_2.play(1.0f);
            relativeIntersectY = (PongComponentVisitor.bPaddle.y + ( 50.0f )) - this.y;
            normalizedRelativeIntersectionY = (relativeIntersectY / ( 50/2 )) * 0.1f;
            bounceAngle = normalizedRelativeIntersectionY * 3f;

            this.calcVeloc();

            this.hit++;
            this.xV = Math.abs(this.xV);
        }
    }

    private void calcVeloc(){
        this.xV = (float)(5 * Math.cos(bounceAngle));
        this.yV = (float)(5 * -Math.sin(bounceAngle));
    }

    public void UpdateVeloc(){
        PongComponentVisitor.hasHit = false;

        if( PongComponentVisitor.closestBall == null ) { PongComponentVisitor.closestBall = this; }
        else{ if(this.x < PongComponentVisitor.closestBall.x ) { PongComponentVisitor.closestBall = this; }}

        if(this.x + 20 >= Gdx.graphics.getWidth())  { loss.play(10.f); PongComponentVisitor.hasHit = true; PongComponentVisitor.playerTwoLives.livesCount--;}
        if(this.x <= 0)                             { loss.play(10.f); PongComponentVisitor.hasHit = true; PongComponentVisitor.playerOneLives.livesCount--;}

        if(this.y + 20 >= Gdx.graphics.getHeight()){this.yV = this.yV - this.yV - this.yV;}
        if(this.y <= 0){this.yV = Math.abs(this.yV);}

        this.checkPaddleHit();

        this.x += this.xV;
        this.y += this.yV;
    }
}
