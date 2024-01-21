package net.luisreis.gel.level;

import java.util.HashMap;
import java.util.Map;

public class TileType {

    public static Map<Integer, TileType> TILETYPES_BY_ID = new HashMap<>();
    public static Map<String, TileType> TILETYPES = new HashMap<>();
    public static TileType EMPTY_TILE;
    public static int TILESHEET_SIZE = 16;


    static {
        for (int i = 0; i < TILESHEET_SIZE*TILESHEET_SIZE; i++) {
            createTileType(i, new TileType(true));
        }
        EMPTY_TILE = getTileTypeBySheetPosition(1,0).setSolid(false).setName("empty");
        getTileTypeBySheetPosition(0,0).setSolid(true).setName("test");
    }

    public static void createTileType(int id, TileType type) {
        TILETYPES_BY_ID.put(id, type);
        type.id = id;
    }

    public static TileType getTileType(String name) {
        if (TILETYPES.containsKey(name)) {
            return TILETYPES.get(name);
        } else {
            return TILETYPES.get("test");
        }
    }
    public static TileType getTileTypeById(int id) {
        if (TILETYPES_BY_ID.containsKey(id)) {
            return TILETYPES_BY_ID.get(id);
        } else {
            return TILETYPES.get("test");
        }
    }
    public static TileType getTileTypeBySheetPosition(int x, int y) {
        if (TILETYPES_BY_ID.containsKey(y * TILESHEET_SIZE + x)) {
            return TILETYPES_BY_ID.get(y * TILESHEET_SIZE + x);
        } else {
            return TILETYPES.get("test");
        }
    }

    public boolean solid;
    public String name;
    public int id;

    TileType(boolean solid) {
        this.solid = solid;
    }

    private TileType setSolid(boolean solid) {
        this.solid = solid;
        return this;
    }

    private TileType setName(String name) {
        this.name = name;
        TILETYPES.put(name, this);
        return this;
    }
}
