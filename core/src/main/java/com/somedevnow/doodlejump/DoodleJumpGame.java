package com.somedevnow.doodlejump;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.MathUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DoodleJumpGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ShapeRenderer shape;
    private FitViewport viewport;
    private Player player;
    private Array<Platform> platformArray;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        viewport = new FitViewport(600,800);
        player = new Player(284, 100,48, 450, Color.valueOf("#364996"));
        platformArray = new Array<Platform>();
        platformArray.add(new Platform(260, 48, 80, 24, Color.valueOf("#4d8a7e")));
        for (int i = 1; i < 9; i++) {
            platformArray.add(new Platform(MathUtils.random(40, 560), 100+i*64, 80, 24, Color.valueOf("#4d8a7e")));
        }
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

        player.input(delta);
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

        player.draw(shape);

        for (Platform platform : platformArray) {
            platform.draw(shape);
        }

        shape.end();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shape.dispose();
    }
}
