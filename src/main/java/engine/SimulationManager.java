package engine;

import java.util.HashMap;
import java.util.Map;
import engine.util.Time;

public class SimulationManager {
    private Map<SimulationOption, Integer> options;
    static SimulationManager instance;
    private Thread mainThread;
    private World world;
    private Time timer;

    private SimulationManager() {
        options = new HashMap<SimulationOption, Integer>();
        //DEFAULT VALUES
        options.put(SimulationOption.TICKS_PER_SECOND, 60);
        options.put(SimulationOption.MAX_SIDE_LENGTH, 100);

        world = new World();
        Grass grass = new Grass(Entity.builder().x(1).y(1).build());
        world.addEntity(grass.e);
    }

    public static void init() {
        instance = new SimulationManager();
    }

    public static void start() {
        instance.startThread();
    }

    public static void setOption(SimulationOption o, int value) {
        instance.options.put(o, value);
    }

    private void startThread() {
        mainThread = new Thread(() -> {
             timer = new Time(options.get(SimulationOption.TICKS_PER_SECOND), delaTime -> {
                System.out.println("Time between frames: " + delaTime + " seconds");
            });
            timer.start();
        });
        mainThread.run();
    }
}
