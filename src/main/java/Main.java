import engine.SimulationManager;
import engine.SimulationOption;

public class Main {
    public static void main(String[] args) {
        SimulationManager.init();
        SimulationManager.setOption(SimulationOption.TICKS_PER_SECOND, 1);
        SimulationManager.setOption(SimulationOption.MAX_SIDE_LENGTH, 7);
        SimulationManager.start();
    }
}
