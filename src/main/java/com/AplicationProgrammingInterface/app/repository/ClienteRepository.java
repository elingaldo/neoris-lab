package com.AplicationProgrammingInterface.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.AplicationProgrammingInterface.app.model.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
