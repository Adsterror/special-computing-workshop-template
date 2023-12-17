package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * Task 3.
 */
class Task3Test {

  @Test
  void testNotExistingDirectoryInput() throws IOException {
    String[] args = new String[2];
    args[0] = "con";
    args[1] = "answer.txt";
    FileWriter writer = new FileWriter(args[1], false);
    FileNotFoundException thrown = assertThrows(FileNotFoundException.class, () -> Task3
        .walk(args[0], writer, 0));
    assertEquals("java.io.FileNotFoundException", thrown.toString());
  }

  @Test
  void testNormalInput() throws IOException {
    String[] args = new String[2];
    args[0] = "src/test/resources/Task3/Task3TestDirectory";
    args[1] = "src/test/resources/Task3/answer.txt";
    FileWriter writer = new FileWriter(args[1], false);
    boolean isEmpty = true;
    try {
      Task3.walk(args[0], writer, 0);
    } catch (IOException thrown) {
      isEmpty = false;
    }
    assertTrue(isEmpty);
  }


}