package com.ifmt.swap_class.dto;

import java.io.Serializable;

import com.ifmt.swap_class.models.Turma;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TurmaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;


    public TurmaDTO(Turma entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        
    }

}
