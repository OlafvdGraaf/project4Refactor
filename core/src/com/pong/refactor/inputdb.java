package com.pong.refactor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input.TextInputListener;

/**
 * Created by groot on 5-7-2017.
 */

public class inputdb extends ApplicationAdapter implements TextInputListener {
String text;

    @Override
    public void input (String text) {
        this.text = text;
    }

    @Override
    public void canceled () {
        this.text = "No_name";
    }






}
