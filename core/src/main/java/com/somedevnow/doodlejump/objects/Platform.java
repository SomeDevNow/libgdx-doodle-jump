package com.somedevnow.doodlejump.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.somedevnow.doodlejump.libraries.ArcadePhysics.PhysicsInfo;

public class Platform {
    public final Vector2 position;
    public final Vector2 size;
    private Color color;
    public PhysicsInfo physicsInfo;
    private PhysicsInfo playerPhysicsInfo;

    public Platform(int x, int y, int width, int height, float gravity, float drag, Color color, PhysicsInfo playerPhysicsInfo){
        this.position = new Vector2(x, y);
        this.size = new Vector2(width, height);
        this.color = color;
        this.physicsInfo = new PhysicsInfo(new Rectangle(this.position.x, this.position.y, this.size.x, this.size.y), Vector2.Zero, gravity, drag);
        this.playerPhysicsInfo = playerPhysicsInfo;
    }

    public void draw(ShapeRenderer shape){
        shape.setColor(this.color);
        shape.rect(this.position.x, this.position.y, this.size.x, this.size.y);
    }
}
