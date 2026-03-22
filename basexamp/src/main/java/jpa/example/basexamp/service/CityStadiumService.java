package jpa.example.basexamp.service;

import jpa.example.basexamp.service.dto.CityDto;

import java.util.List;

public interface CityStadiumService {

    List<CityDto> getAll();
//
    CityDto getById(Integer id);

    CityDto save(CityDto cityDto);

//    CityDto update(Integer id, CityDto cityDto);

    CityDto delete(Integer id);
}
