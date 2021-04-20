package net.griffiti.shell.progress;

import org.jline.terminal.Terminal;
import org.springframework.beans.factory.annotation.Value;

import net.griffiti.shell.Chalk;
import net.griffiti.shell.ConsoleSequences;

public class ProgressBar {

    @Value("${shell.out.success:GREEN}")
    private String successColor;

    private String doneMarker = "=";
    private String remainsMarker = "-";
    private String leftDelimiter = "<";
    private String rightDelimiter = ">";

    Terminal terminal;

    private boolean started = false;

    public ProgressBar(Terminal terminal) {
        this.terminal = terminal;
    }

    
    /** 
     * @param percentage Percentage of progress
     */
    public void display(int percentage) {
        display(percentage, null);
    }

    
    /** 
     * @param percentage Percentage of progress
     * @param statusMessage Status message to display with progress
     */
    public void display(int percentage, String statusMessage) {
        if (!started) {
            started = true;
            terminal.writer().println();
        }
        int x = (percentage/5);
        int y = 20-x;
        String message = ((statusMessage == null) ? "" : statusMessage);

        String done = Chalk.color(new String(new char[x]).replace("\0", doneMarker), successColor);
        String remains = new String(new char[y]).replace("\0", remainsMarker);

        String progressBar = String.format("%s%s%s%s %d", leftDelimiter, done, remains, rightDelimiter, percentage);

        terminal.writer().println(ConsoleSequences.CUU + "\r" + ConsoleSequences.DL + progressBar + "% " + message);
        terminal.flush();
    }

    public void reset() {
        started = false;
    }

    
    /** 
     * @return String
     */
    //--- set / get methods ---------------------------------------------------

    public String getDoneMarker() {
        return doneMarker;
    }

    
    /** 
     * @param doneMarker Marker to use when progress completes
     */
    public void setDoneMarker(String doneMarker) {
        this.doneMarker = doneMarker;
    }

    
    /** 
     * @return String
     */
    public String getRemainsMarker() {
        return remainsMarker;
    }

    
    /** 
     * @param remainsMarker Marking when progress remains
     */
    public void setRemainsMarker(String remainsMarker) {
        this.remainsMarker = remainsMarker;
    }

    
    /** 
     * @return String
     */
    public String getLeftDelimiter() {
        return leftDelimiter;
    }

    
    /** 
     * @param leftDelimiter Left delimiter
     */
    public void setLeftDelimiter(String leftDelimiter) {
        this.leftDelimiter = leftDelimiter;
    }

    
    /** 
     * @return String
     */
    public String getRightDelimiter() {
        return rightDelimiter;
    }

    
    /** 
     * @param rightDelimiter Right delimiter
     */
    public void setRightDelimiter(String rightDelimiter) {
        this.rightDelimiter = rightDelimiter;
    }

    
    /** 
     * @return boolean
     */
    public boolean isStarted() {
        return started;
    }

    
    /** 
     * @param started Set progress started
     */
    public void setStarted(boolean started) {
        this.started = started;
    }

}
