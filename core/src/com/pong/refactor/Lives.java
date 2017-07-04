package com.pong.refactor;

import java.awt.Color;

/**
 * Created by Dymos on 04/07/2017.
 */

public class Lives implements IPongComponent {
    float x;
    float y;
    float height;
    float width;
    int livesCount;
    String text;

    public Lives(float x, float y, String text) {
        this.x = x;
        this.y = y;
        this.height = 100.0F;
        this.width = 300.0F;
        this.livesCount = 3;
        this.text = text;
    }

    public void accept() {
        PongComponentVisitor.visit(this);
    }
}
