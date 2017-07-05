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

    static BitmapFont endFont = new BitmapFont();
    static BitmapFont uiFont = new BitmapFont();
    static BitmapFont btnFont = new BitmapFont();
    static SpriteBatch batch = new SpriteBatch();

    public static void visit(Button btn){
        btnFont.setColor(Color.BLACK);
        btnFont.getData().setScale(1.5f);
        shapeRend.setColor(btn.color);
        Draw(btn.x, btn.y, btn.width, btn.height);
        shapeRend.setColor(Color.WHITE);
        batch.begin();
        btnFont.draw(batch, btn.text, (btn.x+btn.width*0.10f), (btn.y+btn.height*0.65f));
        batch.end();
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
        uiFont.setColor(Color.WHITE);
        uiFont.getData().setScale(3);

        batch.begin();
        uiFont.draw(batch, scoreCounter.text + String.valueOf(scoreCounter.counter), scoreCounter.x + scoreCounter.width * 0.18F, scoreCounter.y + scoreCounter.height * 0.72F);
        batch.end();
    }

    public static void visit(Lives lives){
        uiFont.setColor(Color.WHITE);
        uiFont.getData().setScale(3);

        batch.begin();
        uiFont.draw(batch, lives.text + " : " + lives.livesCount, lives.x + lives.width * 0.18F, lives.y + lives.height * 0.72F);
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

        playerOneLives = new Lives(0.0F, (float)(Gdx.graphics.getHeight() - 100), "Player 1");

        playerTwoLives = new Lives((float)(Gdx.graphics.getWidth() - 300), (float)(Gdx.graphics.getHeight() - 100), "Player 2");

    }

}
