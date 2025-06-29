package com.ifmt.swap_class.dto;

import java.io.Serializable;

import com.ifmt.swap_class.models.InstitutoFederal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InstitutoFederalDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String sigla;

    public InstitutoFederalDTO(InstitutoFederal entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sigla = entity.getSigla();
    }

}
