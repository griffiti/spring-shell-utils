package net.griffiti.shell;

import org.jline.terminal.Terminal;
import org.springframework.beans.factory.annotation.Value;

/**
 * ShellHelper class encapsulates many util print methods.
 *
 * @author domagoj on 01.08.2018
 * 
 * @author griffiti - additional updates
 */
public class ShellHelper {

    @Value("${shell.out.info:CYAN}")
    public String infoColor;

    @Value("${shell.out.success:GREEN}")
    public String successColor;

    @Value("${shell.out.warning:YELLOW}")
    public String warningColor;

    @Value("${shell.out.error:RED}")
    public String errorColor;

    @Value("${shell.clearOnStart:true}")
    public boolean clearOnStart;

    private Terminal terminal;

    public ShellHelper(Terminal terminal) {
        this.terminal = terminal;

        if (this.clearOnStart) {
            this.clearScreen();
            Runnable clearTask = () -> {
                try {
                    Thread.sleep(250);
                    this.clearScreen();
                } catch (Exception e) {}
            };
            clearTask.run();
        }
    }

    /**
     * Print message to the console in the default color.
     *
     * @param message message to print
     */
    public void println(String message) {
        println(message, null);
    }

    /**
     * Print message to the console in the success color.
     *
     * @param message message to print
     */
    public void printlnSuccess(String message) {
        println(message, PromptColor.valueOf(successColor));
    }

    /**
     * Print message to the console in the info color.
     *
     * @param message message to print
     */
    public void printlnInfo(String message) {
        println(message, PromptColor.valueOf(infoColor));
    }

    /**
     * Print message to the console in the warning color.
     *
     * @param message message to print
     */
    public void printlnWarning(String message) {
        println(message, PromptColor.valueOf(warningColor));
    }

    /**
     * Print message to the console in the error color.
     *
     * @param message message to print
     */
    public void printlnError(String message) {
        println(message, PromptColor.valueOf(errorColor));
    }



    /**
     * Print message to the console in the default color.
     *
     * @param message message to print
     */
    public void print(String message) {
        print(message, null);
    }

    /**
     * Print message to the console in the success color.
     *
     * @param message message to print
     */
    public void printSuccess(String message) {
        println(message, PromptColor.valueOf(successColor));
    }

    /**
     * Print message to the console in the info color.
     *
     * @param message message to print
     */
    public void printInfo(String message) {
        print(message, PromptColor.valueOf(infoColor));
    }

    /**
     * Print message to the console in the warning color.
     *
     * @param message message to print
     */
    public void printWarning(String message) {
        print(message, PromptColor.valueOf(warningColor));
    }

    /**
     * Print message to the console in the error color.
     *
     * @param message message to print
     */
    public void printError(String message) {
        print(message, PromptColor.valueOf(errorColor));
    }

    /**
     * Generic Print to the console method.
     *
     * @param message message to print
     * @param color   (optional) prompt color
     */
    public void print(String message, PromptColor color) {
        String toPrint = message;
        if (color != null) {
            toPrint = Chalk.color(message, color);
        }
        terminal.writer().print(toPrint);
        terminal.flush();
    }

    /**
     * Generic Println to the console method.
     *
     * @param message message to print
     * @param color   (optional) prompt color
     */
    public void println(String message, PromptColor color) {
        String toPrint = message;
        if (color != null) {
            toPrint = Chalk.color(message, color);
        }
        terminal.writer().println(toPrint);
        terminal.flush();
    }

    public void deleteCurrentLine() {
        terminal.writer().println("\r" + ConsoleSequences.DL);
    }

    public void deleteLines(int numLines) {
        terminal.writer().println("\r" + String.format(ConsoleSequences.DL_N, numLines));
    }

    public void clearScreen() {
        terminal.writer().println(ConsoleSequences.CLS);
    }
}
