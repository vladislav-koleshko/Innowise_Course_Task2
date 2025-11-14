package com.inkspac3.course.service.impl;

import com.inkspac3.course.service.MaxCommonWordsService;

import com.inkspac3.course.component.*;

import java.util.*;

public class MaxCommonWordsImpl implements MaxCommonWordsService {

  public int findMaxSentenceCountWithSameWords(TextComponent text) {
    if (!(text instanceof TextComposite)) return 0;

    Map<String, Set<Integer>> wordToSentences = new HashMap<>();
    int sentenceIndex = 0;

    for (TextComponent paragraph : ((TextComposite) text).getComponents()) {
      for (TextComponent sentence : ((TextComposite) paragraph).getComponents()) {

        Set<String> wordsInSentence = extractWords(sentence);

        for (String word : wordsInSentence) {
          wordToSentences
                  .computeIfAbsent(word.toLowerCase(), k -> new HashSet<>())
                  .add(sentenceIndex);
        }

        sentenceIndex++;
      }
    }

    return wordToSentences.values()
            .stream()
            .mapToInt(Set::size)
            .max()
            .orElse(0);
  }

  private Set<String> extractWords(TextComponent sentence) {
    Set<String> words = new HashSet<>();

    for (TextComponent wordComp : ((TextComposite) sentence).getComponents()) {
      words.add(wordComp.toString());
    }
    return words;
  }
}
