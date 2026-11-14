package com.somedevnow.doodlejump.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.somedevnow.doodlejump.libraries.ArcadePhysics.PhysicsInfo;

public class Player {
    public final Vector2 position;
    private int size;
    private int speed;
    private Color color;
    public PhysicsInfo physicsInfo;

    public Player(int x, int y, int size, int speed, float gravity, float drag,  Color color) {
        this.position = new Vector2(x, y);
        this.size = size;
        this.speed = speed;
        this.color = color;
        this.physicsInfo = new PhysicsInfo(new Rectangle(this.position.x, this.position.y, this.size.x, this.size.y), Vector2.Zero, gravity, drag);
    }

    public void input(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.position.add(-(this.getSpeed() * delta),0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.position.add(this.getSpeed() * delta,0);
        }

        this.position.set(MathUtils.clamp(this.position.x, 0, 600-this.getSize()), this.position.y);
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(this.getColor());
        shape.rect(this.position.x, this.position.y, this.getSize(), this.getSize());
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
