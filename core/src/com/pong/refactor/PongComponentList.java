package com.pong.refactor;

import java.util.ArrayList;

/**
 * Created by Dymos on 03/07/2017.
 */

public class PongComponentList implements IPongComponent {

    private ArrayList<IPongComponent> componentList;

    private BallList ballList;

    public PongComponentList(){

        componentList = new ArrayList<IPongComponent>();
    }

    public void Add(IPongComponent newComponent){

        componentList.add(newComponent);
    }

    public void Add(BallList ballList){

        this.ballList = ballList;
    }

    public void accept(){

        for (IPongComponent component: componentList) { component.accept(); }

        if(this.ballList != null){ this.ItBallIt(); }
    }

    private void ItBallIt(){

        while(ballList.getNext()){

            ballList.getCurrent().accept();

            if(ballList.getCurrent().hit == 5){

                ballList.add(new Ball());
                ballList.getCurrent().hit = 0;
            }

            if(PongComponentVisitor.hasHit){

                ballList = new BallList();
                PongComponentVisitor.closestBall = null;
                break;
            }
        }
    }
}
