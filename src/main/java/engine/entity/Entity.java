package engine.entity;

import engine.util.Vector2;

public interface Entity {
  Vector2 getPosition();
  void updatePosition(Vector2 position);
  void update();
}
