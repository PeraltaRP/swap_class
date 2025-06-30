package com.ifmt.swap_class.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifmt.swap_class.dto.CampusDTO;
import com.ifmt.swap_class.models.Campus;
import com.ifmt.swap_class.models.Curso;
import com.ifmt.swap_class.models.InstitutoFederal;
import com.ifmt.swap_class.models.Turma;
import com.ifmt.swap_class.repository.CampusRepository;
import com.ifmt.swap_class.repository.InstitutoFederalRepository;


@Service
public class CampusService {

    @Autowired
    private CampusRepository campusRepository;

       @Autowired
    private InstitutoFederalRepository institutoRepository;

    @Transactional(readOnly = true)
    public List<CampusDTO> findAll() {
      List <Campus> list = campusRepository.findAll();
      return list.stream().map(x -> new CampusDTO(x)).collect(Collectors.toList());
    }


    @Transactional
    public CampusDTO insert(CampusDTO dto) {
       InstitutoFederal instituto = institutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instituto não encontrado"));

        Campus campus = new Campus();
        campus.setNome(dto.getNome());
        campus.setInstituto(instituto);

        List<Curso> cursos = new ArrayList<>();

        for (CursoDTO cursoDTO : dto.getCursos()) {
            Curso curso = new Curso();
            curso.setNome(cursoDTO.getNome());
            curso.setCampus(campus);

            List<Turma> turmas = cursoDTO.getTurmas().stream().map(turmaDTO -> {
                Turma turma = new Turma();
                turma.setNome(turmaDTO.getNome());
                turma.setCurso(curso);
                return turma;
            }).collect(Collectors.toList());

            curso.setTurmas(turmas);
            cursos.add(curso);
        }

        campus.setCursos(cursos);
        Campus salvo = campusRepository.save(campus);

        return new CampusDTO(salvo);
    }
    
}