package com.ifmt.swap_class.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifmt.swap_class.dto.ProfessorDTO;
import com.ifmt.swap_class.service.ProfessorService;

@RestController
@RequestMapping("/professores") // rota de acesso ao RestApiService de professores
public class ProfessorController {
  //encapsula uma resposta HTTP com o retorno de um objeto JSON
  @Autowired
  private ProfessorService professorService;


   @PostMapping("/novo")
    public ResponseEntity<Long> insert(@RequestBody ProfessorDTO dto) {
        dto = professorService.insert(dto);
        
        return ResponseEntity.ok().body(dto.getId());
    }
}
