package com.somedevnow.doodlejump;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.math.MathUtils;

import com.somedevnow.doodlejump.Player;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DoodleJumpGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ShapeRenderer shape;
    private FitViewport viewport;
    private Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        viewport = new FitViewport(600,800);
        player = new Player(284, 100,48, 350, Color.valueOf("#364996"));
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    public void input() {
        float delta = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)) {
            player.position.add(-(player.getSpeed() * delta),0);
        } else if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)) {
            player.position.add(player.getSpeed() * delta,0);
        }

        player.position.set(MathUtils.clamp(player.position.x, 0, 600-player.getSize()), player.position.y);
    }

    public void logic() {

    }

    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.begin();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.valueOf("#8cbade"));
        shape.rect(0,0,600,800);

        shape.setColor(player.getColor());
        shape.rect(player.position.x, player.position.y, player.getSize(), player.getSize());

        shape.end();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shape.dispose();
    }
}
