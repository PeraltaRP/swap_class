package com.ifmt.swap_class.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifmt.swap_class.models.InstitutoFederal;

@Repository
public interface InstitutoFederalRepository extends JpaRepository<InstitutoFederal, Long> {
}