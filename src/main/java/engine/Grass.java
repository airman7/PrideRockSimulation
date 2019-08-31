package engine;

import java.util.Map;
import lombok.Builder;

@Builder
public class Grass implements EventListener, Behaviour {
  Entity e;
  EventManager em = new EventManager();
  World w = new World();

  Grass(Entity e) {
    this.e = e;
    em.register("UNDER_ATTACK", this);
    this.e.behaviour = this;
  }

  @Override
  public void onEvent(String eventName, Map<String, Object> context) {
    switch (eventName) {
      case "UNDER_ATTACK":
      {

      }
      break;

    }
  }

  @Override
  public void onUpdate() {

  }
}
