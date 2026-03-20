package jpa.example.basexamp.controller;

import jakarta.validation.Valid;
import jpa.example.basexamp.service.impl.PlayerServiceImp;
import jpa.example.basexamp.service.dto.PlayerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    private final PlayerServiceImp playerService;

    public PlayerController(PlayerServiceImp playerService) {
        this.playerService = playerService;
    }

    // Obtener todos los players
    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAll() {
        return ResponseEntity.ok(this.playerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (this.playerService.exist(id)) {
            return ResponseEntity.ok(this.playerService.getById(id));
        }
        return ResponseEntity.badRequest().body("No se encontro");
    }

    @PostMapping
    public ResponseEntity<PlayerDto> save(@RequestBody @Valid PlayerDto playerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.playerService.save(playerDto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid PlayerDto playerDto) {
        if (playerDto.getId() != null && this.playerService.exist(playerDto.getId())) {
            return ResponseEntity.ok(this.playerService.update(id, playerDto));
        }
        return ResponseEntity.badRequest().body("No se encontro");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        if (this.playerService.exist(id)) {
            return ResponseEntity.ok(this.playerService.delete(id));
        }
        return ResponseEntity.badRequest().body("No se encontro");
    }

}
