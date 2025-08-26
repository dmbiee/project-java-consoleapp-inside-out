package dev.jesus.db;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.jesus.contracts.InterfaceDatabase;
import dev.jesus.models.EmotionEnum;
import dev.jesus.models.Moment;

public class MomentDatabase implements InterfaceDatabase<Moment> {

  private List<Moment> moments;

  public MomentDatabase() {
    this.moments = new ArrayList<>();
  }

  @Override
  public void store(Moment moment) {
    moment.setRecordDate(LocalDateTime.now());
    moments.add(moment);
  }

  @Override
  public List<Moment> getAllItems() {
    return moments;
  }

  @Override
  public void deleteItemByID(String id) {
    moments.removeIf(moment -> moment.getId().equals(id));
  }

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
