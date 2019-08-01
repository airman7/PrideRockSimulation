package engine.entity.Behaviour;

import engine.util.Vector2;

public interface PathfindingBehaviour extends Behaviour{
  Vector2 nextPosition(Vector2 currentPostion, Vector2 destination, int speed);
}
