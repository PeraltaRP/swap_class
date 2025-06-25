package com.ifmt.swap_class.models;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name = "disciplinas_turmas")
public class DisciplinaTurma implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  private Professor professor;

  @ManyToOne
  private Turma turma;

  @ManyToOne
  private Disciplina disciplina;

  @OneToMany(mappedBy = "disciplinaTurma", cascade = CascadeType.ALL)
  private List<Horario> horarios;

 
}
