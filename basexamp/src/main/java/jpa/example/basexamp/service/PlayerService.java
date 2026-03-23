package jpa.example.basexamp.service;

import jpa.example.basexamp.service.dto.PlayerDto;

import java.util.List;

public interface PlayerService {

    List<PlayerDto> getAll();

    PlayerDto getById(Integer id);

    PlayerDto save(PlayerDto playerDto);

    PlayerDto update(Integer id, PlayerDto playerDto);

    PlayerDto delete(Integer id);

}
