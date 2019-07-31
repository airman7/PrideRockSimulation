package engine.entity.impl;

import java.util.Random;
import engine.SimulationManager;
import engine.Util;
import engine.entity.AI;
import engine.entity.impl.BaseAnimal;
import engine.util.Vector2;
import engine.world.Map;
import engine.world.World;

public class BaseAI implements AI {
  Vector2 destination;
  World world;

  public BaseAI() {
    this.world = SimulationManager.world();
  }

  @Override
  public void update(BaseAnimal animal) {
    if(destination == null) {
      pickDestination(animal);
    } else if (animal.getPosition().equals(destination)) {
      System.out.print("Reached Destination");
      pickDestination(animal);
    }
    moveToDestination(animal);
    System.out.print(" Current Position" + animal.getPosition());
  }

  private void moveToDestination(BaseAnimal animal) {
    world.move(animal, getNextPosition(animal));
  }

  private void pickDestination(BaseAnimal animal) {
    Map localMap = null;
    try {

      localMap = world.getLocalMap(animal.getPosition(), animal.getSenseRange());
    } catch (Exception e) {
      e.printStackTrace();
    }

    Random random = new Random();

    int xRandom = random.nextInt(2*animal.getSenseRange()) - animal.getSenseRange();
    int yRandom = random.nextInt(2*animal.getSenseRange()) - animal.getSenseRange();

    Vector2 newPosition = new Vector2(animal.getPosition().shiftPosition(xRandom, yRandom));
    if(world.validatePosition(newPosition)) {
      destination = newPosition;
      System.out.print(" DESTINATION: " + destination);
    } else {
      pickDestination(animal);
    }
  }

  private Vector2 getNextPosition(BaseAnimal animal) {
    Vector2 currentPosition = animal.getPosition();
    Vector2 newPosition = currentPosition.shiftPosition(Util.clamp(destination.x - currentPosition.x, -1, 1),
        Util.clamp(destination.y - currentPosition.y, -1, 1));
    System.out.print(" MOVING TO " + newPosition);
    return newPosition;
  }
}
