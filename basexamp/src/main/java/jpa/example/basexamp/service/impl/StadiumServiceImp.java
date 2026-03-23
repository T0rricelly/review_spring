package jpa.example.basexamp.service.impl;

import jakarta.transaction.Transactional;
import jpa.example.basexamp.advice.exceptions.ResourceExists;
import jpa.example.basexamp.advice.exceptions.ResourceNotFoundException;
import jpa.example.basexamp.entity.Stadium;
import jpa.example.basexamp.repository.StadiumRepository;
import jpa.example.basexamp.service.StadiumService;
import jpa.example.basexamp.service.dto.StadiumDto;
import jpa.example.basexamp.service.mapper.StadiumMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StadiumServiceImp implements StadiumService {
    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public StadiumServiceImp(StadiumRepository stadiumRepository, StadiumMapper stadiumMapper) {
        this.stadiumRepository = stadiumRepository;
        this.stadiumMapper = stadiumMapper;
    }

    @Override
    public List<StadiumDto> getAll() {
        return this.stadiumMapper.toStadiumDtos(this.stadiumRepository.findAll());
    }

    @Override
    public StadiumDto getById(Integer id) {
        Stadium stadium = this.stadiumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro el estadio con el id " + id));
        return this.stadiumMapper.toStadiumDto(stadium) ;
    }

    @Override
    public StadiumDto save(StadiumDto stadiumDto) {
        Stadium stadium = this.stadiumMapper.toStadium(stadiumDto);
        return this.stadiumMapper.toStadiumDto(this.stadiumRepository.save(stadium));
    }

    @Override
    public StadiumDto update(Integer id, StadiumDto stadiumDto) {
        Stadium stadium = this.stadiumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro el estadio con el id " + id));
        this.stadiumMapper.update(stadium, stadiumDto);
        return this.stadiumMapper.toStadiumDto(this.stadiumRepository.save(stadium));
    }

    @Override
    public StadiumDto deleteById(Integer id) {
        Stadium stadium = this.stadiumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro el estadio con el id " + id));
        StadiumDto stadiumDto = this.stadiumMapper.toStadiumDto(stadium);
        this.stadiumRepository.deleteById(id);
        return stadiumDto;
    }
}
