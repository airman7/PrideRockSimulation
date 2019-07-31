package engine;

import java.util.HashMap;
import java.util.Map;
import engine.util.Time;
import engine.world.World;

public class SimulationManager {
  private Map<SimulationOption, Integer> options;
  static SimulationManager instance;
  private Thread mainThread;
  private Time timer;
  private World world;

  private SimulationManager() {
    options = new HashMap<SimulationOption, Integer>();
    //DEFAULT VALUES
    options.put(SimulationOption.TICKS_PER_SECOND, 60);
    options.put(SimulationOption.MAX_SIDE_LENGTH, 100);
  }

  public static void init() {
    instance = new SimulationManager();
  }

  public static void start() {
    instance.world = new World();
    instance.world.init(instance.options.get(SimulationOption.MAX_SIDE_LENGTH),
        Util.getMapData());
    instance.startThread();
  }


  private void startThread() {
    mainThread = new Thread(() -> {
      timer = new Time(options.get(SimulationOption.TICKS_PER_SECOND), delaTime -> {
        world.update();
        System.out.println("Time between frames: " + delaTime + " seconds");
      });
      timer.start();
    });
    mainThread.run();
  }

  public static void setOption(SimulationOption o, int value) {
    instance.options.put(o, value);
  }

  public static World world() {
    return instance.world;
  }
}
