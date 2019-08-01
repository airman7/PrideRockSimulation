package engine.world;

import static engine.world.TileType.GRASS;
import static engine.world.TileType.GROUND;
import static engine.world.TileType.ROCK;
import static engine.world.TileType.TREE;
import static engine.world.TileType.WATER;
import java.util.Vector;
import engine.Util;
import engine.entity.Entity;
import engine.util.Vector2;

public class Map {
  private static Tile[][] tiles;
  private static int maxTileSize;
  Vector2 startTile;
  Vector2 endTile;
  int localMapSize;

  public static void setTiles(Tile[][] tiles) {
    Map.tiles = tiles;
  }

  public static void setMaxTileSize(int maxTileSize) {
    Map.maxTileSize = maxTileSize;
  }

  public static Tile[][] getTiles() {
    return tiles;
  }

  public static int getMaxTileSize() {
    return maxTileSize;
  }

  public static void printWorld(Vector2 startTile, Vector2 endTile) {
     for(int j = startTile.y; j < endTile.y; j++) {
      for (int i = startTile.x; i < endTile.x; i++) {
        Entity e = tiles[i][j].getEntity();
        if(e != null) {
          Util.colorPrint(Util.ANSI_RED,"@");
        } else {
          switch (tiles[i][j].tileType) {
            case GRASS:
              Util.colorPrint(Util.ANSI_GREEN, "G");
              break;
            case GROUND:
              Util.colorPrint(Util.ANSI_GREEN, "B");
              break;
            case WATER:
              Util.colorPrint(Util.ANSI_GREEN, "W");
              break;
            case TREE:
              Util.colorPrint(Util.ANSI_GREEN, "T");
              break;
            case ROCK:
              Util.colorPrint(Util.ANSI_GREEN, "R");
              break;
            default:
              Util.colorPrint(Util.ANSI_GREEN, "0");
          }
        }
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public Map(Vector2 startTile, Vector2 endTile) throws Exception {
    this.startTile = startTile;
    this.endTile = endTile;
    if(endTile.x - startTile.x == endTile.y - startTile.y) {
      localMapSize = endTile.x - startTile.x + 1;
    } else {
      throw new Exception("Map should be square");
    }
  }

  public static Map localMap(Vector2 startTile, Vector2 endTile) throws Exception {
    if(tiles == null) {
      throw new Exception("World Map is not set");
    }
    Map localMap = new Map(startTile, endTile);
    return localMap;
  }


}
