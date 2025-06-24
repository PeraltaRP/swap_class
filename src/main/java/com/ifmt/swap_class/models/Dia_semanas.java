package com.ifmt.swap_class.models;

import java.io.Serializable;
import java.util.List;

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


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "semana")
public class Dia_semanas  implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nome;

  @OneToMany(mappedBy = "dia")
  private List<Horario> horarios;
  
}
