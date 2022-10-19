package com.AplicationProgrammingInterface.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.AplicationProgrammingInterface.app.model.entity.Cuenta;
import com.AplicationProgrammingInterface.app.model.entity.Movimiento;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {
	
	Movimiento findTop1ByCuenta(Cuenta cuenta);
	
	Movimiento findFirstByCuentaOrderByCuentaDesc(Cuenta cuenta);
	
	@Query( value = "select * from movimientos where cuenta_id = ?1 ORDER BY id DESC LIMIT 1", nativeQuery = true)
	Movimiento findCuentaDesc(Long Cuenta);
	
	@Query( value = "select * from movimientos m, cuentas c, clientes cl  where m.cuenta_id = c.id and c.cliente_id = cl.id and cl.id = ?1 and fecha between ?2 and ?3 ", nativeQuery = true)
	List<Movimiento> findListado(Long idCliente, Date fechaInicio, Date fechaFin);

}


