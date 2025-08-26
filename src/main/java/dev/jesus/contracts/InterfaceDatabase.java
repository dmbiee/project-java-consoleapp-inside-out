package dev.jesus.contracts;

import java.util.List;

public interface InterfaceDatabase<T> {
  public void store(T item);

  List<T> getAllItems();

  public void deleteItemByID(String id);

}
