package com.ifmt.swap_class.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifmt.swap_class.dto.ProfessorDTO;
import com.ifmt.swap_class.exception.BusinessException;
import com.ifmt.swap_class.exception.ResourceNotFoundException;
import com.ifmt.swap_class.models.Campus;
import com.ifmt.swap_class.models.Professor;
import com.ifmt.swap_class.repository.CampusRepository;
import com.ifmt.swap_class.repository.ProfessorRepository;

@Service
public class ProfessorService {

  @Autowired
  private ProfessorRepository professorRepository;

  @Autowired
  private CampusRepository campusRepository;

  @Autowired
  private PasswordService passwordService;

  @Transactional(readOnly = true)
  public List<ProfessorDTO> findAll() {
    List<Professor> list = professorRepository.findAll();
    return list.stream().map(ProfessorDTO::new).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public ProfessorDTO findById(Long id) {
    Professor professor = professorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Professor", id));
    return new ProfessorDTO(professor);
  }

  @Transactional
  public ProfessorDTO insert(ProfessorDTO dto) {
    // Verificar se email já existe
    if (professorRepository.existsByEmail(dto.getEmail())) {
      throw new BusinessException("Email já cadastrado: " + dto.getEmail());
    }

    // Buscar campus
    Campus campus = campusRepository.findById(dto.getCampus().getId())
        .orElseThrow(() -> new ResourceNotFoundException("Campus", dto.getCampus().getId()));

    Professor professor = Professor.builder()
        .nome(dto.getNome())
        .email(dto.getEmail())
        .senha(passwordService.encryptPassword(dto.getSenha()))
        .campus(campus)
        .build();

    Professor saved = professorRepository.save(professor);
    return new ProfessorDTO(saved);
  }

  @Transactional
  public ProfessorDTO update(Long id, ProfessorDTO dto) {
    Professor professor = professorRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Professor", id));

    // Verificar se email já existe (exceto para o próprio professor)
    if (!professor.getEmail().equals(dto.getEmail()) &&
        professorRepository.existsByEmail(dto.getEmail())) {
      throw new BusinessException("Email já cadastrado: " + dto.getEmail());
    }

    // Buscar campus
    Campus campus = campusRepository.findById(dto.getCampus().getId())
        .orElseThrow(() -> new ResourceNotFoundException("Campus", dto.getCampus().getId()));

    professor.setNome(dto.getNome());
    professor.setEmail(dto.getEmail());
    professor.setCampus(campus);

    // Atualizar senha apenas se fornecida
    if (dto.getSenha() != null && !dto.getSenha().isEmpty()) {
      professor.setSenha(passwordService.encryptPassword(dto.getSenha()));
    }

    Professor saved = professorRepository.save(professor);
    return new ProfessorDTO(saved);
  }

  @Transactional
  public void delete(Long id) {
    if (!professorRepository.existsById(id)) {
      throw new ResourceNotFoundException("Professor", id);
    }
    professorRepository.deleteById(id);
  }
}