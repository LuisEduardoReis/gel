package net.luisreis.gel.ecs.entities;

import net.luisreis.gel.ecs.components.*;
import net.luisreis.gel.level.Level;
import net.luisreis.gel.sprites.SpriteAssets;

public class TestBullet {

    public static Entity instance(Level level) {
        Entity bullet = new Entity(level)
                .addComponent(new PositionComponent())
                .addComponent(new VelocityComponent())
                .addComponent(new SpriteComponent())
                .addComponent(new BulletComponent());

        bullet.getComponent(SpriteComponent.class).sprite = SpriteAssets.testSprite;
        bullet.getComponent(SpriteComponent.class).state.scaleX = 0.5f;
        bullet.getComponent(SpriteComponent.class).state.scaleY = 0.5f;

        return bullet;
    }

}
