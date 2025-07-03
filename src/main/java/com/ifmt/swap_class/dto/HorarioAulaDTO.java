package com.ifmt.swap_class.dto;

import java.io.Serializable;
import java.time.LocalTime;

import com.ifmt.swap_class.enums.DiaSemana;
import com.ifmt.swap_class.models.HorarioAula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HorarioAulaDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private DiaSemana dia;
  private LocalTime inicio;
  private LocalTime fim;
  private String atividade;
  private ProfessorDTO professor;
  private TurmaDTO turma;

  public HorarioAulaDTO(HorarioAula entity) {
    this.id = entity.getId();
    this.dia = entity.getDia();
    this.inicio = entity.getInicio();
    this.fim = entity.getFim();
    this.atividade = entity.getAtividade();
    if (entity.getProfessor() != null) {
      this.professor = new ProfessorDTO(entity.getProfessor());
    }
    if (entity.getTurma() != null) {
      this.turma = new TurmaDTO(entity.getTurma());
    }
  }
}