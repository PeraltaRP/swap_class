package com.ifmt.swap_class.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifmt.swap_class.dto.CampusDTO;
import com.ifmt.swap_class.models.Campus;
import com.ifmt.swap_class.repository.CampusRepository;


@Service
public class CampusService {

    @Autowired
    private CampusRepository campusRepository;

    @Transactional(readOnly = true)
    public List<CampusDTO> findAll() {
      List <Campus> list = campusRepository.findAll();
      return list.stream().map(x -> new CampusDTO(x)).collect(Collectors.toList());
    }


    @Transactional
    public CampusDTO insert(CampusDTO dto) {
      Campus entity = new Campus();
      entity.setNome(dto.getNome());
      entity = campusRepository.save(entity);
      return new CampusDTO(entity);
    }
}