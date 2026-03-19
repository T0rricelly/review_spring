package jpa.example.basexamp.controller;

import jpa.example.basexamp.entity.Stadium;
import jpa.example.basexamp.service.dto.StadiumDto;
import jpa.example.basexamp.service.dto.TeamDto;
import jpa.example.basexamp.service.impl.StadiumServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stadium")
public class StadiumController {

    private final StadiumServiceImp stadiumService;

    public StadiumController(StadiumServiceImp stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping
    public ResponseEntity<List<StadiumDto>> getAll() {
        return ResponseEntity.ok(this.stadiumService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (this.stadiumService.exist(id)) {
            return ResponseEntity.ok(this.stadiumService.getById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StadiumDto stadiumDto) {
        if (stadiumDto.getId() == null || !this.stadiumService.exist(stadiumDto.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.stadiumService.save(stadiumDto));
        }
            return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody StadiumDto stadiumDto){
        if (stadiumDto != null && this.stadiumService.exist(stadiumDto.getId())){
            return ResponseEntity.ok(this.stadiumService.update(id, stadiumDto));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(this.stadiumService.deleteById(id));
    }

}
