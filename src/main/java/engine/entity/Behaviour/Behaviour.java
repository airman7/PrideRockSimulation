package engine.entity.Behaviour;

import java.util.Map;
import engine.entity.enums.AnimalEvent;

public interface Behaviour {
  boolean onEvent(AnimalEvent event, Map<String, String> attributes);
}
