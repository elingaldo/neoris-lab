package com.AplicationProgrammingInterface.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.AplicationProgrammingInterface.app.model.entity.Movimiento;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

}
