package com.ifmt.swap_class.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifmt.swap_class.dto.ProfessorDTO;
import com.ifmt.swap_class.models.Professor;
import com.ifmt.swap_class.repositories.ProfessorRepository;

@Service
public class ProfessorService {

  @Autowired
  private ProfessorRepository professorRepository;


  public List<Professor> findAll(){
    List<Professor> professores = professorRepository.findAll();

    return professores;
    
  }

  public ProfessorDTO insert(ProfessorDTO dto) {
    Professor entity = new Professor();
    entity.setNome(dto.getNome());
    entity.setEmail(dto.getEmail());
    entity.setSenha(dto.getSenha());
    entity.setMatricula(dto.getMatricula());

    entity = professorRepository.save(entity);
    
    return new ProfessorDTO(entity);

  }
}
