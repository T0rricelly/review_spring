package jpa.example.basexamp.service.impl;

import jakarta.transaction.Transactional;
import jpa.example.basexamp.advice.exceptions.ResourceNotFoundException;
import jpa.example.basexamp.entity.Team;
import jpa.example.basexamp.repository.TeamRepository;
import jpa.example.basexamp.service.TeamService;
import jpa.example.basexamp.service.dto.TeamDto;
import jpa.example.basexamp.service.mapper.TeamMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TeamServiceImp implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamServiceImp(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public List<TeamDto> getAll(){
        return this.teamMapper.toTeamDtos(this.teamRepository.findAll());
    }

    public TeamDto getById(Integer id) {
        return this.teamMapper.toTeamDto(this.teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro el equipo con el id " + id)));
    }

    public TeamDto save(TeamDto teamDto){
        Team team = this.teamMapper.toTeam(teamDto);
        return this.teamMapper.toTeamDto(this.teamRepository.save(team));
    }

    public TeamDto update(Integer id, TeamDto teamDto) {
        Team team = this.teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro un equipo con el id " + id));
        this.teamMapper.updateTeam(team,teamDto);
        return this.teamMapper.toTeamDto(this.teamRepository.save(team));
    }

    public TeamDto delete(Integer id){
        Team team = this.teamRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro un equipo con el id " + id));
        TeamDto teamDto = this.teamMapper.toTeamDto(team);
        this.teamRepository.deleteById(id);
        return teamDto;
    }
}
