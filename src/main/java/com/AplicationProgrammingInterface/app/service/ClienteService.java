package com.AplicationProgrammingInterface.app.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.AplicationProgrammingInterface.app.model.entity.Cliente;

public interface ClienteService {
	
	Cliente save(Cliente cliente);
	
	List<Cliente> listado();
	
	void delete(Long id) throws SQLIntegrityConstraintViolationException;

	Cliente clientById(Long id);
}
