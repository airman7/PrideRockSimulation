package engine.entity.Behaviour.impl;

import java.util.Random;
import engine.SimulationManager;
import engine.entity.Behaviour.AI;
import engine.entity.Behaviour.PathfindingBehaviour;
import engine.entity.animal.BaseAnimal;
import engine.entity.enums.Attribute;
import engine.util.Vector2;
import engine.world.Map;
import engine.world.World;

// Responsible to emitting events and setting priority of behaviours.

public class BaseAI implements AI {
  Vector2 destination;
  World world;
  PathfindingBehaviour pathfindingBehaviour;
  public BaseAI() {
    this.world = SimulationManager.world();
    this.pathfindingBehaviour = new SimplePathFindingBehaviour();
  }

  @Override
  public void update(BaseAnimal animal) {
    if(destination == null) {
      pickDestination(animal);
    } else if (animal.getPosition().equals(destination)) {
      pickDestination(animal);
    }
    moveToDestination(animal);
  }

  private void moveToDestination(BaseAnimal animal) {
    world.move(animal, getNextPosition(animal));
  }

  private void pickDestination(BaseAnimal animal) {
    Map localMap = null;
    int senseRange = animal.getAttributeSafe(Attribute.SENSE_RANGE, 1);
    try {
      localMap = world.getLocalMap(animal.getPosition(), senseRange);
    } catch (Exception e) {
      e.printStackTrace();
    }

    Random random = new Random();

    int xRandom = random.nextInt(2*senseRange) - senseRange;
    int yRandom = random.nextInt(2*senseRange) - senseRange;

    Vector2 newPosition = new Vector2(animal.getPosition().shiftPosition(xRandom, yRandom));
    if(world.validatePosition(newPosition)) {
      destination = newPosition;
    } else {
      pickDestination(animal);
    }
  }

  private Vector2 getNextPosition(BaseAnimal animal) {
    return pathfindingBehaviour.nextPosition(animal.getPosition(), destination, animal.getAttributeSafe(Attribute.SPEED, 1));
  }
}
