package net.griffiti.shell.custom;

import java.io.File;
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
      String fileName = "splash.txt";
      ClassLoader classLoader = CustomBanner.class.getClassLoader();

      File file = new File(classLoader.getResource(fileName).getFile());
      String fileContent = new String(Files.readAllBytes(file.toPath()));
      System.out.println(fileContent);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
}
