package com.somedevnow.doodlejump.libraries;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class ArcadePhysics {
    public record PhysicsInfo(Rectangle rectangle, Vector2 velocity, float gravity, float drag) {}
}
