package net.griffiti.shell.progress;

import org.jline.terminal.Terminal;

import net.griffiti.shell.ConsoleSequences;

/**
 * @author griffiti
 */
public class ProgressCounterService {

  private Terminal terminal;
  private ProgressCounter progressCounter;
  private ProgressCounterRunnable progress;

  public ProgressCounterService(Terminal terminal, ProgressCounter progressCounter) {
    this.terminal = terminal;
    this.progressCounter = progressCounter;
  }

  public void startProgress(String message) {
    progress = new ProgressCounterRunnable(progressCounter, message);

    Thread t = new Thread(progress);
    t.start();
  }

  public void stopProgress() {
    progress.cancel();
    terminal.writer().println(ConsoleSequences.CUU + ConsoleSequences.CUU);
    terminal.flush();
  }

}
