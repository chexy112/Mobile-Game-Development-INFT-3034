package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ball extends AbstractActor {

    public Ball(TextureAtlas atlas){

        super(atlas.findRegion("Ball"));
    }
}
