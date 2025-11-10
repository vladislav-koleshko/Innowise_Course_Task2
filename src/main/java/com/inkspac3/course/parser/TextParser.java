package com.inkspac3.course.parser;

import com.inkspac3.course.component.TextComponent;

public abstract class TextParser {
  protected TextParser nextParser;

  public void setNextParser(TextParser nextParser) {
    this.nextParser = nextParser;
  }

  public abstract TextComponent parse(String text);
}
