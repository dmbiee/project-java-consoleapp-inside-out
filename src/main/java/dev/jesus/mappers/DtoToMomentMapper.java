package dev.jesus.mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.models.Moment;

public class DtoToMomentMapper {

  public static Moment toEntity(MomentResponseDTO dto) {

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // String datedto = dto.date().formatted(dateFormat);
    LocalDate dateDto = LocalDate.parse(dto.date(), dateFormat);

    Moment moment = new Moment(dto.title(), dateDto, dto.description(), dto.emotion());

    return moment;
  }

}
