package com.ifmt.swap_class.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;

import com.ifmt.swap_class.enums.DiaSemana;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "horarios_aula")
public class HorarioAula implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private DiaSemana dia;

  @Column(nullable = false)
  private LocalTime inicio;

  @Column(nullable = false)
  private LocalTime fim;

  @Column(nullable = false)
  private String atividade; // Ex: "Banco de Dados", "Atendimento aos Alunos"

  @ManyToOne(optional = false)
  @JoinColumn(name = "professor_id")
  private Professor professor;

  @ManyToOne
  @JoinColumn(name = "turma_id")
  private Turma turma; // pode ser null para atividades sem turma
}