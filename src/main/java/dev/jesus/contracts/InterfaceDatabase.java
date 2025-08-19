package dev.jesus.contracts;

import java.util.List;

import dev.jesus.models.Moment;

public interface InterfaceDatabase {
  public void store(Moment moment);

  List<Moment> getAllMoments();

  public void deleteMoment(int id);

  <T> List<Moment> filterBy(T filterCriteria);
}
