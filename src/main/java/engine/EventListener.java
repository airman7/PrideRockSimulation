package engine;

import java.util.Map;

public interface EventListener {
  void onEvent(String eventName, Map<String, Object> context);
}
