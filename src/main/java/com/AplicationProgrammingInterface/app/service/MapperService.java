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
	Cliente mapperClienteDtoToCliente(ClienteDto clienteDto);

	ClienteDto mapperClienteToClienteDto(Cliente cliente);

	List<ClienteDto> mapperListClienteToListClienteDto(List<Cliente> listCliente);

	// CUENTA
	Cuenta mapperCuentaDtoTocuenta(CuentaDto cuentaDto);

	CuentaDto mapperCuentaToCuentaDto(Cuenta cuenta);

	CuentaDtoNombreCliente mapperCuentaToCuentaDtoNombreCliente(Cuenta cuenta);

	CuentaDtoClienteId mapperCuentaToCuentaDtoClienteId(Cuenta cuenta);

	List<CuentaDtoNombreCliente> mapperListCuentaToListCuentaDtoNombreCliente(List<Cuenta> listCuenta);

	// MOVIMIENTO

	Movimiento mapperMovimientoToMovimientoDto(MovimientoDto movimientoDto);

	MovimientoDto mapperMovimientoDtoToMovimiento(Movimiento movimiento);

}
