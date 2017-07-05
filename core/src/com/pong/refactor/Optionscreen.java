package com.pong.refactor;

/**
 * Created by felixdejonge on 04/07/2017.
 */

public class Optionscreen implements IGameState {

    PongComponentList pongList;

    Button bckBTN;
    Button volBTN0;
    Button volBTN1;
    Button volBTN2;
    Button difBTN1;
    Button difBTN2;


    AnimatedBackground backGround;

    public Optionscreen(){

        pongList = new PongComponentList();
        pongList.Add(bckBTN = new Button(100, 1, 0));
        pongList.Add(volBTN0 = new Button(100, 2, -120));
        pongList.Add(volBTN1 = new Button(100, 2, 0));
        pongList.Add(volBTN2 = new Button(100, 2, 120));
        pongList.Add(difBTN1 = new Button(100, 3, -120));
        pongList.Add(difBTN2 = new Button(100, 3, 0));

        backGround = new AnimatedBackground();
    }

    public IGameState Run(){

        pongList.accept();

        backGround.Run();

        if (volBTN0.isPressed){}

        if(bckBTN.isPressed){return new Homescreen();}
        else{return this;}
    }

}
