package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Screens.PlayScreen;
import com.mygdx.game.Screens.MenuScreen;

public class BricksGame extends Game {

    public SpriteBatch batch;

    public static final int V_WIDTH = 640;
    public static final int V_HEIGHT = 480;


	@Override
	public void create () {
	    batch = new SpriteBatch();
	    setScreen(new MenuScreen(this));

	}


	@Override
	public void render () {
        super.render();
	}

	@Override
	public void dispose () {

	}
}
