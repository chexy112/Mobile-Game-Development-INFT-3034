package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class AbstractActor extends Actor {

    private TextureRegion textureRegion;

    protected AbstractActor(TextureRegion textureRegion){

        this.textureRegion = textureRegion;
    }
}
