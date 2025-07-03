package com.ifmt.swap_class.dto;

import java.io.Serializable;

import com.ifmt.swap_class.models.Professor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfessorDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String nome;
  private String email;
  private String senha;
  private CampusDTO campus;

  public ProfessorDTO(Professor entity) {
    this.id = entity.getId();
    this.nome = entity.getNome();
    this.email = entity.getEmail();
    this.senha = entity.getSenha(); // Em produção, não retornar senha
    if (entity.getCampus() != null) {
      this.campus = new CampusDTO(entity.getCampus());
    }
  }
}