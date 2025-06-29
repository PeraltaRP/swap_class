package com.ifmt.swap_class.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import com.ifmt.swap_class.models.Curso;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
   private List<TurmaDTO> turmas;

    public CursoDTO(Curso entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.turmas = entity.getTurmas().stream()
                .map(TurmaDTO::new)
                .collect(Collectors.toList());
        
    }

}
