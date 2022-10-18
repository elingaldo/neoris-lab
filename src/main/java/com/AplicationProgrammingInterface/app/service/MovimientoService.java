package com.AplicationProgrammingInterface.app.service;

import java.util.Date;
import java.util.List;

import com.AplicationProgrammingInterface.app.model.entity.Movimiento;

public interface MovimientoService {
	
	public Movimiento save(Movimiento movimiento) throws Exception;
	
	public List<Movimiento> listado(Long idCliente, Date fechaInicio, Date fechaFin);
	

}
