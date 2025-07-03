package com.ifmt.swap_class.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifmt.swap_class.dto.CampusDTO;
import com.ifmt.swap_class.service.CampusService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/campi")
public class CampusController {

  @Autowired
  private CampusService campusService;

  @GetMapping(value = "/getAll")
  public ResponseEntity<List<CampusDTO>> findAll() {
    List<CampusDTO> list = campusService.findAll();
    return ResponseEntity.ok().body(list);
  }

  // Cadastrar novo campus com cursos e turmas
  @PostMapping(value = "{id}/cadastrar")
  public ResponseEntity<CampusDTO> insert(@Valid @RequestBody CampusDTO dto) {
    CampusDTO novo = campusService.insert(dto, 0);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novo.getId()).toUri();
    return ResponseEntity.created(uri).body(novo);
  }

}
