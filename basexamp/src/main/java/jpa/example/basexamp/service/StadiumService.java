package jpa.example.basexamp.service;

import jpa.example.basexamp.service.dto.StadiumDto;

import java.util.List;

public interface StadiumService {

    List<StadiumDto> getAll();

    StadiumDto getById(Integer id);

    StadiumDto save(StadiumDto stadiumDto);

    StadiumDto update(Integer id, StadiumDto stadiumDto);

    StadiumDto deleteById(Integer id);

}
