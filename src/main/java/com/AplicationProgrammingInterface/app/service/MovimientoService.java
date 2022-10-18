package com.AplicationProgrammingInterface.app.service;

import com.AplicationProgrammingInterface.app.model.entity.Cuenta;
import com.AplicationProgrammingInterface.app.model.entity.Movimiento;

public interface MovimientoService {
	
	public Movimiento save(Movimiento movimiento) throws Exception;

}
