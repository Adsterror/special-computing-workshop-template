package ru.spbu.apcyb.svp.tasks.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Task 1. ATM
 */

public class Task1 {

  /**
   * Entry point.
   */
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter the amount of change: ");
      long change = parseLong(scanner);

      System.out.println("Input number of denominations: ");
      int numDenominations = parseInt(scanner);
      System.out.println("Input denominations: ");
      long[] denominations = parseDenominations(scanner, numDenominations);

      long numCombs = getChangeByDenominations(change, denominations);
      System.out.println(numCombs);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  private static long parseLong(Scanner scanner) {
    while (true) {
      String input = scanner.nextLine().trim();
      try {
        long number = Long.parseLong(input);
        if (number <= 0) {
          System.out.println("Invalid input. Enter a positive integer: ");
          continue;
        }
        return number;
      } catch (NumberFormatException e) {
        if (input.matches(".*\\D+.*")) {
          System.out.println(
                  "Input contains invalid characters. Enter a positive integer: ");
        }
      }
    }
  }

  private static int parseInt(Scanner scanner) {
    while (true) {
      String input = scanner.nextLine().trim();
      try {
        int number = Integer.parseInt(input);
        if (number <= 0) {
          System.out.println("Invalid input. Enter a positive integer: ");
          continue;
        }
        return number;
      } catch (NumberFormatException e) {
        if (input.matches(".*\\D+.*")) {
          System.out.println(
                  "Input contains invalid characters. Enter a positive integer: ");
        }
      }
    }
  }

  private static long[] parseDenominations(Scanner scanner, int numDenominations) {
    long[] denominations = new long[numDenominations];
    for (int i = 0; i < numDenominations; i++) {
      System.out.print("Enter denomination " + (i + 1) + ": ");
      denominations[i] = parseLong(scanner);
    }
    return denominations;
  }

  /** Method that gets all combinations of change with given denominations.
   *
   * @param change amount of change
   * @param denominations parsed denominations
   * @return number of combinations
   */
  public static long getChangeByDenominations(long change, long[] denominations) {
    long[] counters = new long[denominations.length];
    long combs = 0;

    while (true) {
      long sum = calculateSum(denominations, counters);

      if (sum == change) {
        combs++;
        printCurrentCombination(denominations, counters);
      }

      boolean shouldContinue = incrementCounters(change, denominations, counters);
      if (!shouldContinue) {
        break;
      }
    }
    return combs;
  }


  private static long calculateSum(long[] denominations, long[] counters) {
    long sum = 0;
    for (int i = 0; i < denominations.length; ++i) {
      sum += counters[i] * denominations[i];
    }
    return sum;
  }


  private static void printCurrentCombination(long[] denominations, long[] counters) {
    List<Long> currentCombination = new ArrayList<>();
    for (int i = 0; i < denominations.length; i++) {
      for (int j = 0; j < counters[i]; j++) {
        currentCombination.add(denominations[i]);
      }
    }
    System.out.println(currentCombination);
  }


  private static boolean incrementCounters(long change, long[] denominations, long[] counters) {
    long sum = calculateSum(denominations, counters);
    int indexToIncrement = 0;
    while (indexToIncrement < denominations.length) {
      counters[indexToIncrement]++;
      sum += denominations[indexToIncrement];
      if (sum <= change) {
        return true;
      }
      sum -= counters[indexToIncrement] * denominations[indexToIncrement];
      counters[indexToIncrement] = 0;
      indexToIncrement++;
    }
    return false;
  }
}


