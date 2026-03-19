package jpa.example.basexamp.service.mapper;

import jpa.example.basexamp.entity.Stadium;
import jpa.example.basexamp.service.dto.StadiumDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StadiumMapperImp implements StadiumMapper{
    @Override
    public StadiumDto toStadiumDto(Stadium stadium) {
        StadiumDto stadiumDto = new StadiumDto();
        stadiumDto.setId(stadium.getId());
        stadiumDto.setNameStadium(stadium.getNameStadium());
        stadiumDto.setQuantity(stadium.getQuantity());
        return stadiumDto;
    }

    @Override
    public Stadium toStadium(StadiumDto stadiumDto) {
        Stadium stadium = new Stadium();
        stadium.setId(stadiumDto.getId());
        stadium.setNameStadium(stadiumDto.getNameStadium());
        stadium.setQuantity(stadiumDto.getQuantity());
        return stadium;
    }

    @Override
    public List<StadiumDto> toStadiumDtos(List<Stadium> stadiumList) {
        List<StadiumDto> listDtos = new ArrayList<>(stadiumList.size());

        for (Stadium stadium : stadiumList){
            listDtos.add(toStadiumDto(stadium));
        }
        return listDtos;
    }

    @Override
    public void updateStadium(Stadium stadium, StadiumDto stadiumDto) {
        if (stadiumDto == null) return;

        stadium.setId(stadiumDto.getId());
        stadium.setNameStadium(stadiumDto.getNameStadium());
        stadium.setQuantity(stadiumDto.getQuantity());
    }
}
