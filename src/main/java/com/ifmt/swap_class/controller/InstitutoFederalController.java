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

import com.ifmt.swap_class.dto.InstitutoFederalDTO;
import com.ifmt.swap_class.service.InstitutoFederalService;

@RestController
@RequestMapping(value = "/institutos")
public class InstitutoFederalController {
  
  @Autowired
  private  InstitutoFederalService institutoService;

  @GetMapping(value = "/getAll")
  public ResponseEntity<List<InstitutoFederalDTO>> findAll() {
    List<InstitutoFederalDTO> list = institutoService.findAll();
    return ResponseEntity.ok().body(list);
  }
  

  // cadastrar um novo instituto federal
  @PostMapping(value = "/cadastrar")
  public ResponseEntity<InstitutoFederalDTO> insert_ComandoRegional(@RequestBody InstitutoFederalDTO dto) {
        dto = institutoService.insert(dto);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
