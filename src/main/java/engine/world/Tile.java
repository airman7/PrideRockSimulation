package engine.world;

import engine.entity.Entity;

public class Tile {
  TileType tileType;
  Entity entity;

  public Tile(TileType tileType) {
    this.tileType = tileType;
  }

  public Tile(TileType tileType, Entity entity) {
    this.tileType = tileType;
    this.entity = entity;
  }

  public TileType getTileType() {
    return tileType;
  }

  public void setTileType(TileType tileType) {
    this.tileType = tileType;
  }

  public Entity getEntity() {
    return entity;
  }

  public void setEntity(Entity entity) {
    this.entity = entity;
  }
}
