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

  public void StoreMoment(MomentResponseDTO momentDTO) {
    Moment momentToSave = DtoToMomentMapper.toEntity(momentDTO);
    repository.StoreMoment(momentToSave);
  }

  public List<MomentRequestDTO> GetDB() {
    List<Moment> moments = repository.getAllMoments();
    List<MomentRequestDTO> momentDTOs = new ArrayList<>();

    for (Moment moment : moments) {
      MomentRequestDTO dto = new MomentRequestDTO(
          moment.getTitle(),
          moment.getDate(),
          moment.getDescription(),
          moment.getEmotion());
      momentDTOs.add(dto);
    }

    return momentDTOs;
  }

}
