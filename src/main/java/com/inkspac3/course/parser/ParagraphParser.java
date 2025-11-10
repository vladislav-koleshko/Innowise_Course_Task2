package com.inkspac3.course.parser;

import com.inkspac3.course.component.TextComponent;
import com.inkspac3.course.component.TextComposite;
import com.inkspac3.course.component.TextComponentType;

public class ParagraphParser extends TextParser {

  @Override
  public TextComponent parse(String text) {
    TextComposite textComposite = new TextComposite(TextComponentType.PARAGRAPH);

    String[] paragraphs = text.split("(\\r?\\n\\s*){2,}");
    for (String paragraph : paragraphs) {
      if (nextParser != null) {
        TextComponent paragraphComponent = nextParser.parse(paragraph.strip());
        textComposite.add(paragraphComponent);
      }
    }
    return textComposite;
  }
}

