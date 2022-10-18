package com.AplicationProgrammingInterface.app.service;

import java.util.List;

import com.AplicationProgrammingInterface.app.model.entity.Cuenta;

public interface CuentaService {
	
	public Cuenta save(Cuenta cuenta);
	
	public List<Cuenta> list();

}
