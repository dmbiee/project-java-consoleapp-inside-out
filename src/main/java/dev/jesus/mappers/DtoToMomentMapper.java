package dev.jesus.mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.jesus.dtos.MomentRequestDTO;
import dev.jesus.models.Moment;

public class DtoToMomentMapper {

  public static Moment toEntity(MomentRequestDTO dto) {

    String patternCodeDate = "dd/MM/yyyy";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternCodeDate);
    LocalDate datedto = LocalDate.parse(dto.date(), formatter);

    boolean isPositivebool = false;
    if (dto.isPositive().equalsIgnoreCase("y") || dto.isPositive().equalsIgnoreCase("yes"))
      isPositivebool = true;

    Moment moment = new Moment(dto.title(), datedto, dto.description(), dto.emotion(), isPositivebool);

    return moment;
  }

}
