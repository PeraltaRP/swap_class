package com.ifmt.swap_class.dto;

import java.io.Serializable;

import com.ifmt.swap_class.models.InstitutoFederal;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstitutoFederalDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public InstitutoFederalDTO(InstitutoFederal entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }
}