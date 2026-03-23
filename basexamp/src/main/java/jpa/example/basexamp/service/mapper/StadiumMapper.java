package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.Stadium;
import jpa.example.basexamp.service.dto.StadiumDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StadiumMapper{

//    @Mapping(source = "cityStadium", target = "city")
    StadiumDto toStadiumDto(Stadium stadium);

//    @Mapping(source = "cityStadium", target = "cityStadium")
    Stadium toStadium(StadiumDto stadiumDto);

    List<StadiumDto> toStadiumDtos(List<Stadium> stadiumList);

    @Mapping(source = "city", target = "city")
    void update(@MappingTarget Stadium stadium, StadiumDto stadiumDto);

}
