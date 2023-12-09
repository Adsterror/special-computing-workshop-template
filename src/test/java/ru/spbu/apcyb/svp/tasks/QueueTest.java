package ru.spbu.apcyb.svp.tasks;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTest {


  @Test
  void addObjectTest() {
    MyQueue<String> queue = new MyQueue<>();
    queue.add("string");
    Assertions.assertEquals("string", queue.peek());
  }

  @Test
  void sizeEmptyTest() {
    MyQueue<Object> queue = new MyQueue<>();
    Assertions.assertEquals(0, queue.size());
  }

  @Test
  void sizeSeveralTest() {
    MyQueue<Integer> queue = new MyQueue<>();
    queue.add(5);
    queue.remove();
    Assertions.assertEquals(0, queue.size());
  }

  @Test
  void pollTest() {
    MyQueue<String> queue = new MyQueue<>();
    queue.add("string");
    queue.add("notstring");
    Object element = queue.poll();
    Assertions.assertAll(
        () -> Assertions.assertEquals("string", element),
        () -> Assertions.assertArrayEquals(new Object[]{"notstring"}, queue.toArray())
    );
  }

  @Test
  void pollNullTest() {
    MyQueue<String> queue = new MyQueue<>();
    Assertions.assertNull(queue.poll());
  }

  @Test
  void elementTest() {
    MyQueue<String> queue = new MyQueue<>();
    queue.add("A");
    queue.add("B");
    queue.add("C");
    Object element = queue.element();
    Assertions.assertAll(
        () -> Assertions.assertEquals("A", element),
        () -> Assertions.assertArrayEquals(new Object[]{"A", "B", "C"}, queue.toArray())
    );
  }

  @Test
  void elementExceptionTest() {
    MyQueue<String> queue = new MyQueue<>();
    Assertions.assertThrows(NoSuchElementException.class, queue::element);
  }

  @Test
  void removeTest() {
    MyQueue<String> queue = new MyQueue<>();
    queue.add("A");
    queue.add("B");
    Object element = queue.remove();
    Assertions.assertAll(
        () -> Assertions.assertEquals("A", element),
        () -> Assertions.assertArrayEquals(new Object[]{"B"}, queue.toArray())
    );
  }

  @Test
  void removeExceptionTest() {
    MyQueue<String> queue = new MyQueue<>();
    Assertions.assertThrows(NoSuchElementException.class, queue::remove);
  }

  @Test
  void peekTest() {
    MyQueue<String> queue = new MyQueue<>();
    queue.add("A");
    queue.add("B");
    Object element = queue.peek();
    Assertions.assertAll(
        () -> Assertions.assertEquals("A", element),
        () -> Assertions.assertArrayEquals(new Object[]{"A", "B"}, queue.toArray())
    );
  }

  @Test
  void peekNullTest() {
    MyQueue<String> queue = new MyQueue<>();
    Assertions.assertNull(queue.peek());
  }

  @Test
  void isEmptyTest() {
    MyQueue<String> queue = new MyQueue<>();
    assertTrue(queue.isEmpty());
  }

  @Test
  void isEmptyFalseTest() {
    MyQueue<String> queue = new MyQueue<>();
    queue.add("A");
    assertFalse(queue.isEmpty());
  }

  @Test
  void clearTest() {
    MyQueue<String> queue = new MyQueue<>();
    Assertions.assertThrows(UnsupportedOperationException.class, queue::clear);
  }

  @Test
  void offerTest() {
    MyQueue<String> queue = new MyQueue<>();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> queue.offer("A"));
  }

  @Test
  void iteratorTest() {
    MyQueue<String> queue = new MyQueue<>();
    Assertions.assertThrows(UnsupportedOperationException.class, queue::iterator);
  }

  @Test
  void containsTest() {
    MyQueue<String> queue = new MyQueue<>();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> queue.contains("A"));
  }
}