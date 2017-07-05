package com.pong.refactor;

import java.awt.Color;

/**
 * Created by Dymos on 03/07/2017.
 */

public class Game {

    private IGameState currentState;
    Homescreen HomeScreen;
    PongGame Pong_Game;

    public Game(){
        HomeScreen = new Homescreen();
        currentState = HomeScreen;
    }

    public void Run(){
        this.currentState = this.currentState.Run();
    }
}
