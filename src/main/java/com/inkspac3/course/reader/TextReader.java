package com.inkspac3.course.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextReader {
  private static final Logger log = LogManager.getLogger();

  public TextReader() {}

  public String readTextFile(String fileName) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(fileName));

    log.info("File: " + fileName + ", Lines read: " + lines.size());
    return String.join(System.lineSeparator(), lines);
  }
}
