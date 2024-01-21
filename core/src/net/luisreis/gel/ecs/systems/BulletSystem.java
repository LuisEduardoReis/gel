package net.luisreis.gel.ecs.systems;

import net.luisreis.gel.Util;
import net.luisreis.gel.ecs.components.BulletComponent;
import net.luisreis.gel.ecs.components.PositionComponent;
import net.luisreis.gel.ecs.entities.Entity;

import java.util.Collections;

public class BulletSystem extends AbstractSystem {

    public static float REMOVE_BORDER_RADIUS = 10;
    protected BulletSystem() {
        super(Collections.singletonList(BulletComponent.class));
    }

    @Override
    protected void processUpdate(Entity entity, float delta) {
        PositionComponent position = entity.getComponent(PositionComponent.class);

        if (!Util.isBetween(position.x, -REMOVE_BORDER_RADIUS, entity.level.width + REMOVE_BORDER_RADIUS) ||
            !Util.isBetween(position.y, -REMOVE_BORDER_RADIUS, entity.level.height + REMOVE_BORDER_RADIUS)) {
            entity.remove = true;
        }
    }
}
