package jpa.example.basexamp.service.impl;

import jakarta.transaction.Transactional;
import jpa.example.basexamp.advice.exceptions.ResourceNotFoundException;
import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.repository.CityStadiumRepository;
import jpa.example.basexamp.service.CityStadiumService;
import jpa.example.basexamp.service.dto.CityDto;
import jpa.example.basexamp.service.mapper.CityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CityStadiumServiceImp implements CityStadiumService {
    // Inyeccion de CityStadiumRepository
    private final CityStadiumRepository cityStadiumRepository;
    private CityMapper cityMapper = Mappers.getMapper(CityMapper.class);

    public CityStadiumServiceImp(CityStadiumRepository cityStadiumRepository, CityMapper cityMapper) {
        this.cityStadiumRepository = cityStadiumRepository;
        this.cityMapper = cityMapper;
    }


    @Override
    public List<CityDto> getAll() {
        return this.cityMapper.toDtos(this.cityStadiumRepository.findAll());
    }

    @Override
    public CityDto getById(Integer id) {
        return this.cityMapper.toDto(this.cityStadiumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro la ciudad con el id " + id)));
    }

    @Override
    public CityDto save(CityDto cityDto) {
        CityStadium city = this.cityMapper.toEntity(cityDto);
        return this.cityMapper.toDto(this.cityStadiumRepository.save(city));
    }

//    @Override
//    public CityDto update(Integer id, CityDto cityDto) {
//        CityStadium city = this.cityStadiumRepository.findById(id).orElse(null);
//        this.cityMapper.updateCity(city, cityDto);
//        return this.cityMapper.toCityDto(city);
//    }

    @Override
    public CityDto delete(Integer id) {
        CityStadium city = this.cityStadiumRepository.findById(id).orElse(null);
        CityDto cityDto = this.cityMapper.toDto(city);
        this.cityStadiumRepository.deleteById(id);
        return cityDto;
    }
}
