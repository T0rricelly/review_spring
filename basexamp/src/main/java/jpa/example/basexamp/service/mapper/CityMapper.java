package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.service.dto.CityDto;

import java.util.List;

public interface CityMapper {
    CityStadium toCity(CityDto cityDto);

    CityDto toCityDto(CityStadium cityStadium);

    List<CityDto> toCityDtos(List<CityStadium> cityStadiums);

    void updateCity(CityStadium cityStadium, CityDto cityDto);
}
