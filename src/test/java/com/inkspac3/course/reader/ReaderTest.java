package com.inkspac3.course.reader;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReaderTest {

  @Test
  void testReader() throws IOException {
    Path mockPath = Paths.get("mockfile.txt");
    List<String> mockLines = List.of("Line 1", "Line 2", "Line 3");
    String expected = String.join(System.lineSeparator(), mockLines);

    TextReader reader = new TextReader();
    try(MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
      mockedFiles.when(() -> Files.readAllLines(mockPath)).thenReturn(mockLines);

      String result = reader.readTextFile("mockFile.txt");

      assertEquals(expected, result);
      mockedFiles.verify(() -> Files.readAllLines(mockPath), times(1));
    }
  }

  @Test
  void testIOException() throws IOException {
    Path mockPath = Paths.get("mockfile.txt");

    TextReader reader = new TextReader();
    try (MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
      mockedFiles.when(() -> Files.readAllLines(mockPath)).thenThrow(IOException.class);
      assertThrows(IOException.class, () -> reader.readTextFile("mockFile.txt"));
    }

  }
}
