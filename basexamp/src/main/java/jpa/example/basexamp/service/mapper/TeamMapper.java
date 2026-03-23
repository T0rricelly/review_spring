package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.Team;
import jpa.example.basexamp.service.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface TeamMapper {

    Team toTeam(TeamDto teamDto);

    TeamDto toTeamDto(Team team);

    List<TeamDto> toTeamDtos(List<Team> teams);

    @Mapping(source = "stadium", target = "stadium")
    void updateTeam(@MappingTarget Team team, TeamDto teamDto);
}
