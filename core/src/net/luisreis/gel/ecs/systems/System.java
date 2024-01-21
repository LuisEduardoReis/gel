package net.luisreis.gel.ecs.systems;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.luisreis.gel.ecs.components.Component;
import net.luisreis.gel.ecs.entities.Entity;

import java.util.Collection;

public abstract class System {

    public final Collection<Class<? extends Component>> requiredComponents;
    public final boolean hasUpdateVisitor;
    public final boolean hasSpriteBatchVisitor;
    public final boolean hasShapeRendererVisitor;

    protected System(
            Collection<Class<? extends Component>> requiredComponents,
            boolean hasUpdateVisitor,
            boolean hasSpriteBatchVisitor,
            boolean hasShapeRendererVisitor
    ) {
        this.requiredComponents = requiredComponents;

        this.hasUpdateVisitor = hasUpdateVisitor;
        this.hasSpriteBatchVisitor = hasSpriteBatchVisitor;
        this.hasShapeRendererVisitor = hasShapeRendererVisitor;
    }

    public void visitUpdate(Entity entity, float delta) {
        if (entity.hasComponents(this.requiredComponents)) {
            this.processUpdate(entity, delta);
        }
    }
    protected void processUpdate(Entity entity, float delta) {}

    public void visitSpriteBatch(Entity entity, SpriteBatch spriteBatch) {
        if (entity.hasComponents(this.requiredComponents)) {
            this.processSpriteBatch(entity, spriteBatch);
        }
    }
    protected void processSpriteBatch(Entity entity, SpriteBatch spriteBatch) {}

    public void visitShapeRenderer(Entity entity, ShapeRenderer shapeRenderer) {
        if (entity.hasComponents(this.requiredComponents)) {
            this.processShapeRenderer(entity, shapeRenderer);
        }
    }
    protected void processShapeRenderer(Entity entity, ShapeRenderer shapeRenderer) {}
}
