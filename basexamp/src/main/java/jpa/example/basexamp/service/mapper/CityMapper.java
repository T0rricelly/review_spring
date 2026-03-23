package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.service.dto.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper{
    CityStadium toEntity(CityDto cityDto);

    CityDto toDto(CityStadium cityStadium);

    List<CityDto> toDtos(List<CityStadium> cityStadiums);
    @Mapping(source = "nameCity", target = "nameCity")
    void update(@MappingTarget CityStadium cityStadium, CityDto cityDto);

}
