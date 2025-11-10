package com.inkspac3.course.parser;

import com.inkspac3.course.component.TextComponent;
import com.inkspac3.course.component.TextComponentType;
import com.inkspac3.course.component.TextComposite;

public class SentenceParser extends TextParser {
  private static final String SENTENCE_DELIM = "(?<=[.!?])\\s+";

  @Override
  public TextComponent parse(String paragraph) {
    TextComposite paragraphComposite = new TextComposite(TextComponentType.SENTENCE);

    String[] sentences = paragraph.split(SENTENCE_DELIM);
    for (String sentence : sentences) {
      if (nextParser != null) {
        TextComponent sentenceComponent = nextParser.parse(sentence.strip());
        paragraphComposite.add(sentenceComponent);
      }
    }
    return paragraphComposite;
  }
}
