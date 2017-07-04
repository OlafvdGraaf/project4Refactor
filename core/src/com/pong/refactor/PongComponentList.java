package com.pong.refactor;

import java.util.ArrayList;

/**
 * Created by Dymos on 03/07/2017.
 */

public class PongComponentList implements IPongComponent {

    private ArrayList<IPongComponent> componentList;

    public PongComponentList(){

        componentList = new ArrayList<IPongComponent>();
    }

    public void Add(IPongComponent newComponent){

        componentList.add(newComponent);
    }

    public void accept(){
        for (IPongComponent component: componentList) {

            component.accept();
        }
    }

    public BallList accept(BallList ballList){

        while(ballList.getNext()){
            ballList.getCurrent().accept();

            if(ballList.getCurrent().hit == 5){
                ballList.add(new Ball());
                ballList.getCurrent().hit = 0;
            }

            if(PongComponentVisitor.hasHit){

                BallList newBallList = new BallList();
                newBallList.add(new Ball());
                newBallList.reset();
                return newBallList;
            }
        }
        return ballList;
    }
}
