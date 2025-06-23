package com.ifmt.swap_class.dto;

import java.io.Serializable;

import com.ifmt.swap_class.models.Professor;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProfessorDTO implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "nome", nullable = false)
  private String nome;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "matricula", nullable = false)
  private String matricula;

  public ProfessorDTO(Professor entity){
    this.id = entity.getId();
    this.nome = entity.getNome();
    this.email = entity.getEmail();
    this.matricula = entity.getMatricula();
  }
}
