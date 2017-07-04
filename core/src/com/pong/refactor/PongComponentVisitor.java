package com.pong.refactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Dymos on 03/07/2017.
 */

public final class PongComponentVisitor{

    static ShapeRenderer shapeRend = new ShapeRenderer();

    static UserPaddle uPaddle;
    static BotPaddle bPaddle;

    static Ball closestBall;

    static boolean hasHit = false;

    static int HitRight = 0;

    static ScoreCounter scoreCounter = new ScoreCounter();
    static Lives playerOneLives = new Lives(0.0F, (float)(Gdx.graphics.getHeight() - 100), "Player 1");
    static Lives playerTwoLives = new Lives((float)(Gdx.graphics.getWidth() - 300), (float)(Gdx.graphics.getHeight() - 100), "Player 2");


    static BitmapFont font = new BitmapFont();
    static SpriteBatch batch = new SpriteBatch();

    public static void visit(Button btn){
        PongComponentVisitor.Draw(btn.x, btn.y, btn.width, btn.height);
    }

    public static void visit(Ball ball){
        Draw(ball.x, ball.y, 20, 20);
        scoreCounter.counter = PongComponentVisitor.HitRight;
        visit(scoreCounter);
        visit(playerOneLives);
        visit(playerTwoLives);
    }

    public static void visit(BotPaddle bPaddle){
        Draw(bPaddle.x, bPaddle.y, 10, 100);
    }

    public static void visit(UserPaddle uPaddle){
        Draw(uPaddle.x, uPaddle.y, uPaddle.adapterPaddle.paddlewidth(), uPaddle.adapterPaddle.paddle_height());
    }

    public static void visit(ScoreCounter scoreCounter){
        font.setColor(Color.WHITE);
        font.getData().setScale(3);

        batch.begin();
        font.draw(batch, scoreCounter.text + String.valueOf(scoreCounter.counter), scoreCounter.x + scoreCounter.width * 0.18F, scoreCounter.y + scoreCounter.height * 0.72F);
        batch.end();
    }

    public static void visit(Lives lives){
        font.setColor(Color.WHITE);
        font.getData().setScale(3);
        
        batch.begin();
        font.draw(batch, lives.text + " : " + lives.livesCount, lives.x + lives.width * 0.18F, lives.y + lives.height * 0.72F);
        batch.end();
    }

    public static void Draw(float x, float y, float width, float height){
        shapeRend.begin(ShapeRenderer.ShapeType.Filled);
        shapeRend.rect(x, y, width, height);
        shapeRend.end();
    }

    public static void Reset(){
        closestBall = null;

        hasHit = false;

        HitRight = 0;

        scoreCounter = new ScoreCounter();
    }

}
