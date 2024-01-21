package net.luisreis.gel.ecs.components;

import net.luisreis.gel.sprites.Sprite;
import net.luisreis.gel.sprites.SpriteState;

public class SpriteComponent implements Component {
    public Sprite sprite = null;
    public SpriteState state = new SpriteState();
}
