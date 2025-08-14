package dev.jesus.mappers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import dev.jesus.dtos.MomentRequestDTO;
import dev.jesus.models.Moment;

public class MomentMapper {

  public static Moment toEntity(MomentRequestDTO dto) {

    String patternCodeDate = "dd/MM/yyyy";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patternCodeDate);
    LocalDate dateto = LocalDate.parse(dto.date(), formatter);

    Moment moment = new Moment(dto.title(), dateto, dto.description(), dto.emotion());

    return moment;
  }

}
