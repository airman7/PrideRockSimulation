package engine;

import java.util.HashMap;
import java.util.Map;

public class SimulationManager implements Runnable {
    private Map<SimulationOption, Integer> options;
    static SimulationManager instance;
    private Thread mainThread;

    private SimulationManager() {
        options = new HashMap<SimulationOption, Integer>();
        //DEFAULT VALUES
        options.put(SimulationOption.TICKS_PER_SECOND, 60);
        options.put(SimulationOption.MAX_SIDE_LENGTH, 100);
    }

    public static void init() {
        if (instance == null) {
            instance = new SimulationManager();
        }
    }

    public static void start() {
        instance.startThread();
    }

    public static void setOption(SimulationOption o, int value) {
        instance.options.put(o, value);
    }

    private void startThread() {
        mainThread = new Thread(this);
        mainThread.run();
    }

    @Override
    public void run() {

    }
}
