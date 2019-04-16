package com.mygdx.game.Scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BricksGame;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.graphics.Color;

public class Hud {

    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private  Integer score;

    Label scoreLabel;
    Label timeLabel;
    Label playerLabel;
    Label worldLabel;

    public Hud(SpriteBatch sb){
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new StretchViewport(BricksGame.V_WIDTH, BricksGame.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLabel = new Label("WORLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        playerLabel = new Label("PLAYER", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(playerLabel).expandX().padTop(16);
        table.add(worldLabel).expandX().padTop(16);
        table.add(timeLabel).expandX().padTop(16);
        table.row();
        table.add(scoreLabel).expandX();

        stage.addActor(table);

    }
}
