package com.inkspac3.course.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

  @Test
  void testParser() {
    ParagraphParser paragraphParser = new ParagraphParser();
    SentenceParser sentenceParser = new SentenceParser();
    WordParser wordParser = new WordParser();
    SymbolParser symbolParser = new SymbolParser();

    assertAll("Test Parsers",
            () -> assertEquals("", paragraphParser),
            () -> assertEquals("", sentenceParser),
            () -> assertEquals("", wordParser),
            () -> assertEquals("", symbolParser)
    );
  }
}
