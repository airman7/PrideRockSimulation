package engine.world;

import static engine.world.TileType.*;
import java.util.ArrayList;
import java.util.List;
import engine.Util;
import engine.entity.animal.BaseAnimal;
import engine.entity.Entity;
import engine.entity.Behaviour.impl.BaseAI;
import engine.entity.enums.Attribute;
import engine.error.AnimalAttributeNotFound;
import engine.util.Vector2;

public class World {

  int size;
  List<Entity> entityList;

  public World() {
  }

  public void init(int size, String[][] data) {
    Tile[][] worldMap = new Tile[size][size];

    for(int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        worldMap[i][j] = new Tile(valueOf(data[i][j]));
      }
    }
    Map.setTiles(worldMap);
    Map.setMaxTileSize(size);
    this.size = size;
    BaseAnimal animal = new BaseAnimal(new BaseAI());
    animal.setAttribute(Attribute.POSITION_X, 0)
        .setAttribute(Attribute.POSITION_Y, 0)
        .setAttribute(Attribute.SENSE_RANGE, 3)
        .setAttribute(Attribute.SPEED, 2);
    entityList = new ArrayList<Entity>();
    entityList.add(animal);
  }

  public Map getLocalMap(Vector2 centerPoint, int senseRange) throws Exception {
    return Map.localMap(centerPoint.shiftPosition(-senseRange, -senseRange),
        centerPoint.shiftPosition(senseRange, senseRange));
  }

  public void printWorld(Vector2 startTile, Vector2 endTile){
    Map.printWorld(startTile, endTile);
  }

  public boolean move(Entity entity, Vector2 position) {
    if(validatePosition(position) && Map.getTiles()[position.x][position.y].getEntity() == null) {
      Map.getTiles()[entity.getPosition().x][entity.getPosition().y].setEntity(null);
      Map.getTiles()[position.x][position.y].setEntity(entity);
      entity.updatePosition(position);
      return true;
    }
    return false;
  }

  public boolean validatePosition(Vector2 position) {
    return position.x >= 0 && position.x < size && position.y >= 0 && position.y < size;
  }

  public void update() {
    for(Entity e: entityList) {
      Util.clearScreen();
      e.update();
      printWorld(new Vector2(0,0), new Vector2(size - 1, size - 1));
    }
  }

}
