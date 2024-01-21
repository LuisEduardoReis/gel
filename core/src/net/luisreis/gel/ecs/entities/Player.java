package net.luisreis.gel.ecs.entities;

import net.luisreis.gel.ecs.components.PlayerComponent;
import net.luisreis.gel.ecs.components.PositionComponent;
import net.luisreis.gel.ecs.components.SpriteComponent;
import net.luisreis.gel.level.Level;
import net.luisreis.gel.sprites.SpriteAssets;

public class Player {
    public static Entity instance(Level level) {
        Entity player = new Entity(level)
                .addComponent(new PositionComponent())
                .addComponent(new PlayerComponent())
                .addComponent(new SpriteComponent());

        player.getComponent(SpriteComponent.class).sprite = SpriteAssets.testAnimatedSprite;

        return player;
    }
}
