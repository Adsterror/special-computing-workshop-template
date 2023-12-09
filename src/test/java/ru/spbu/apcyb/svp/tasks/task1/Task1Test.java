package ru.spbu.apcyb.svp.tasks.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class Task1Test {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final InputStream originalIn = System.in;

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setIn(originalIn);
  }

  @ParameterizedTest
  @ValueSource(strings = {"-4\n1\n1", "3\n-3", "4\n2\n1\n-1\n", "4\n3\n2\n0\n"})
  void testInvalidDigit(String arg) {
    ByteArrayInputStream inContent = new ByteArrayInputStream(arg.getBytes());
    System.setIn(inContent);

    Task1.main(null);

    String output = outContent.toString();
    assertTrue(output.contains("Invalid input. Enter a positive integer:"));
  }

  @Test
  void testOk() {
    String input = "10\n3\n1\n2\n5\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Task1.main(null);
    assertTrue(outContent.toString().contains("5"));
  }

  @ParameterizedTest
  @ValueSource(strings = {"10\n2\n1\nh\n", "qwe", "10\nrty"})
  void testInvalidCharacter(String arg) {
    ByteArrayInputStream inContent = new ByteArrayInputStream(arg.getBytes());
    System.setIn(inContent);

    Task1.main(null);

    assertTrue(outContent.toString().contains("Input contains invalid characters."));
  }


  @Test
  void testGetChangeByDenominationsOneDenomination() {
    long[] denominations = {1};
    long result = Task1.getChangeByDenominations(3, denominations);
    assertEquals(1, result);
  }

  @Test
  void testGetChangeByDenominationsMultipleDenominations() {
    long[] denominations = {1, 2, 5};
    long result = Task1.getChangeByDenominations(5, denominations);
    assertEquals(4, result);
  }

  @Test
  void testGetChangeByDenominationsNoPossibleCombinations() {
    long[] denominations = {5, 10};
    long result = Task1.getChangeByDenominations(3, denominations);
    assertEquals(0, result);
  }

  @Test
  void testGetChangeByDenominationsZeroChange() {
    long[] denominations = {5, 10};
    long result = Task1.getChangeByDenominations(0, denominations);
    assertEquals(1, result);
  }
}
