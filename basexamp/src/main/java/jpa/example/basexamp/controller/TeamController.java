package jpa.example.basexamp.controller;

import jakarta.validation.Valid;
import jpa.example.basexamp.service.impl.TeamServiceImp;
import jpa.example.basexamp.service.dto.TeamDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    private final TeamServiceImp teamService;

    public TeamController(TeamServiceImp teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAll() {
        return ResponseEntity.ok(this.teamService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.teamService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TeamDto> save(@RequestBody @Valid TeamDto teamDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.teamService.save(teamDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid TeamDto teamDto) {
        return ResponseEntity.ok().body(this.teamService.update(id, teamDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeamDto> deleteById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(this.teamService.delete(id));
    }
}
