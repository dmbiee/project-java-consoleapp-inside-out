package dev.jesus.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.mappers.MomentToDtoMapper;
import dev.jesus.models.EmotionEnum;
import dev.jesus.models.Moment;
import dev.jesus.repositories.MomentRepository;
import dev.jesus.singletons.MomentRepositorySingleton;

public class FilterMenuController {
  private MomentRepository repository;

  public FilterMenuController() {
    this.repository = MomentRepositorySingleton.getInstance();
  }

  public static void filterMenuController(int option) {

    // if (option == 1)
    // AddMomentView.printAddMoment();

    // if (option == 2)
    // ShowAllMomentsView.printAllMoments();
  }

  public List<MomentResponseDTO> filterByDate(LocalDate date) {
    List<Moment> filtered = repository.filterBy(date);
    return filtered.stream()
        .map(MomentToDtoMapper::toDto)
        .collect(Collectors.toList());
  }

  public List<MomentResponseDTO> filterByEmotion(EmotionEnum emotion) {
    List<Moment> filtered = repository.filterBy(emotion);
    return filtered.stream()
        .map(MomentToDtoMapper::toDto)
        .collect(Collectors.toList());
  }
}
