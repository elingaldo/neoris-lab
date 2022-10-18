package com.AplicationProgrammingInterface.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.AplicationProgrammingInterface.app.model.entity.Cuenta;
import com.AplicationProgrammingInterface.app.model.entity.Movimiento;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {
	
	public Movimiento findTop1ByCuenta(Cuenta cuenta);
	
	public Movimiento findFirstByCuentaOrderByCuentaDesc(Cuenta cuenta);
	
	@Query( value = "select * from movimientos where cuenta_id = ?1 ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public Movimiento findCuentaDesc(Long Cuenta);
	
	

}
