package dev.jesus.repositories;

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
}
