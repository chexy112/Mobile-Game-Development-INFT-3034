package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Random;

public class Brick extends AbstractActor {

    private static final String[] BRICKS ={
            "blue-brick", "red-brick", "purple-brick", "green-brick"
    };

    public Brick(TextureAtlas atlas){

        super(atlas.findRegion(BRICKS[new Random().nextInt(BRICKS.length)]));
    }
}
