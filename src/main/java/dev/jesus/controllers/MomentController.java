package dev.jesus.controllers;

import java.util.ArrayList;
import java.util.List;

import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.dtos.MomentRequestDTO;
import dev.jesus.mappers.DtoToMomentMapper;
import dev.jesus.models.Moment;
import dev.jesus.repositories.MomentRepository;
import dev.jesus.singletons.MomentRepositorySingleton;

public class MomentController {

  private MomentRepository repository;

  public MomentController() {
    this.repository = MomentRepositorySingleton.getInstance();
  }

  public void StoreMoment(MomentRequestDTO momentDTO) {
    Moment momentToSave = DtoToMomentMapper.toEntity(momentDTO);
    repository.StoreMoment(momentToSave);
  }

  public List<MomentResponseDTO> GetDB() {
    List<Moment> moments = repository.getAllMoments();
    List<MomentResponseDTO> momentDTOs = new ArrayList<>();

    for (Moment moment : moments) {
      MomentResponseDTO dto = new MomentResponseDTO(
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
