package com.pong.refactor;

import com.badlogic.gdx.graphics.Color;

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
        pongList.Add(bckBTN = new Button(200, 1, 225, "Main Menu"));
        pongList.Add(volBTN0 = new Button(200, 2, -225, "Volume 0"));
        pongList.Add(volBTN1 = new Button(200, 2, 0, "Volume 1"));
        pongList.Add(volBTN2 = new Button(200, 2, 225, "Volume 2"));
        pongList.Add(difBTN1 = new Button(200, 3, -225, "Easy"));
        pongList.Add(difBTN2 = new Button(200, 3, 0, "Hard"));
        HomeScreen = new Homescreen();
        backGround = new AnimatedBackground();
    }

    public IGameState Run(){

        pongList.accept();

        backGround.Run();

        if (volBTN0.isPressed){volBTN0.color = Color.RED; volBTN1.color = Color.WHITE; volBTN2.color = Color.WHITE; HomeScreen.backgroundmusic.setVolume(0.0f);}
        if (volBTN1.isPressed){volBTN1.color = Color.RED; volBTN2.color = Color.WHITE; volBTN0.color = Color.WHITE; HomeScreen.backgroundmusic.setVolume(0.3f);}
        if (volBTN2.isPressed){volBTN2.color = Color.RED; volBTN0.color = Color.WHITE; volBTN1.color = Color.WHITE; HomeScreen.Volume = 0.6f;}
        if (difBTN1.isPressed){PongComponentVisitor.bPaddle.veloc = 8;}
        if (difBTN2.isPressed){PongComponentVisitor.bPaddle.veloc = 12;}

        if(bckBTN.isPressed){return HomeScreen;}
        else{return this;}
    }

}
