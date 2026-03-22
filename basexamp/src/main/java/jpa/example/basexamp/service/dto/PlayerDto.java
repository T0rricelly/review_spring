package jpa.example.basexamp.service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotNull
    @Min(value = 1, message = "La edad debe ser mayor a 1")
    private Integer age;

    @NotBlank
    @Size(max = 50)
    private String nationality;

    @Valid
    private TeamDto teamDto;

}
