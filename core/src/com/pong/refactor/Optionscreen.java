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
    Homescreen HomeScreen;


    AnimatedBackground backGround;

    public Optionscreen(){

        pongList = new PongComponentList();
        pongList.Add(bckBTN = new Button(100, 1, 0, "Main Menu"));
        pongList.Add(volBTN0 = new Button(100, 2, -120, "Volume 0"));
        pongList.Add(volBTN1 = new Button(100, 2, 0, "Volume 1"));
        pongList.Add(volBTN2 = new Button(100, 2, 120, "Volume 2"));
        pongList.Add(difBTN1 = new Button(100, 3, -120, "Easy"));
        pongList.Add(difBTN2 = new Button(100, 3, 0, "Hard"));
        HomeScreen = new Homescreen();
        backGround = new AnimatedBackground();
    }

    public IGameState Run(){

        pongList.accept();

        backGround.Run();

        if (volBTN0.isPressed){HomeScreen.Volume = 0f;}
        if (volBTN1.isPressed){HomeScreen.Volume = 50f;}
        if (volBTN2.isPressed){HomeScreen.Volume = 100f;}
        if (difBTN1.isPressed){PongComponentVisitor.bPaddle.veloc = 8;}
        if (difBTN2.isPressed){PongComponentVisitor.bPaddle.veloc = 12;}

        if(bckBTN.isPressed){return HomeScreen;}
        else{return this;}
    }

}
