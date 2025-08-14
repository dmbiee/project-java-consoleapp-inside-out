package dev.jesus.mappers;

import dev.jesus.dtos.MomentDTO;
import dev.jesus.models.Moment;

public class MomentMapper {

  public static Moment toEntity(MomentDTO dto) {
    Moment moment = new Moment(dto.title(), dto.date(), dto.description(), dto.emotion());

    return moment;
  }

}
