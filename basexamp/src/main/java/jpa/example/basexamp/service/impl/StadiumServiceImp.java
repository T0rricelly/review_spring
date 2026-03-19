package jpa.example.basexamp.service.impl;

import jakarta.transaction.Transactional;
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
        Stadium stadium = this.stadiumRepository.findById(id).orElse(null);
        return this.stadiumMapper.toStadiumDto(stadium);
    }

    @Override
    public StadiumDto save(StadiumDto stadiumDto) {
        Stadium stadium = this.stadiumMapper.toStadium(stadiumDto);
        return this.stadiumMapper.toStadiumDto(this.stadiumRepository.save(stadium));
    }

    @Override
    public StadiumDto update(Integer id, StadiumDto stadiumDto) {
        Stadium stadium = this.stadiumRepository.findById(id).orElse(null);
        this.stadiumMapper.updateStadium(stadium, stadiumDto);
        return this.stadiumMapper.toStadiumDto(this.stadiumRepository.save(stadium));
    }

    @Override
    public StadiumDto deleteById(Integer id) {
        Stadium stadium = this.stadiumRepository.findById(id).orElse(null);
        StadiumDto stadiumDto = this.stadiumMapper.toStadiumDto(stadium);
        this.stadiumRepository.deleteById(id);
        return stadiumDto;
    }

    public Boolean exist(Integer id){
        return this.stadiumRepository.existsById(id);
    }
}
