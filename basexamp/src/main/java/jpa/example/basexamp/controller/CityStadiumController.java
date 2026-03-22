package jpa.example.basexamp.controller;

import jakarta.validation.Valid;
import jpa.example.basexamp.entity.CityStadium;
import jpa.example.basexamp.service.dto.CityDto;
import jpa.example.basexamp.service.impl.CityStadiumServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityStadiumController {
    private final CityStadiumServiceImp cityStadiumService;

    public CityStadiumController(CityStadiumServiceImp cityStadiumService) {
        this.cityStadiumService = cityStadiumService;
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getAll() {
        return ResponseEntity.ok(this.cityStadiumService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.cityStadiumService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CityDto> save(@RequestBody @Valid CityDto cityDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.cityStadiumService.save(cityDto));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid CityDto cityDto) {
//        return ResponseEntity.ok(this.cityStadiumService.update(id, cityDto));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(this.cityStadiumService.delete(id));
    }


}
