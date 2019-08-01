package engine.util;

import java.util.Objects;

public class Vector2 {
  public int x;
  public int y;

  public Vector2() {
    this.x = 0;
    this.y = 0;
  }

  public Vector2(Vector2 v) {
    this.x = v.x;
    this.y = v.y;
  }

  public Vector2(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Vector2 shiftPosition(int x, int y) {
    Vector2 v = new Vector2(this);
    v.x += x;
    v.y += y;
    return v;
  }

  @Override
  public String toString() {
    return "{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vector2 vector2 = (Vector2) o;
    return x == vector2.x &&
        y == vector2.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
