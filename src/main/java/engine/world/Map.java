package engine.world;

import static engine.world.TileType.GRASS;
import static engine.world.TileType.GROUND;
import static engine.world.TileType.ROCK;
import static engine.world.TileType.TREE;
import static engine.world.TileType.WATER;
import java.util.Vector;
import engine.util.Vector2;

public class Map {
  private static Tile[][] tiles;
  private static int maxTileSize;
  Vector2 startTile;
  Vector2 endTile;
  int localMapSize;

  public static void setTiles(Tile[][] tiles) {
    System.out.println("SETTING TILES");
    Map.tiles = tiles;
    printWorld(new Vector2(0,0), new Vector2(tiles.length, tiles.length));
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
    System.out.println("Printing " + startTile + " End tile " + endTile);
    for(int j = startTile.y; j < endTile.y; j++) {
      for (int i = startTile.x; i < endTile.x; i++) {
        switch (tiles[i][j].tileType) {
          case GRASS:
            System.out.print("G");
            break;
          case GROUND:
            System.out.print("B");
            break;
          case WATER:
            System.out.print("W");
            break;
          case TREE:
            System.out.print("T");
            break;
          case ROCK:
            System.out.print("R");
            break;
          default:
            System.out.print("0");
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
