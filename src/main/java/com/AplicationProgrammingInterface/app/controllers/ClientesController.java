package com.AplicationProgrammingInterface.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AplicationProgrammingInterface.app.model.dto.cliente.ClienteDto;
import com.AplicationProgrammingInterface.app.model.entity.Cliente;
import com.AplicationProgrammingInterface.app.service.ClienteService;
import com.AplicationProgrammingInterface.app.service.MapperService;

@RestController
@RequestMapping("/api/cliente")
public class ClientesController {

	private ClienteService clienteService;

	private MapperService mapperService;

	@Autowired
	private ClientesController(ClienteService clienteService, MapperService mapperService) {
		this.clienteService = clienteService;
		this.mapperService = mapperService;
	}

	@PostMapping("/guardar")
	public ResponseEntity<ClienteDto> save(@Valid @RequestBody ClienteDto clienteDto) {
		Cliente cliente = clienteService.save(mapperService.mapperClienteDtoToCliente(clienteDto));
		return new ResponseEntity<>(mapperService.mapperClienteToClienteDto(cliente), HttpStatus.OK);
	}

}
