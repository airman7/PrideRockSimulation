package engine;

import java.util.List;
import lombok.Getter;

@Getter
public class World {
  int height;
  int width;
  List<Tile> map;
  List<Entity> entities;

  public void addEntity(Entity e) {
    entities.add(e);
  }

  public void removeEntity(Entity e) {

  }

  public void moveToTarget(Entity e, int x, int y) {

  }
}
