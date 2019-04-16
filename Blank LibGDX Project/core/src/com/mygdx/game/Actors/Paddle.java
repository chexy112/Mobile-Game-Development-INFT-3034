package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Paddle extends AbstractActor{

    public Paddle(TextureAtlas atlas){

        super(atlas.findRegion("paddle"));
    }
}
