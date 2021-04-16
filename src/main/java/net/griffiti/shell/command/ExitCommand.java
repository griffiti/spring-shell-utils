package net.griffiti.shell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.commands.*;

/**
 * @author griffiti
 */
@ShellComponent
public class ExitCommand implements Quit.Command {

  @ShellMethod(value = "Exit the shell.", key = {"exit", "quit"})
  public void quit() {
    System.out.println("Please wait while the application exits...");
    System.exit(0);
  }
  
}
