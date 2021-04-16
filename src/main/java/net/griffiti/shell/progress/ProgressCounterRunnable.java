package net.griffiti.shell.progress;

/**
 * @author griffiti
 */
public class ProgressCounterRunnable implements Runnable {

  private ProgressCounter progressCounter;
  private String message;
  private boolean isStarted = true;

  public ProgressCounterRunnable(ProgressCounter progressCounter, String message) {
    this.progressCounter = progressCounter;
    this.message = message;
  }

  @Override
  public void run() {
    while(isStarted) {
      try {
        this.progressCounter.display(this.message);
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void cancel() {
    this.isStarted = false;
    this.progressCounter.reset();
  }

}
