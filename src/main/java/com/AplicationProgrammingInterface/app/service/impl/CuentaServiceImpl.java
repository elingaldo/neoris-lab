package com.AplicationProgrammingInterface.app.service.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AplicationProgrammingInterface.app.model.entity.Cuenta;
import com.AplicationProgrammingInterface.app.repository.CuentaRepository;
import com.AplicationProgrammingInterface.app.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

	private CuentaRepository cuentaRepository;
	
	@Autowired
	private CuentaServiceImpl(CuentaRepository cuentaRepository) {
		this.cuentaRepository = cuentaRepository;
	}
	
	@Override
	public Cuenta save(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public List<Cuenta> list() {
		return (List<Cuenta>) cuentaRepository.findAll();
	}

	@Override
	public Cuenta findbyNumeroCuenta(Integer numeroCuenta) {
		return cuentaRepository.findByNumeroCuenta(numeroCuenta);
	}

	@Override
	public void delete(Long id) throws SQLIntegrityConstraintViolationException {
		try {
			cuentaRepository.deleteById(id);
		} catch (Exception e) {
			throw new SQLIntegrityConstraintViolationException("violacion de llave foranea");
		}
		
	}

	@Override
	public Cuenta cuentaById(Long id) {
		return cuentaRepository.findById(id).orElse(null);
	}

}
