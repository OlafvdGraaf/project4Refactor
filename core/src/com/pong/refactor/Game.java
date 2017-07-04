package com.pong.refactor;

/**
 * Created by Dymos on 03/07/2017.
 */

public class Game {

    private IGameState currentState;

    public Game(){

        currentState = new Homescreen();
    }

    public void Run(){
        this.currentState = this.currentState.Run();
    }
}
