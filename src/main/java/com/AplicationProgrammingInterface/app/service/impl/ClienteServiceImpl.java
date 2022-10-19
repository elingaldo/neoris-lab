package com.AplicationProgrammingInterface.app.service.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AplicationProgrammingInterface.app.model.entity.Cliente;
import com.AplicationProgrammingInterface.app.repository.ClienteRepository;
import com.AplicationProgrammingInterface.app.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;		
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> listado() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public void delete(Long id) throws SQLIntegrityConstraintViolationException {
		try {
			clienteRepository.deleteById(id);
		} catch (Exception e) {
			throw new SQLIntegrityConstraintViolationException("violacion de llave foranea");
		}
		
	}

}
