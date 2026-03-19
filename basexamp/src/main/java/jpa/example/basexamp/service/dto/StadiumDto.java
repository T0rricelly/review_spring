package jpa.example.basexamp.service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StadiumDto {

    private Integer id;

    private String nameStadium;

    private Integer quantity;
}
