package com.ifmt.swap_class.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor

public enum DiaSemana{
  SEGUNDA("Segunda-feira"),
  TERCA("Terça-feira"),  
  QUARTA("Quarta-feira"),
  QUINTA("Quinta-feira"),
  SEXTA("Sexta-feira"),
  SABADO("Sábado"),
  DOMINGO("Domingo");

  private  String descricao;

   public static DiaSemana fromNome(String nome) {
        return Arrays.stream(values())
                .filter(d -> d.descricao.equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dia da semana inválido: " + nome));
    }
  
}
