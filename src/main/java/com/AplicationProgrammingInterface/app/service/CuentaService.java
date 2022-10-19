package com.AplicationProgrammingInterface.app.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.AplicationProgrammingInterface.app.model.entity.Cuenta;

public interface CuentaService {
	
	Cuenta save(Cuenta cuenta);
	
	List<Cuenta> list();
	
	Cuenta findbyNumeroCuenta(Integer numeroCuenta);
	
	void delete(Long id) throws SQLIntegrityConstraintViolationException;

}
