package jpa.example.basexamp.service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class TeamDto {

    private Integer id;

    @NotBlank
    @Size(max = 30)
    private String nameTeam;
    @Valid
    private StadiumDto stadium;


}
