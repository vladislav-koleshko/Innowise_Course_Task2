package com.inkspac3.course.parser;

import com.inkspac3.course.component.TextComponent;
import com.inkspac3.course.component.TextComponentType;
import com.inkspac3.course.component.TextComposite;
import com.inkspac3.course.component.TextLeaf;

public class SymbolParser extends TextParser {

  @Override
  public TextComponent parse(String word) {
    TextComposite wordComposite = new TextComposite(TextComponentType.SYMBOL);

    for (char c : word.toCharArray()) {
      wordComposite.add(new TextLeaf(c, TextComponentType.SYMBOL));
    }

    return wordComposite;
  }
}
