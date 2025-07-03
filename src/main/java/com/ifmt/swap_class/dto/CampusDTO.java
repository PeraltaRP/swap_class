package com.ifmt.swap_class.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.ifmt.swap_class.models.Campus;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CampusDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String nome;
    private InstitutoFederalDTO instituto;
    private List<CursoDTO> cursos;

   

    public CampusDTO(Campus entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.instituto = new InstitutoFederalDTO(entity.getInstituto());
        this.cursos = entity.getCursos().stream()
                .map(CursoDTO::new)
                .collect(Collectors.toList());
        
    }

}
