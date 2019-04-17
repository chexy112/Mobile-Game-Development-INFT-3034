package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class Ball extends AbstractActor {

    private Texture textureBall;
    private Sprite spriteBall = new Sprite();

    public Ball(TextureAtlas atlas){

        super(atlas.findRegion("ball"));

        textureBall = textureRegion.getTexture();
        spriteBall.setTexture(textureBall);

        Gdx.app.log("MyGdxGame: "," create" + this.getTextureBall());

        setSize(textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
        setWidth(spriteBall.getWidth());
        setHeight(spriteBall.getHeight());
        setBounds(320,240,getWidth(),getHeight());
        setTouchable(Touchable.enabled);
        setX(0);
        setY(0);
    }

    public Texture getTextureBall() {
        return textureBall;
    }
    public Sprite getSpriteBall(){ return spriteBall; }
}
