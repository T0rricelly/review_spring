package jpa.example.basexamp.service.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(max = 50)
    private String nameStadium;

    @Min(10000)
    private Integer quantity;
}
