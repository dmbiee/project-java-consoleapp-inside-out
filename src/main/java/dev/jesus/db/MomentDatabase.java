package dev.jesus.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.jesus.contracts.InterfaceDatabase;
import dev.jesus.models.Moment;

public class MomentDatabase implements InterfaceDatabase {

  private List<Moment> moments;

  public MomentDatabase() {
    this.moments = new ArrayList<>();
  }

  @Override
  public void store(Moment moment) {
    moments.add(moment);
  }

  @Override
  public List<Moment> getAllMoments() {
    return moments;
  }

  @Override
  public void deleteMoment(int id) {
    moments.remove(id);
  }

  @Override
  public <T> List<Moment> filterBy(T filterCriteria) {
    List<Moment> filteredList = new ArrayList<>();

    if (filterCriteria instanceof LocalDate) {

    }

    return filteredList;
  }

}
