package dev.jesus.mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.jesus.dtos.MomentRequestDTO;
import dev.jesus.models.Moment;

public class DtoToMomentMapper {

  public static Moment toEntity(MomentRequestDTO dto) {

    String patternCodeDate = "dd/MM/yyyy";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternCodeDate);
    LocalDate dateto = LocalDate.parse(dto.date(), formatter);

    Moment moment = new Moment(dto.title(), dateto, dto.description(), dto.emotion());

    return moment;
  }

}
