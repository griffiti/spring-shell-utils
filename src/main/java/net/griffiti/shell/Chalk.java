package net.griffiti.shell;

import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

/**
 * This class emulates blackboard chalk. Its methods return spring whose attributes are modified so
 * it will be displayed in terminal in specific ansi color.
 *
 * @author Domagoj Madunić
 */
public class Chalk {
    
    /** 
     * Returns supplied message String in ANSI black color.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String black(String message) {
        return color(message, PromptColor.BLACK, false);
    }
    
    /**
     * Returns supplied message String in bold style and ANSI black color.
     * 
     * @param message Message to apply color
     * @param bold Make message bold
     * @return String
     */
    public static String black(String message, boolean bold) {
        return color(message, PromptColor.BLACK, bold);
    }

    
    /** 
     * Returns supplied message String in ANSI red color.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String red(String message) {
        return color(message, PromptColor.RED, false);
    }

    
    /** 
     * Returns supplied message String in bold style and ANSI red color.
     * 
     * @param message Message to apply color
     * @param bold Make message bold
     * @return String
     */
    public static String red(String message, boolean bold) {
        return color(message, PromptColor.RED, bold);
    }

    
    /** 
     * Returns supplied message String in ANSI green color.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String green(String message) {
        return color(message, PromptColor.GREEN, false);
    }

    
    /** 
     * Returns supplied message String in bold style and in ANSI green color.
     * 
     * @param message Message to apply color
     * @param bold Make message bold
     * @return String
     */
    public static String green(String message, boolean bold) {
        return color(message, PromptColor.GREEN, bold);
    }

    
    /** 
     * Returns supplied message String in ANSI yellow color.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String yellow(String message) {
        return color(message, PromptColor.YELLOW, false);
    }

    
    /** 
     * Returns supplied message String in bold style and in ANSI yellow color.
     * 
     * @param message Message to apply color
     * @param bold Make message bold
     * @return String
     */
    public static String yellow(String message, boolean bold) {
        return color(message, PromptColor.YELLOW, bold);
    }

    
    /** 
     * Returns supplied message String in ANSI blue color.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String blue(String message) {
        return color(message, PromptColor.BLUE, false);
    }

    
    /** 
     * Returns supplied message String in bold style and in ANSI blue color.
     * 
     * @param message Message to apply color
     * @param bold Make message bold
     * @return String
     */
    public static String blue(String message, boolean bold) {
        return color(message, PromptColor.BLUE, bold);
    }

    
    /** 
     * Returns supplied message String in ANSI magenta color.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String magenta(String message) {
        return color(message, PromptColor.MAGENTA, false);
    }

    
    /** 
     * Returns supplied message String in bold style and in ANSI magenta color.
     * 
     * @param message Message to apply color
     * @param bold Make message bold
     * @return String
     */
    public static String magenta(String message, boolean bold) {
        return color(message, PromptColor.MAGENTA, bold);
    }

    
    /** 
     * Returns supplied message String in ANSI cyan color.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String cyan(String message) {
        return color(message, PromptColor.CYAN, false);
    }

    
    /** 
     * Returns supplied message String in bold style and in ANSI cyan color.
     * 
     * @param message Message to apply color
     * @param bold Make message bold
     * @return String
     */
    public static String cyan(String message, boolean bold) {
        return color(message, PromptColor.CYAN, bold);
    }

    
    /** 
     * Returns supplied message String in ANSI white color.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String white(String message) {
        return color(message, PromptColor.WHITE, false);
    }

    
    /** 
     * Returns supplied message String in bold style and in ANSI white color.
     * 
     * @param message Message to apply color
     * @param bold Make message bold
     * @return String
     */
    public static String white(String message, boolean bold) {
        return color(message, PromptColor.WHITE, bold);
    }

    
    /** 
     * Returns supplied message String as bright.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String bright(String message) {
        return color(message, PromptColor.BRIGHT, false);
    }

    
    /** 
     * Returns supplied message String in bold style and as bright.
     * 
     * @param message Message to apply color
     * @param bold Make message bold
     * @return String
     */
    public static String bright(String message, boolean bold) {
        return color(message, PromptColor.BRIGHT, bold);
    }


    
    /** 
     * Returns supplied message String in bold style.
     * 
     * @param message Message to apply color
     * @return String
     */
    public static String bold(String message) {
        return new AttributedStringBuilder().append(message, AttributedStyle.BOLD).toAnsi();
    }

    
    /** 
     * @param message Message to apply color
     * @param colorName  name of the ANSI color to print in
     * @return String
     */
    public static String color(String message, String colorName) {
        return color(message, colorName, false);
    }

    /**
     * Color message with given color and in bold style.
     *
     * @param message Message to apply color message to return
     * @param colorName  name of the ANSI color to print in
     * @param bold Make message bold  should the String be in bold style or not
     * @return colored message
     */
    public static String color(String message, String colorName, boolean bold) {
        PromptColor color = PromptColor.valueOf(colorName);
        if (color == null) {
            throw new UnsupportedOperationException("Unknown color supplied: " + colorName);
        }
        return color(message, color, bold);
    }

    /**
     * Color message with given color .
     *
     * @param message Message to apply color message to return
     * @param color   color to print
     * @return colored message
     */
    public static String color(String message, PromptColor color) {
        return color(message, color, false);
    }


    /**
     * Color message with given color and in a given weight (bold)
     *
     * @param message Message to apply color message to return
     * @param color   color to print
     * @param bold Make message bold  should the String be in bold style or not
     * @return colored message
     */
    public static String color(String message, PromptColor color, boolean bold) {
        if (bold) {
            return new AttributedStringBuilder().append(
                    message,
                    AttributedStyle.BOLD.foreground(color.toJlineAttributedStyle())
            ).toAnsi();
        }
        return new AttributedStringBuilder().append(
                message,
                AttributedStyle.DEFAULT.foreground(color.toJlineAttributedStyle())
        ).toAnsi();
    }

}
