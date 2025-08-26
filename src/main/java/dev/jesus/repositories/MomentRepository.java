package dev.jesus.repositories;

import java.util.List;

import dev.jesus.db.MomentDatabase;
import dev.jesus.models.Moment;

public class MomentRepository {

  private MomentDatabase db;

  public MomentRepository() {
    this.db = new MomentDatabase();
  }

  public void StoreMoment(Moment moment) {
    db.store(moment);
  }

  public List<Moment> getAllMoments() {
    return db.getAllItems();
  }

  public void deleteMoment(String id) {
    db.deleteItemByID(id);
  }

  public <T> List<Moment> filterBy(T filterCriteria) {
    return db.filterBy(filterCriteria);
  }
}
