package com.ifmt.swap_class.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifmt.swap_class.models.Campus;



@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {
}