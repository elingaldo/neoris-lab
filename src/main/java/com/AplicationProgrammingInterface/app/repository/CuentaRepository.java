package com.AplicationProgrammingInterface.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.AplicationProgrammingInterface.app.model.entity.Cuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {
	
	Cuenta findByNumeroCuenta(Integer numeroCuenta);

}
