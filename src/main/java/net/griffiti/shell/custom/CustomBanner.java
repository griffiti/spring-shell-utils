package net.griffiti.shell.custom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import net.griffiti.shell.ConsoleSequences;

/**
 * @author griffiti
 */
public class CustomBanner implements Banner {

  
  /** 
   * @param environment Spring environment
   * @param sourceClass Source class reference
   * @param out Stream to send out
   */
  @Override
  public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
    out.print(ConsoleSequences.CLS);

    try {
      String fileName = "/splash.txt";
      InputStream stream = getClass().getResourceAsStream(fileName);
      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

      String currentLine;
      while ((currentLine = reader.readLine()) != null) {
        out.println(currentLine);
      }

    } catch (Exception e) {
      out.println(e.getMessage());
    }
  }
  
}
