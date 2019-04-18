package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.BricksGame;

import java.util.Random;

public class Brick extends Actor {

    private TextureRegion brickTextureRegion;
    private static final String[] BRICKS ={
            "blue-brick", "red-brick", "purple-brick", "green-brick"
    };

    public Brick(TextureAtlas atlas){

        this.brickTextureRegion = atlas.findRegion(BRICKS[new Random().nextInt(BRICKS.length)]);
    }

    public void create(){

        setSize(brickTextureRegion.getRegionWidth(), brickTextureRegion.getRegionHeight());

        setBounds(BricksGame.V_WIDTH,BricksGame.V_HEIGHT,getWidth(),getHeight());
        setTouchable(Touchable.enabled);
        setX(0);
        setY(0);

    }

    @Override
    public void draw (Batch batch, float parentAlpha){
        batch.draw(brickTextureRegion, getX(), getY());
    }
}
