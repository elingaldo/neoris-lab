package com.AplicationProgrammingInterface.app.service;

import java.util.List;

import com.AplicationProgrammingInterface.app.model.dto.cliente.ClienteDto;
import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDto;
import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDtoClienteId;
import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDtoNombreCliente;
import com.AplicationProgrammingInterface.app.model.dto.movimiento.MovimientoDto;
import com.AplicationProgrammingInterface.app.model.entity.Cliente;
import com.AplicationProgrammingInterface.app.model.entity.Cuenta;
import com.AplicationProgrammingInterface.app.model.entity.Movimiento;

public interface MapperService {
	
	// CLIENTE
	public Cliente mapperClienteDtoToCliente(ClienteDto clienteDto);

	public ClienteDto mapperClienteToClienteDto(Cliente cliente);

	//CUENTA
	public Cuenta mapperCuentaDtoTocuenta(CuentaDto cuentaDto);

	public CuentaDto mapperCuentaToCuentaDto(Cuenta cuenta);
	
	public CuentaDtoNombreCliente mapperCuentaToCuentaDtoNombreCliente(Cuenta cuenta);
	
	public CuentaDtoClienteId mapperCuentaToCuentaDtoClienteId(Cuenta cuenta);
	
	public List<CuentaDtoNombreCliente> mapperListCuentaToListCuentaDtoNombreCliente(List<Cuenta> listCuenta);
	
	//MOVIMIENTO
	
	public Movimiento mapperMovimientoToMovimientoDto(MovimientoDto movimientoDto);
	
	public MovimientoDto mapperMovimientoDtoToMovimiento(Movimiento movimiento);

}
