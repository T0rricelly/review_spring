package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.service.dto.CityDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class CityMapperImp  {
//    @Override
//    public CityStadium toCity(CityDto cityDto) {
//        if (cityDto == null) {
//            return null;
//        }
//
//        CityStadium cityStadium = new CityStadium();
//        cityStadium.setId(cityDto.getId());
//        cityStadium.setNameCity(cityDto.getNameCity());
//        return cityStadium;
//    }

//    @Override
//    public CityDto toDto(CityStadium cityStadium) {
//        if (cityStadium == null) {
//            return null;
//        }
//
//        CityDto cityDto = new CityDto();
//        cityDto.setId(cityStadium.getId());
//        cityDto.setNameCity(cityStadium.getNameCity());
//        return cityDto;
//    }

//    @Override
//    public List<CityDto> toCityDtos(List<CityStadium> cityStadiums) {
//        List<CityDto> listDto = new ArrayList<>(cityStadiums.size());
//
//        for (CityStadium city: cityStadiums){
//            listDto.add(toDto(city));
//        }
//        return listDto;
//    }
//
//    @Override
//    public void updateCity(CityStadium cityStadium, CityDto cityDto) {
//        if (cityDto == null) return;
//
//        cityStadium.setId(cityDto.getId());
//        cityStadium.setNameCity(cityDto.getNameCity());
//    }
}
