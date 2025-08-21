package dev.jesus.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.db.MomentCSVStorage;
import dev.jesus.dtos.MomentRequestDTO;
import dev.jesus.mappers.DtoToMomentMapper;
import dev.jesus.mappers.MomentToDtoMapper;
import dev.jesus.models.EmotionEnum;
import dev.jesus.models.Moment;
import dev.jesus.repositories.MomentRepository;
import dev.jesus.singletons.MomentRepositorySingleton;

public class MomentController {

  private MomentRepository repository;
  private MomentCSVStorage csvStorage;

  public MomentController() {
    this.repository = MomentRepositorySingleton.getInstance();
    this.csvStorage = new MomentCSVStorage();
  }

  public void StoreMoment(MomentRequestDTO momentDTO) {
    Moment momentToSave = DtoToMomentMapper.toEntity(momentDTO);
    repository.StoreMoment(momentToSave);
  }

  public List<MomentResponseDTO> GetDB() {
    List<Moment> moments = repository.getAllMoments();
    return MomentToDtoMapper.toDtoList(moments);
  }

  public void deleteMoment(String id) {
    repository.deleteMoment(id);
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

  public List<MomentResponseDTO> filterByIsPositive(boolean isPositive) {
    List<Moment> filtered = repository.filterBy(isPositive);
    return filtered.stream()
        .map(MomentToDtoMapper::toDto)
        .collect(Collectors.toList());
  }

  public void exportMomentsToCSV(String filePath) {
    List<Moment> moments = repository.getAllMoments();
    csvStorage.exportMomentsToCsv(moments, filePath);
  }

}
