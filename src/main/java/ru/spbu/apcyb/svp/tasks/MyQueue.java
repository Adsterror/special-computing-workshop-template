package ru.spbu.apcyb.svp.tasks;


import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked queue implementation.
 */
public class MyQueue<E> implements java.util.Queue<E> {

  private final MyList<E> list = new MyList<>();

  private static final String NOT_IMPLEMENTED = "method is not implemented yet";

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public boolean add(E e) {
    return list.add(e);
  }

  @Override
  public E remove() {
    if (list.isEmpty()) {
      throw new NoSuchElementException();
    }
    return list.remove(0);
  }

  @Override
  public E poll() {
    if (list.isEmpty()) {
      return null;
    }
    return list.remove(0);
  }

  @Override
  public E element() {
    if (list.isEmpty()) {
      throw new NoSuchElementException();
    }
    return list.get(0);
  }

  @Override
  public E peek() {
    if (list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  @Override
  public boolean contains(Object o) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  @Override
  public Iterator<E> iterator() {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  @Override
  public Object[] toArray() {
    return list.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  @Override
  public boolean remove(Object o) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  @Override
  public void clear() {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }

  @Override
  public boolean offer(E e) {
    throw new UnsupportedOperationException(NOT_IMPLEMENTED);
  }
}
