package com.pong.refactor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PONG_refactor extends ApplicationAdapter {
	private Connector connector;

	Game pong_game;

	@Override
	public void create () {
		connector = new Connector();
		connector.Save_score("AAA", 300);
		pong_game = new Game();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		pong_game.Run();

	}
	
	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}
