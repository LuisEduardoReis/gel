package net.luisreis.gel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static net.luisreis.gel.Main.TILE_SIZE;

public class Assets {

    public static Texture testTexture;
    public static Texture tilesheet;
    public static Texture spritesheet;

    public static TextureRegion[][] tileTextures;
    public static TextureRegion[][] spriteTextures;

    public static BitmapFont font;

    public static void createAssets() {
        font = new BitmapFont(Gdx.files.internal("font.fnt"));
        testTexture = new Texture("badlogic.jpg");
        tilesheet = new Texture("tilesheet.png");
        spritesheet = new Texture("spritesheet.png");

        tileTextures = TextureRegion.split(tilesheet, TILE_SIZE, TILE_SIZE);
        spriteTextures = TextureRegion.split(spritesheet, TILE_SIZE, TILE_SIZE);
    }

    public static TextureRegion getTileTextureById(int id) {
       return tileTextures[id / tileTextures.length][id % tileTextures.length];
    }
}
