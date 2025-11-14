package com.inkspac3.course.service;

import com.inkspac3.course.component.*;
import com.inkspac3.course.parser.*;
import com.inkspac3.course.service.impl.LexemeSwapperImpl;
import com.inkspac3.course.service.impl.MaxCommonWordsImpl;
import com.inkspac3.course.service.impl.SentenceLexSorterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

  private ParagraphParser parser;
  private MaxCommonWordsService duplicateService;
  private SentenceLexSorterImpl sortService;
  private LexemeSwapper swapService;

  @BeforeEach
  public void setup() {
    duplicateService = new MaxCommonWordsImpl();
    sortService = new SentenceLexSorterImpl();
    swapService = new LexemeSwapperImpl();

    parser = new ParagraphParser();
    SentenceParser sentenceParser = new SentenceParser();
    WordParser wordParser = new WordParser();
    SymbolParser symbolParser = new SymbolParser();

    parser.setNextParser(sentenceParser);
    sentenceParser.setNextParser(wordParser);
    wordParser.setNextParser(symbolParser);
  }

  @Test
  public void testDuplicateWordService() {
    String text = """
                Apple is good. I like apple a lot. 
                Banana is yellow. Apple pie is tasty.
                """;

    TextComponent root = parser.parse(text);

    int result = duplicateService.findMaxSentenceCountWithSameWords(root);

    assertEquals(3, result,
            "Слово 'apple' встречается в 3 предложениях");
  }

  @Test
  public void testSortByLexemeCount() {
    String text = """
                I like apples.
                This is a longer sentence example.
                Hi.
                """;

    TextComponent root = parser.parse(text);
    List<String> sorted = sortService.sortSentencesByLexemeCount(root);

    assertEquals("Hi.", sorted.get(0));
    assertEquals("I like apples.", sorted.get(1));
    assertEquals("This is a longer sentence example.", sorted.get(2));
  }

  @Test
  public void testSwapFirstAndLastLexemes() {
    String text = """
                Hello world again.
                This test works.
                """;

    TextComponent root = parser.parse(text);

    swapService.swapFirstAndLastLexemes(root);

    List<TextComponent> paragraphs = ((TextComposite) root).getComponents();
    TextComposite firstParagraph = (TextComposite) paragraphs.get(0);

    TextComposite sentence1 = (TextComposite) firstParagraph.getComponents().get(0);
    TextComposite sentence2 = (TextComposite) firstParagraph.getComponents().get(1);

    List<TextComponent> words1 = sentence1.getComponents();
    assertEquals("again", words1.get(0).toString());
    assertEquals("Hello", words1.get(words1.size() - 1).toString());

    List<TextComponent> words2 = sentence2.getComponents();
    assertEquals("works", words2.get(0).toString());
    assertEquals("This", words2.get(words2.size() - 1).toString());
  }
}
