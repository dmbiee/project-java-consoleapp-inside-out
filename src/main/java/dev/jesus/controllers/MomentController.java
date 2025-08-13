package dev.jesus.controllers;

import dev.jesus.dtos.MomentDTO;
import dev.jesus.mappers.MomentMapper;
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

}
