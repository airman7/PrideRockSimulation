package engine.entity.Behaviour.impl;

import java.util.Map;
import engine.Util;
import engine.entity.Behaviour.PathfindingBehaviour;
import engine.entity.enums.AnimalEvent;
import engine.util.Vector2;

public class SimplePathFindingBehaviour implements PathfindingBehaviour {

  @Override
  public Vector2 nextPosition(Vector2 currentPosition, Vector2 destination, int speed) {
    speed  = speed == 0 ? 1 : speed;
    Vector2 newPosition = currentPosition;
    while(speed -- > 0) {
      int diffX = destination.x - newPosition.x;
      int diffY = destination.y - newPosition.y;

      if((speed + 1) % 2 == 0) {
        diffY = diffX == 0? diffY : 0;
      } else {
        diffX = diffY == 0? diffX : 0;
      }

      newPosition = newPosition.shiftPosition(Util.clamp(diffX, -1, 1),
          Util.clamp(diffY, -1, 1));
    }
    return newPosition;
  }

  @Override
  public boolean onEvent(AnimalEvent event, Map<String, String> attributes) {
    return false;
  }
}
