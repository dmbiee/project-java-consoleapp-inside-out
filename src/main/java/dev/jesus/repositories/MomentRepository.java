package dev.jesus.repositories;

import java.util.List;

import dev.jesus.contracts.InterfaceDatabase;
import dev.jesus.db.MomentDatabase;
import dev.jesus.models.Moment;

public class MomentRepository {

  private InterfaceDatabase db;

  public MomentRepository() {
    this.db = new MomentDatabase();
  }

  public void StoreMoment(Moment moment) {
    db.store(moment);
  }

  public List<Moment> getAllMoments() {
    return db.getAllMoments();
  }

  public void deleteMoment(int id) {
    db.deleteMoment(id - 1);
  }
}
