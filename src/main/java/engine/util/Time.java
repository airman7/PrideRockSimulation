package engine.util;

public class Time {
  private OnTickListener listener;
  private boolean running;
  private long lastTime;
  private long ticksPerSecond;
  private double deltaTime;

  public Time(long ticksPerSecond, OnTickListener listener) {
    this.listener = listener;
    this.ticksPerSecond = ticksPerSecond;
  }

  public void start() {
    this.running = true;
    this.lastTime = System.nanoTime();
    double singleTickDuration = 1000000000 / ticksPerSecond;
    double pendingTicks = 0;

    while (running) {
      long currentTime = System.nanoTime();
      deltaTime += (currentTime - this.lastTime);
      pendingTicks += (currentTime - this.lastTime) / singleTickDuration;
      this.lastTime = currentTime;

      if (pendingTicks >= 1) {
        pendingTicks--;
        this.listener.onTick(deltaTime/1000000000);
        this.deltaTime = 0;
      }
    }
  }

  public void stop() {
    this.running = false;
  }

  public interface OnTickListener {
    void onTick(double delaTime);
  }
}
