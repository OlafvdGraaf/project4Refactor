package com.pong.refactor;

/**
 * Created by Dymos on 03/07/2017.
 */

public interface Iterator {
    boolean getNext();
    Ball getCurrent();
    void add(Ball ball);
    void reset();
}
