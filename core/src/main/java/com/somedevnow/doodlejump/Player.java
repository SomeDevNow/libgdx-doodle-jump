package com.somedevnow.doodlejump;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public final Vector2 position;
    private int size;
    private int speed;
    private Color color;

    public Player(int x, int y, int size, int speed, Color color) {
        this.position = new Vector2(x, y);
        this.size = size;
        this.speed = speed;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
