package dev.jesus.mappers;

import java.util.List;
import java.util.stream.Collectors;

import dev.jesus.dtos.MomentResponseDTO;
import dev.jesus.models.Moment;

public class MomentToDtoMapper {

  public static MomentResponseDTO toDto(Moment moment) {
    return new MomentResponseDTO(
        moment.getTitle(),
        moment.getDate(),
        moment.getDescription(),
        moment.getEmotion(),
        moment.isPositive());
  }

  public static List<MomentResponseDTO> toDtoList(List<Moment> moments) {
    return moments.stream()
        .map(MomentToDtoMapper::toDto) // equals to .map(moment -> MomentToDtoMapper.toDto(moment))
        .collect(Collectors.toList());
  }
}
