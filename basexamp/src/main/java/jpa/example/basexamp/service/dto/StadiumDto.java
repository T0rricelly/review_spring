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
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class StadiumDto {

    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String nameStadium;

    @Min(10000)
    private Integer quantity;

    @Valid
    private CityDto city;

}
