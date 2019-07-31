package engine.entity.impl;

import java.util.List;
import engine.entity.AI;
import engine.entity.Diet;
import engine.entity.Entity;
import engine.util.Vector2;

public class BaseAnimal implements Entity {

  private Vector2 position;
  private char character;
  private int color;
  private int senseRange;
  private List<Diet> diet;
  private AI aiComponent;

  public BaseAnimal(Vector2 position) {
    this.position = position;
  }

  public BaseAnimal(Builder builder) {
    this.position = builder.position;
    this.character = builder.character;
    this.color = builder.color;
    this.senseRange = builder.senseRange;
    this.diet = builder.diet;
    this.aiComponent = builder.ai;
    System.out.println("POSITION " + position);
  }

  @Override
  public Vector2 getPosition() {
    return position;
  }

  @Override
  public void updatePosition(Vector2 position) {
    this.position = position;
  }

  @Override
  public void update() {
    if (aiComponent != null) {
      aiComponent.update(this);
    }
  }

  public char getCharacter() {
    return character;
  }

  public int getColor() {
    return color;
  }

  public int getSenseRange() {
    return senseRange;
  }

  public List<Diet> getDiet() {
    return diet;
  }

  public AI getAiComponent() {
    return aiComponent;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private Vector2 position;
    private char character;
    private int color;
    private int senseRange;
    private List<Diet> diet;
    private AI ai;

    public Builder position(Vector2 position) {
      this.position = position;
      return this;
    }

    public Builder character(char character) {
      this.character = character;
      return this;
    }

    public Builder color(int color) {
      this.color = color;
      return this;
    }

    public Builder senseRange(int senseRange) {
      this.senseRange = senseRange;
      return this;
    }

    public Builder diet(List<Diet> diet) {
      this.diet = diet;
      return this;
    }

    public Builder ai(AI ai) {
      this.ai = ai;
      return this;
    }

    public BaseAnimal build() {
      return new BaseAnimal(this);
    }
  }
}
