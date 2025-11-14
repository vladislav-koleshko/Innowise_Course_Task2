package com.inkspac3.course.service.impl;

import com.inkspac3.course.component.TextComponent;
import com.inkspac3.course.component.TextComposite;
import com.inkspac3.course.service.LexemeSwapper;

import java.util.List;

public class LexemeSwapperImpl implements LexemeSwapper {
  public void swapFirstAndLastLexemes(TextComponent text) {

    for (TextComponent paragraph : ((TextComposite) text).getComponents()) {

      for (TextComponent sentenceComp : ((TextComposite) paragraph).getComponents()) {
        TextComposite sentence = (TextComposite) sentenceComp;
        List<TextComponent> words = sentence.getComponents();

        if (words.size() < 2) continue;

        TextComponent first = words.get(0);
        TextComponent last = words.get(words.size() - 1);

        words.set(0, last);
        words.set(words.size() - 1, first);
      }
    }
  }
}
