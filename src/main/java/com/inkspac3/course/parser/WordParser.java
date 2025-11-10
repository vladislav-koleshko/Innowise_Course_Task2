package com.inkspac3.course.parser;

import com.inkspac3.course.component.TextComponent;
import com.inkspac3.course.component.TextComponentType;
import com.inkspac3.course.component.TextComposite;

public class WordParser extends TextParser {
  public static final String WORD_DELIM = "\\s+";

  @Override
  public TextComponent parse(String sentence) {
    TextComposite sentenceComposite = new TextComposite(TextComponentType.WORD);

    String[] words = sentence.split(WORD_DELIM);
    for (String word : words) {
      if (nextParser != null) {
        TextComponent wordComponent = nextParser.parse(word);
        sentenceComposite.add(wordComponent);
      }
    }
    return sentenceComposite;
  }
}