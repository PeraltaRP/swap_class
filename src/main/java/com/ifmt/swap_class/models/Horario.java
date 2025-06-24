package com.ifmt.swap_class.models;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "horarios")
public class Horario implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "disciplina_id")
  private Disciplina disciplina;

  @ManyToOne
  @JoinColumn(name = "dia_id")
  private Dia_semanas dia;

  private LocalTime hora_inicio;
  private LocalTime hora_fim;

}