package dev.jesus.db;

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

}
