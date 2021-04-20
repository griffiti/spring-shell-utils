package net.griffiti.shell.progress;

import org.jline.terminal.Terminal;

import net.griffiti.shell.ConsoleSequences;

/**
 * Console based implementation of progress counter.
 * Provides two public methods:<br>
 * <ul>
 * <li>1. Display just spinner</li>
 * <li>2. Display spinner in combination with message and numeric counter.</li>
 * </ul>
 *
 * @author Domagoj Madunić
 * @author griffiti - additional updates
 */
public class ProgressCounter {

    private Terminal terminal;

    private String pattern = "%s: %d ";

    private char[] spinner = {'|', '/', '-', '\\'};

    private SpinnerPosition spinnerPosition = SpinnerPosition.LEFT;

    private boolean started = false;
    private int spinCounter = 0;

    public ProgressCounter(Terminal terminal) {
        this(terminal, null);
    }

    public ProgressCounter(Terminal terminal, String pattern) {
        this(terminal, pattern, null, null);
    }

    public ProgressCounter(Terminal terminal, String pattern, char[] spinner) {
        this(terminal, pattern, spinner, null);
    }

    public ProgressCounter(Terminal terminal, String pattern, char[] spinner, SpinnerPosition spinnerPosition) {
        this.terminal = terminal;

        if (pattern != null) {
            this.pattern = pattern;
        }
        if (spinner != null) {
            this.spinner = spinner;
        }
        if (spinnerPosition != null) {
            this.spinnerPosition = spinnerPosition;
        }
    }

    
    /** 
     * @param message Message to display for progress
     */
    public void display(String message) {
        if (!started) {
            terminal.writer().println();
            started = true;
        }
        String progress = String.format(pattern, message);
        String displayOutput = getDisplayOutput(progress);

        terminal.writer().println(ConsoleSequences.CUU + "\r" + ConsoleSequences.DL + displayOutput);
        terminal.flush();
    }

    
    /** 
     * @param count Count to display for progress
     * @param message Message to display for progress
     */
    public void display(int count, String message) {
        if (!started) {
            terminal.writer().println();
            started = true;
        }
        String progress = String.format(pattern, message, count);
        String displayOutput = getDisplayOutput(progress);

        terminal.writer().println(ConsoleSequences.CUU + "\r" + ConsoleSequences.DL + displayOutput);
        terminal.flush();
    }

    public void display() {
        if (!started) {
            terminal.writer().println();
            started = true;
        }
        terminal.writer().println(ConsoleSequences.CUU + "\r" + ConsoleSequences.DL + getSpinnerChar());
        terminal.flush();
    }

    public void reset() {
        spinCounter = 0;
        started = false;

        terminal.writer().println(ConsoleSequences.CUU + "\r" + ConsoleSequences.DL);
        terminal.flush();
    }

    
    /** 
     * @param progress Progress to display
     * @return String
     */
    private String getDisplayOutput(String progress) {
        StringBuilder output = new StringBuilder();
        if (this.spinnerPosition == SpinnerPosition.LEFT) {
            output.append(getSpinnerChar());
            output.append(" ");
        }
        output.append(progress);
        if (this.spinnerPosition == SpinnerPosition.RIGHT) {
            output.append(" ");
            output.append(getSpinnerChar());
        }

        return output.toString();
    }

    
    /** 
     * @return char
     */
    private char getSpinnerChar() {
        char spinChar = spinner[spinCounter];
        spinCounter++;
        if (spinCounter == spinner.length) {
            spinCounter = 0;
        }
        return spinChar;
    }

    
    /** 
     * @return String
     */
    //--- set / get methods ---------------------------------------------------

    public String getPattern() {
        return this.pattern;
    }

    
    /** 
     * @param pattern Patter used for progress message
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    
    /** 
     * @return char[]
     */
    public char[] getSpinner() {
        return this.spinner;
    }

    
    /** 
     * @param spinner Characters used to display animated spinner
     */
    public void setSpinner(char[] spinner) {
        this.spinner = spinner;
    }

    
    /** 
     * @return SpinnerPosition
     */
    public SpinnerPosition getSpinnerPosition() {
        return this.spinnerPosition;
    }

    
    /** 
     * @param spinnerPosition Location of spinner next to message
     */
    public void setSpinnerPosition(SpinnerPosition spinnerPosition) {
        this.spinnerPosition = spinnerPosition;
    }

    
    /** 
     * @return boolean
     */
    public boolean getStarted() {
        return this.started;
    }

    
    /** 
     * @param started Set progress started
     */
    public void setStarted(boolean started) {
        this.started = started;
    }

    
    /** 
     * @return int
     */
    public int getSpinCounter() {
        return this.spinCounter;
    }

    
    /** 
     * @param spinCounter Count used for progress
     */
    public void setSpinCounter(int spinCounter) {
        this.spinCounter = spinCounter;
    }

}
