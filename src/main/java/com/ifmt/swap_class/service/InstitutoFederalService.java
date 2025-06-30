package com.ifmt.swap_class.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifmt.swap_class.dto.InstitutoFederalDTO;
import com.ifmt.swap_class.models.InstitutoFederal;
import com.ifmt.swap_class.repository.InstitutoFederalRepository;

@Service
public class InstitutoFederalService {

    @Autowired
    private InstitutoFederalRepository institutoRepository;

    @Transactional(readOnly = true)
    public List<InstitutoFederalDTO> findAll() {
      List <InstitutoFederal> list = institutoRepository.findAll();
      return list.stream().map(x -> new InstitutoFederalDTO(x)).collect(Collectors.toList());
    }

  


    @Transactional
    public InstitutoFederalDTO insert(InstitutoFederalDTO dto) {
      InstitutoFederal entity = new InstitutoFederal();
      entity.setNome(dto.getNome());
      entity = institutoRepository.save(entity);
      return new InstitutoFederalDTO(entity);
    }
}