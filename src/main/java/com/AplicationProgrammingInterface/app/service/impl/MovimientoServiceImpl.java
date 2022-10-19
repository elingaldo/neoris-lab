package com.AplicationProgrammingInterface.app.service.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AplicationProgrammingInterface.app.enu.TipoMovimiento;
import com.AplicationProgrammingInterface.app.model.entity.Cuenta;
import com.AplicationProgrammingInterface.app.model.entity.Movimiento;
import com.AplicationProgrammingInterface.app.repository.CuentaRepository;
import com.AplicationProgrammingInterface.app.repository.MovimientoRepository;
import com.AplicationProgrammingInterface.app.service.MovimientoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovimientoServiceImpl implements MovimientoService {

	private MovimientoRepository movimientoRepository;

	private CuentaRepository cuentaRepository;

	@Autowired
	public MovimientoServiceImpl(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository) {
		this.movimientoRepository = movimientoRepository;
		this.cuentaRepository = cuentaRepository;
	}

	@Override
	public Movimiento save(Movimiento movimiento) throws Exception {
		
		Cuenta cuenta = cuentaRepository.findByNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
		Movimiento movimientoFind = movimientoRepository.findCuentaDesc(cuenta.getId());
		movimiento.setCuenta(cuenta);
		
		
		if(movimientoFind == null) {
			
			if(movimiento.getTipoMovimiento() == TipoMovimiento.CREDITO) {
				//suma
				movimiento.setSaldo( cuenta.getSaldoInicial() + movimiento.getValor() );
			}else {
				//validar que la resta no sea menor a cero
				Integer resultado = cuenta.getSaldoInicial() - movimiento.getValor();
				if(resultado < 0) {
					log.info("Saldo no disponible");
					throw new Exception("Saldo no disponible");
				}
				//resta
				movimiento.setSaldo( resultado );
			}
		}else {
			if(movimiento.getTipoMovimiento() == TipoMovimiento.CREDITO) {
				//suma
				movimiento.setSaldo( movimientoFind.getSaldo() + movimiento.getValor() );
			}else {
				if(movimientoFind.getSaldo() == 0) {
					log.info("Saldo no disponible");
					throw new Exception("Saldo no disponible");
					}
				//validar que la resta no sea menor a cero
				Integer resultado = movimientoFind.getSaldo() - movimiento.getValor();
				if(resultado < 0) {
					log.info("Saldo no disponible");
					throw new Exception("Saldo no disponible");
				}
				//resta
				movimiento.setSaldo( movimientoFind.getSaldo() - movimiento.getValor() );
			}
		}

	return movimientoRepository.save(movimiento);
}

	@Override
	public List<Movimiento> listado(Long idCliente, Date fechaInicio, Date fechaFin) {
		return  movimientoRepository.findListado(idCliente, fechaInicio, fechaFin);
	}

	@Override
	public void delete(Long id) throws SQLIntegrityConstraintViolationException {
		try {
			movimientoRepository.deleteById(id);
		} catch (Exception e) {
			throw new SQLIntegrityConstraintViolationException("violacion de llave foranea");
		}
		
	}

	@Override
	public Movimiento movimientoById(Long id) {
		return movimientoRepository.findById(id).orElse(null);
	}

}
