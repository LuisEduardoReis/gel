package net.luisreis.gel.ecs.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import net.luisreis.gel.ecs.components.Component;
import net.luisreis.gel.ecs.components.PlayerComponent;
import net.luisreis.gel.ecs.components.PositionComponent;
import net.luisreis.gel.ecs.entities.Entity;

import java.util.Collections;

public class PlayerSystem extends System {
    protected PlayerSystem() {
        super(Collections.<Class<? extends Component>>singletonList(PlayerComponent.class), true, false, false);
    }

    @Override
    public void processUpdate(Entity entity, float delta) {
        PlayerComponent player = entity.getComponent(PlayerComponent.class);
        PositionComponent position = entity.getComponent(PositionComponent.class);

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y += player.speed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.y -= player.speed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= player.speed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += player.speed * delta;
        }
    }
}
