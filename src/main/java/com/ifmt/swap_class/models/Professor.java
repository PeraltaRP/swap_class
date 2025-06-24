package com.ifmt.swap_class.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "professores")

public class Professor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "nome", nullable = false)
  private String nome;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "matricula", nullable = false)
  private String matricula;

  @Column(name = "senha", nullable = false)
  private String senha;

  @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)  private List<DisciplinaTurma> atribuicoes = new ArrayList<>();
}
