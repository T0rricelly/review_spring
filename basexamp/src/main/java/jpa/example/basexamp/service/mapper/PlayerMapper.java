package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.Player;
import jpa.example.basexamp.service.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    // PlayerDto a Player
    @Mapping(source = "teamDto", target = "team")
    Player toPlayer(PlayerDto playerDto);

    // Player a PlayerDto
    @Mapping(source = "team", target = "teamDto")
    PlayerDto toPlayerDto(Player player);

    // Lista de Player a PlayerDto
    List<PlayerDto> toPlayerDtos(List<Player> players);

    // Actualizar Cliente
//    void updatePlayer(Player player, PlayerDto playerDto);
}
