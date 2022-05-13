package com.dsw2.ec1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsw2.ec1.model.Malla;

@Repository
public interface MallaRepository extends JpaRepository<Malla, Integer>{

}
