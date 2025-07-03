package com.ifmt.swap_class.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifmt.swap_class.dto.ProfessorDTO;
import com.ifmt.swap_class.service.ProfessorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {

  @Autowired
  private ProfessorService professorService;

  @GetMapping
  public ResponseEntity<List<ProfessorDTO>> findAll() {
    List<ProfessorDTO> list = professorService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProfessorDTO> findById(@PathVariable Long id) {
    ProfessorDTO dto = professorService.findById(id);
    return ResponseEntity.ok().body(dto);
  }

  @PostMapping
  public ResponseEntity<ProfessorDTO> insert(@Valid @RequestBody ProfessorDTO dto) {
    ProfessorDTO novo = professorService.insert(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novo.getId()).toUri();
    return ResponseEntity.created(uri).body(novo);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProfessorDTO> update(@PathVariable Long id, @Valid @RequestBody ProfessorDTO dto) {
    ProfessorDTO atualizado = professorService.update(id, dto);
    return ResponseEntity.ok().body(atualizado);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    professorService.delete(id);
    return ResponseEntity.noContent().build();
  }
}