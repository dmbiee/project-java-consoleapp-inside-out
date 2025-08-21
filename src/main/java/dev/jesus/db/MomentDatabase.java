package dev.jesus.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.jesus.contracts.InterfaceDatabase;
import dev.jesus.models.EmotionEnum;
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
  public void deleteMoment(String id) {
    moments.removeIf(moment -> moment.getId().equals(id));
  }

  @Override
  public <T> List<Moment> filterBy(T filterCriteria) {
    List<Moment> filteredList = new ArrayList<>();

    for (Moment moment : moments) {
      if (filterCriteria instanceof LocalDate dateCriteria) {
        if (moment.getDate().equals(dateCriteria))
          filteredList.add(moment);
      }

      if (filterCriteria instanceof EmotionEnum emotionCriteria) {
        if (moment.getEmotion().equals(emotionCriteria))
          filteredList.add(moment);
      }

      if (filterCriteria instanceof Boolean positiveCriteria) {
        if (moment.isPositive() == positiveCriteria)
          filteredList.add(moment);
      }

    }

    return filteredList;
  }
}
