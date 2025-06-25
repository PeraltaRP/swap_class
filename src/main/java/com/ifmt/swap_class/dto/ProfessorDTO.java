package com.ifmt.swap_class.dto;

import java.io.Serializable;

import com.ifmt.swap_class.models.Professor;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProfessorDTO implements Serializable{
  private static final long serialVersionUID = 1L;

  private Long id;
  private String nome;
  private String email;
  private String matricula;
  private CampusDTO campus;

  public ProfessorDTO(Professor entity){
    this.id = entity.getId();
    this.nome = entity.getNome();
    this.email = entity.getEmail();
    this.matricula = entity.getMatricula();
    if (entity.getCampus() != null) {
            this.campus = new CampusDTO(entity.getCampus());
        }
    
  }
}


