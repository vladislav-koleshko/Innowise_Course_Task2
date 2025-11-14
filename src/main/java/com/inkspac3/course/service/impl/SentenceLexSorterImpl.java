package com.inkspac3.course.service.impl;

import com.inkspac3.course.component.TextComponent;
import com.inkspac3.course.component.TextComposite;
import com.inkspac3.course.service.SentenceLexSorter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SentenceLexSorterImpl implements SentenceLexSorter {

  public List<String> sortSentencesByLexemeCount(TextComponent text) {
    List<TextComponent> sentences = new ArrayList<>();

    for (TextComponent paragraph : ((TextComposite) text).getComponents()) {
      sentences.addAll(((TextComposite) paragraph).getComponents());
    }

    sentences.sort(Comparator.comparingInt(this::lexemeCount));

    List<String> result = new ArrayList<>();
    for (TextComponent s : sentences) {
      result.add(s.toString());
    }
    return result;
  }

  private int lexemeCount(TextComponent sentence) {
    return ((TextComposite) sentence).getComponents().size();
  }
}
