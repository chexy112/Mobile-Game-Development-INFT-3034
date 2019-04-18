package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.BricksGame;


public class Paddle extends Actor {

    private TextureRegion paddleTextureRegion;

    public Paddle(TextureAtlas atlas, World world){

        this.paddleTextureRegion = atlas.findRegion("paddle");
        create();
    }

    private void create() {
        //setting paddle location size
        setSize(paddleTextureRegion.getRegionWidth(), paddleTextureRegion.getRegionHeight());
        setBounds(BricksGame.V_WIDTH, BricksGame.V_HEIGHT, getWidth(), getHeight());
        setTouchable(Touchable.enabled);
        float initX = BricksGame.V_WIDTH / 2 - getWidth() / 2;
        float initY = 32 + getHeight()/2;
        setX(initX);
        setY(initY);
    }


    @Override
    public void draw (Batch batch, float parentAlpha){
        batch.draw(paddleTextureRegion, getX(), getY());
    }
}
