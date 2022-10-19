package com.AplicationProgrammingInterface.app.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.AplicationProgrammingInterface.app.model.entity.Cuenta;

public interface CuentaService {
	
	public Cuenta save(Cuenta cuenta);
	
	public List<Cuenta> list();
	
	public Cuenta findbyNumeroCuenta(Integer numeroCuenta);
	
	public void delete(Long id) throws SQLIntegrityConstraintViolationException;

}
