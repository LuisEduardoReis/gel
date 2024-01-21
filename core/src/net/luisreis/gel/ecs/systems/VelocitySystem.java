package net.luisreis.gel.ecs.systems;

import net.luisreis.gel.ecs.components.PositionComponent;
import net.luisreis.gel.ecs.components.VelocityComponent;
import net.luisreis.gel.ecs.entities.Entity;

import java.util.Arrays;

public class VelocitySystem extends AbstractSystem {
    public VelocitySystem() {
        super(Arrays.asList(VelocityComponent.class, PositionComponent.class));
    }

    @Override
    protected void processUpdate(Entity entity, float delta) {
        PositionComponent position = entity.getComponent(PositionComponent.class);
        VelocityComponent velocity = entity.getComponent(VelocityComponent.class);

        position.x += velocity.vx * delta;
        position.y += velocity.vy * delta;
    }
}
