package jpa.example.basexamp.service.impl;

import jpa.example.basexamp.entity.Player;
import jpa.example.basexamp.repository.PlayerRepository;
import jpa.example.basexamp.service.PlayerService;
import jpa.example.basexamp.service.dto.PlayerDto;
import jpa.example.basexamp.service.mapper.PlayerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService {
    // Inyeccion de PlayerRepsoitory
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerServiceImp(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    // Obtener todos los player
    public List<PlayerDto> getAll(){
        return this.playerMapper.toPlayerDtos(this.playerRepository.findAll());
    }

    // Obtener Jugador por id
    public PlayerDto getById(Integer id){
        return this.playerMapper.toPlayerDto(this.playerRepository.findById(id).orElse(null));
    }

    public Boolean exist(Integer id){
        return this.playerRepository.existsById(id);
    }

    // Crear un player
    public PlayerDto save(PlayerDto playerDto){
        Player player = this.playerMapper.toPlayer(playerDto);
        return this.playerMapper.toPlayerDto(this.playerRepository.save(player));
    }

    public PlayerDto update(Integer id, PlayerDto playerDto){
        Player player = this.playerRepository.findById(id).orElse(null);
        this.playerMapper.updatePlayer(player, playerDto);
        return this.playerMapper.toPlayerDto(this.playerRepository.save(player));
    }

    public PlayerDto delete(Integer id){
        Player player = this.playerRepository.findById(id).orElse(null);
        PlayerDto playerDto = this.playerMapper.toPlayerDto(player);
        this.playerRepository.deleteById(id);
        return playerDto;
    }
}
