package Maps;

import Enemies.BugEnemy;
import Enemies.DinosaurEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.*;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import Tilesets.MasterMapTileset;
import Utils.Direction;
import Utils.Point;
import PowerUps.*;
import java.util.ArrayList;

public class LevelOne extends Map {
	
    public LevelOne(){super("test_map.txt", new MasterMapTileset(), new Point(1, 11));}

    public LevelOne(Point start, Achievement achievement){super("test_map.txt", new MasterMapTileset(), start, achievement);}

    public LevelOne(Achievement achievement) { this(new Point(1, 11), achievement); }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new BugEnemy(getPositionByTileIndex(13, 13), Direction.LEFT));
        enemies.add(new DinosaurEnemy(getPositionByTileIndex(19, 5).addY(2), getPositionByTileIndex(22, 5).addY(2), Direction.RIGHT));
        return enemies;
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        enhancedMapTiles.add(new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getPositionByTileIndex(24, 8),
                getPositionByTileIndex(27, 8),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6,16,8),
                Direction.RIGHT
        ));

        enhancedMapTiles.add(new EndLevelBox(
                getPositionByTileIndex(32, 11)
        ));
        
        for(int i = 0; i < 4; i++){
            enhancedMapTiles.add(new SkyWater(
                    getPositionByTileIndex(26 + i, 14)
            ));
            for(int j = 0; j < 2; j++) {
                enhancedMapTiles.add(new Water(
                        getPositionByTileIndex(26 + i, 15 + j)
                ));
            }
        }
        enhancedMapTiles.add(new CheckPoint(getPositionByTileIndex(15, 12)));

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        npcs.add(new Walrus(getPositionByTileIndex(30, 14).subtract(new Point(0, 13)), this, "You look lost! You need to get home!", achievement));

        return npcs;
    }
    
    @Override
    public ArrayList<PowerUp> loadPowerUps() {
        ArrayList<PowerUp> powerUps = new ArrayList<>();

        powerUps.add(new Milk(getPositionByTileIndex(16, 12)));

        return powerUps;
    }
}