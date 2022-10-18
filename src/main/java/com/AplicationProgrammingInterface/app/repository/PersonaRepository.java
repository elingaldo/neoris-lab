package com.AplicationProgrammingInterface.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.AplicationProgrammingInterface.app.model.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
