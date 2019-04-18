package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.BricksGame;

public class Ball extends Actor {

    private TextureRegion ballTextureRegion;

    public Ball(TextureAtlas atlas){

        this.ballTextureRegion = atlas.findRegion("ball");

        create();

    }

    public void create(){

        setSize(ballTextureRegion.getRegionWidth(), ballTextureRegion.getRegionHeight());
        setBounds(BricksGame.V_WIDTH,BricksGame.V_HEIGHT,getWidth(),getHeight());
        setTouchable(Touchable.enabled);
        float initX = BricksGame.V_WIDTH / 2 - getWidth() / 2;
        float initY = 32 + 20 + 8;
        setX(initX);
        setY(initY);

    }

    @Override
    public void draw (Batch batch, float parentAlpha){
        batch.draw(ballTextureRegion, getX(), getY());
    }
}
