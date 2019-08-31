package engine;

import java.util.List;
import lombok.Getter;

@Getter
public class World {
  int height;
  int width;
  List<Tile> map;
  List<Entity> entities;
}
