package com.somedevnow.doodlejump;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class Platform {
    public final Vector2 position;
    public final Vector2 size;
    private Color color;

    public Platform(int x, int y, int width, int height, Color color){
        this.position = new Vector2(x, y);
        this.size = new Vector2(width, height);
        this.color = color;
    }

    public void draw(ShapeRenderer shape){
        shape.setColor(this.color);
        shape.rect(this.position.x, this.position.y, this.size.x, this.size.y);
    }
}
