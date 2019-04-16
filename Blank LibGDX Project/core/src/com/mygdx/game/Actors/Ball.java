package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Ball extends AbstractActor {

    public Ball(TextureAtlas atlas){

        super(atlas.findRegion("Ball"));
    }
}
