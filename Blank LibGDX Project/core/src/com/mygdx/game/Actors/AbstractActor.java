package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AbstractActor {

    private TextureRegion textureRegion;

    protected AbstractActor(TextureRegion textureRegion){

        this.textureRegion = textureRegion;
    }
}
