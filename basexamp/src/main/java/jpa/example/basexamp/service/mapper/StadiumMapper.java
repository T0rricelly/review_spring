package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.Stadium;
import jpa.example.basexamp.service.dto.StadiumDto;

import java.util.List;

public interface StadiumMapper{

    StadiumDto toStadiumDto(Stadium stadium);

    Stadium toStadium(StadiumDto stadiumDto);

    List<StadiumDto> toStadiumDtos(List<Stadium> stadiumList);

    void updateStadium(Stadium stadium, StadiumDto stadiumDto);
}
