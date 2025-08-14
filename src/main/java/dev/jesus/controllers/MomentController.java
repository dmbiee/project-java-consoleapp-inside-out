package dev.jesus.controllers;

import java.util.ArrayList;
import java.util.List;

import dev.jesus.dtos.MomentDTO;
import dev.jesus.mappers.MomentMapper;
import dev.jesus.models.Moment;
import dev.jesus.repositories.MomentRepository;
import dev.jesus.singletons.MomentRepositorySingleton;

public class MomentController {

  private MomentRepository repository;

  public MomentController() {
    this.repository = MomentRepositorySingleton.getInstance();
  }

  public void StoreMoment(MomentDTO momentDTO) {
    Moment momentToSave = MomentMapper.toEntity(momentDTO);
    repository.StoreMoment(momentToSave);
  }

  public List<MomentDTO> GetDB() {
    List<Moment> moments = repository.getAllMoments();
    List<MomentDTO> momentDTOs = new ArrayList<>();

    for (Moment moment : moments) {
      MomentDTO dto = new MomentDTO(
          moment.getTitle(),
          moment.getDate(),
          moment.getDescription(),
          moment.getEmotion());
      momentDTOs.add(dto);
    }

    return momentDTOs;
  }

  public void deleteMoment(int id) {
    repository.deleteMoment(id);

  }

}
