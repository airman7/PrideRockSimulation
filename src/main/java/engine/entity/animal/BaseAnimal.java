package engine.entity.animal;

import java.util.HashMap;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import engine.entity.Behaviour.AI;
import engine.entity.enums.Attribute;
import engine.entity.Entity;
import engine.error.AnimalAttributeNotFound;
import engine.util.Vector2;

public class BaseAnimal implements Entity {

  private AI aiComponent;
  Map<Attribute, Integer> attributes;

  public BaseAnimal(AI aiComponent) {
    this.aiComponent = aiComponent;
    this.attributes = new HashMap<Attribute, Integer>();
  }

  @Override
  public Vector2 getPosition()  {
    return new Vector2(getAttributeSafe(Attribute.POSITION_X, 0), getAttributeSafe(Attribute.POSITION_Y, 0));
  }

  @Override
  public void updatePosition(Vector2 position) {
    this.attributes.put(Attribute.POSITION_X, position.x);
    this.attributes.put(Attribute.POSITION_Y, position.y);
  }

  @Override
  public void update() {
    if (aiComponent != null) {
      aiComponent.update(this);
    }
  }

  public AI getAiComponent() {
    return aiComponent;
  }

  public BaseAnimal setAttribute(Attribute attribute, Integer value) {
    this.attributes.put(attribute, value);
    return this;
  }

  public Integer getAttributeSafe(Attribute attribute, Integer defaultValue) {
    Integer value = attributes.get(attribute);
    return value == null ? defaultValue : value;
  }
}
