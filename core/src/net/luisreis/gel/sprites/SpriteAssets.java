package net.luisreis.gel.sprites;

import static net.luisreis.gel.Assets.spriteTextures;

public class SpriteAssets {

    public static Sprite testSprite;
    public static Sprite testAnimatedSprite;

    public static void initSprites() {
        testSprite = Sprite.staticSprite(spriteTextures[0][1]);
        testAnimatedSprite = new Sprite()
                .addState("default", new SpriteAnimation()
                        .addFrame(spriteTextures[0][1])
                        .addFrame(spriteTextures[0][2])
                        .addFrame(spriteTextures[0][3])
                        .addFrame(spriteTextures[0][4])
                );
    }
}
