package com.AplicationProgrammingInterface.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.AplicationProgrammingInterface.app.model.dto.cliente.ClienteDto;
import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDto;
import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDtoClienteId;
import com.AplicationProgrammingInterface.app.model.dto.cuenta.CuentaDtoNombreCliente;
import com.AplicationProgrammingInterface.app.model.dto.movimiento.MovimientoDto;
import com.AplicationProgrammingInterface.app.model.entity.Cliente;
import com.AplicationProgrammingInterface.app.model.entity.Cuenta;
import com.AplicationProgrammingInterface.app.model.entity.Movimiento;
import com.AplicationProgrammingInterface.app.service.MapperService;

@Service
public class MapperServiceImpl implements MapperService {

	@Override
	public Cliente mapperClienteDtoToCliente(ClienteDto clienteDto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(clienteDto, Cliente.class);
	}

	@Override
	public ClienteDto mapperClienteToClienteDto(Cliente cliente) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cliente, ClienteDto.class);
	}

	@Override
	public Cuenta mapperCuentaDtoTocuenta(CuentaDto cuentaDto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cuentaDto, Cuenta.class);
	}

	@Override
	public CuentaDto mapperCuentaToCuentaDto(Cuenta cuenta) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cuenta, CuentaDto.class);
	}

	@Override
	public CuentaDtoNombreCliente mapperCuentaToCuentaDtoNombreCliente(Cuenta cuenta) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cuenta, CuentaDtoNombreCliente.class);
	}

	@Override
	public List<CuentaDtoNombreCliente> mapperListCuentaToListCuentaDtoNombreCliente(List<Cuenta> listCuenta) {
		ModelMapper modelMapper = new ModelMapper();
		List<CuentaDtoNombreCliente> dtos = listCuenta
				  .stream()
				  .map(cuenta -> modelMapper.map(cuenta, CuentaDtoNombreCliente.class))
				  .collect(Collectors.toList());
		return dtos;
	}

	@Override
	public CuentaDtoClienteId mapperCuentaToCuentaDtoClienteId(Cuenta cuenta) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(cuenta, CuentaDtoClienteId.class);
	}

	@Override
	public Movimiento mapperMovimientoToMovimientoDto(MovimientoDto movimientoDto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(movimientoDto, Movimiento.class);
	}

	@Override
	public MovimientoDto mapperMovimientoDtoToMovimiento(Movimiento movimiento) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(movimiento, MovimientoDto.class);
	}

	@Override
	public List<ClienteDto> mapperListClienteToListClienteDto(List<Cliente> listCliente) {
		ModelMapper modelMapper = new ModelMapper();
		List<ClienteDto> dtos = listCliente
				  .stream()
				  .map(cliente -> modelMapper.map(cliente, ClienteDto.class))
				  .collect(Collectors.toList());
		return dtos;
	}

}
