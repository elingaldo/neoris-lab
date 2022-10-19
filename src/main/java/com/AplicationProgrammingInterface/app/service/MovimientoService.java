package com.AplicationProgrammingInterface.app.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

import com.AplicationProgrammingInterface.app.model.entity.Movimiento;

public interface MovimientoService {
	
	Movimiento save(Movimiento movimiento) throws Exception;
	
	List<Movimiento> listado(Long idCliente, Date fechaInicio, Date fechaFin);
	
	void delete(Long id) throws SQLIntegrityConstraintViolationException;
	
	Movimiento movimientoById(Long id);
	
	Movimiento update(Movimiento movimiento);
}
