package dev.jesus.mappers;

import java.time.format.DateTimeFormatter;

import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.models.Moment;

public class MomentToDtoMapper {

  public static MomentResponseDTO toEntity(Moment moment) {

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String date = moment.getDate().format(dateFormat);

    MomentResponseDTO momentdto = new MomentResponseDTO(moment.getTitle(), date, moment.getDescription(),
        moment.getEmotion());

    return momentdto;
  }
}
