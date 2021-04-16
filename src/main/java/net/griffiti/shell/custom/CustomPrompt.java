package net.griffiti.shell.custom;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.jline.PromptProvider;

import net.griffiti.shell.PromptColor;

/**
 * @author griffiti
 */
public class CustomPrompt implements PromptProvider {

  @Value("${shell.prompt.display:>}")
  public String display;

  @Value("${shell.prompt.color:BLUE}")
  public String color;

  @Override
  public AttributedString getPrompt() {
    AttributedStyle style = AttributedStyle.DEFAULT.foreground(PromptColor.valueOf(color).toJlineAttributedStyle());
    return new AttributedString(display, style);
  }
  
}
