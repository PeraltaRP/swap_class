package com.ifmt.swap_class.dto;

import java.io.Serializable;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HorarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

   
}