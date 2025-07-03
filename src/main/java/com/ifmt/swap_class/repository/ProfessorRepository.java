package com.ifmt.swap_class.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifmt.swap_class.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

  boolean existsByEmail(String email);

  Professor findByEmail(String email);
}