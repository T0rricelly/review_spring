package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.service.dto.CityDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper{
    CityStadium toEntity(CityDto cityDto);

    CityDto toDto(CityStadium cityStadium);

    List<CityDto> toDtos(List<CityStadium> cityStadiums);

//    void updateCity(CityStadium cityStadium, CityDto cityDto);
}
