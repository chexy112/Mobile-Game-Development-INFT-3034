package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

public class Brick extends Actor {

    private TextureRegion textureRegion;
    private static final String[] BRICKS ={
            "blue-brick", "red-brick", "purple-brick", "green-brick"
    };

    public Brick(TextureAtlas atlas){

        this.textureRegion = atlas.findRegion(BRICKS[new Random().nextInt(BRICKS.length)]);
    }
}
