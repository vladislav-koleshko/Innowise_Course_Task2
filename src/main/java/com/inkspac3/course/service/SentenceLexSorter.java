package com.inkspac3.course.service;

import com.inkspac3.course.component.TextComponent;

import java.util.List;

public interface SentenceLexSorter {
  List<String> sortSentencesByLexemeCount(TextComponent text);
}
