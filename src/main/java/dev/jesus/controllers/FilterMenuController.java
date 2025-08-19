package dev.jesus.controllers;

import java.util.ArrayList;
import java.util.List;

import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.models.EmotionEnum;
import dev.jesus.models.Moment;
import dev.jesus.repositories.MomentRepository;
import dev.jesus.singletons.MomentRepositorySingleton;

public class FilterMenuController {
  private MomentRepository repository;

  public static void filterMenuController(int option) {

    // if (option == 1)
    // AddMomentView.printAddMoment();

    // if (option == 2)
    // ShowAllMomentsView.printAllMoments();
  }

  public List<MomentResponseDTO> filterByEmotion(EmotionEnum emotion) {
    this.repository = MomentRepositorySingleton.getInstance();

    List<Moment> db = repository.getAllMoments();
    List<MomentResponseDTO> filtredList = new ArrayList<>();

    for (Moment moment : db) {
      if (moment.getEmotion() == emotion) {
        MomentResponseDTO dto = new MomentResponseDTO(
            moment.getTitle(),
            moment.getDate(),
            moment.getDescription(),
            moment.getEmotion());
        filtredList.add(dto);
      }
    }
    return filtredList;
  }
}
