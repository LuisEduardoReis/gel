package net.luisreis.gel.ecs.systems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.luisreis.gel.ecs.entities.Entity;

import java.util.ArrayList;
import java.util.Collection;

public class Systems {
    public Collection<System> systems;

    public Systems() {
        this.systems = new ArrayList<>();

        this.systems.add(new PlayerSystem());
        this.systems.add(new SpriteSystem());
    }

    public void update(Collection<Entity> entities, float delta) {
        for (System system : this.systems) {
            if (!system.hasUpdateVisitor) continue;
            for (Entity entity : entities) {
                system.visitUpdate(entity, delta);
            }
        }
    }

    public void renderSprites(Collection<Entity> entities, SpriteBatch spriteBatch) {
        for (System system : this.systems) {
            if (!system.hasSpriteBatchVisitor) continue;
            for (Entity entity : entities) {
                system.visitSpriteBatch(entity, spriteBatch);
            }
        }
    }

    public void renderShapes(Collection<Entity> entities, ShapeRenderer shapeRenderer) {
        for (System system : this.systems) {
            if (!system.hasShapeRendererVisitor) continue;
            for (Entity entity : entities) {
                system.visitShapeRenderer(entity, shapeRenderer);
            }
        }
    }
}
