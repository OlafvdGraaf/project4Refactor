package com.pong.refactor;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Dymos on 03/07/2017.
 */

public final class PongComponentVisitor{

    static ShapeRenderer shapeRend = new ShapeRenderer();

    static UserPaddle uPaddle;
    //static BotPaddle bPaddle;

    static boolean hasHit = false;

    public static void visit(Button btn){
        PongComponentVisitor.Draw(btn.x, btn.y, btn.width, btn.height);
    }

    public static void visit(Ball ball){
        PongComponentVisitor.Draw(ball.x, ball.y, 20, 20);
    }

    public static void visit(UserPaddle uPaddle){
        PongComponentVisitor.Draw(uPaddle.x, uPaddle.y, uPaddle.adapterPaddle.paddlewidth(), uPaddle.adapterPaddle.paddle_height());
    }

    public static void Draw(float x, float y, float width, float height){
        shapeRend.begin(ShapeRenderer.ShapeType.Filled);
        shapeRend.rect(x, y, width, height);
        shapeRend.end();
    }


}
