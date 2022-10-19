package com.AplicationProgrammingInterface.app.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.AplicationProgrammingInterface.app.model.entity.Cliente;

public interface ClienteService {
	
	public Cliente save(Cliente cliente);
	
	public List<Cliente> listado();
	
	public void delete(Long id) throws SQLIntegrityConstraintViolationException;

}
