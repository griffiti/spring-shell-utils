package net.griffiti.shell.custom;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import net.griffiti.shell.ConsoleSequences;

/**
 * @author griffiti
 */
public class CustomBanner implements Banner {

  @Override
  public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
    out.print(ConsoleSequences.CLS);

    try {
      String fileName = "/splash.txt";
      InputStream stream = getClass().getResourceAsStream(fileName);
      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

      String currentLine;
      while ((currentLine = reader.readLine()) != null) {
        System.out.println(currentLine);
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
}
