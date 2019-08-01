package engine.error;

import engine.entity.enums.Attribute;

public class AnimalAttributeNotFound extends Exception {
  public AnimalAttributeNotFound(Attribute attribute) {
    super("Animal Attribute " + attribute.toString() + " Not Found.");
  }
}
