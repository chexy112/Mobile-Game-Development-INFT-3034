package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.MenuScreen;

public class BricksGame extends Game {

    public SpriteBatch batch;

    public static final int V_WIDTH = 640;
    public static final int V_HEIGHT = 480;

	public Music bgm;

	@Override
	public void create () {
	    batch = new SpriteBatch();
	    setScreen(new MenuScreen(this));
		bgm = Gdx.audio.newMusic(Gdx.files.internal("level1.ogg"));
		bgm.setLooping(true);
		bgm.setVolume(0.2f);
		bgm.play();

	}


	@Override
	public void render () {
        super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
