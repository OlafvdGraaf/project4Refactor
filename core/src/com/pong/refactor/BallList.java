package com.pong.refactor;

/**
 * Created by Dymos on 04/07/2017.
 */

public class BallList implements Iterator{
    private Ball[] list;
    private int current;
    private int amount;
    public BallList()
    {
        list = new Ball[50];
        current = -1;
        amount = 0;
        reset();

        this.add(new Ball());
    }

    public boolean getNext()
    {
        current++;
        if (current >= amount)
        {
            reset();
            return false;
        }
        else
        {
            return true;
        }
    }

    public Ball getCurrent()
    {
        return list[current];
    }

    public void reset()
    {
        current = -1;
    }

    public void add(Ball ball)
    {
        list[amount] = ball;
        amount++;
    }
}
