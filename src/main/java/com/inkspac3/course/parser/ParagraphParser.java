package com.inkspac3.course.parser;

import com.inkspac3.course.component.TextComponent;
import com.inkspac3.course.component.TextComposite;
import com.inkspac3.course.component.TextComponentType;

public class ParagraphParser extends TextParser {
  private static final String PARAGRAPH_DELIM = "(\\r?\\n\\s*){2,}";

  @Override
  public TextComponent parse(String text) {
    TextComposite textComposite = new TextComposite(TextComponentType.PARAGRAPH);

    String[] paragraphs = text.split(PARAGRAPH_DELIM);
    for (String paragraph : paragraphs) {
      if (nextParser != null) {
        TextComponent paragraphComponent = nextParser.parse(paragraph.strip());
        textComposite.add(paragraphComponent);
      }
    }
    return textComposite;
  }
}

